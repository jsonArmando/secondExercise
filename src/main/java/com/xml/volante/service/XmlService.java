package com.xml.volante.service;

import com.xml.volante.entity.Xml;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class XmlService {

    public void toConsune(String xml) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new ByteArrayInputStream(xml.getBytes()));
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName(doc.getDocumentElement().getNodeName());
        Node root = nList.item(0);
        processNode(root, doc);

    }
    private void processNode(Node inputNode, Document doc) {
        for (int i = 0; i < inputNode.getChildNodes().getLength(); ++i) {
            Node node = inputNode.getChildNodes().item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                if(!node.getNodeName().equals("nombre")){
                    System.out.print(doc.getDocumentElement().getNodeName()+"/" + node.getNodeName());
                } else {
                    System.out.println();
                }
                processNode(node,doc);
            }
        }
    }
}

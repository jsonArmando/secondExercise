package com.xml.volante.controller;

import com.xml.volante.entity.Xml;
import com.xml.volante.service.XmlService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Slf4j
public class XmlController {

    private XmlService xmlService;

    @RequestMapping(value = "/path", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<List<String>> consumeXml(@RequestBody String xml) throws ParserConfigurationException, IOException, SAXException {
        xmlService.toConsune(xml);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

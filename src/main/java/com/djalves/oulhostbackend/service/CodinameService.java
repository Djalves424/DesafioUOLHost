package com.djalves.oulhostbackend.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class CodinameService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment env;

    private List<String> avangersCodenameList = new ArrayList<>();
    private List<String> justiceLeagueList = new ArrayList<>();

    ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void loadJsonData() {

        try {
            String codenameResponse = restTemplate.getForObject(env.getProperties().getProperty("avangers"), String.class);
            JsonNode jsonNode = objectMapper.readTree(codenameResponse);

            ArrayNode avangers = (ArrayNode) jsonNode.get("vingadores");

            for (JsonNode item : avangers) {
                this.avangersCodenameList.add(item.get("codeName").asText());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void loadXmlData() {

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(env.getProperties().getProperty("justice_league"));

            NodeList codenameList = document.getElementsByTagName("codename");

            for (int i = 0; i < codenameList.getLength(); i++) {
                Element codinameElement = (Element) codenameList.item(i);
                String codename = codinameElement.getTextContent();
                this.justiceLeagueList.add(codename);
            }


        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}

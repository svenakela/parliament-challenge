package com.parliamentchallenge.merger.resource;

import com.parliamentchallenge.merger.MergerApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.TransformerException;

import java.io.IOException;

import java.net.URL;
import java.text.ParseException;
import java.util.*;

@ResponseBody
@RequestMapping("/speeches")
public class MergedResource {


    @GetMapping("/test")
    public String test() throws IOException, SAXException, ParserConfigurationException, ParseException {
        Document doc = getAnforandeLista();
        NodeList anforande = doc.getElementsByTagName("anforande");
        String json = "";
        for (int i = 0; i < anforande.getLength(); i++) {
            NodeList nl = anforande.item(i).getChildNodes();
            Speech s = extractData(nl);

            json += s.toString() + "\n";
        }
        return json;
    }

    private Document getDocument(URL url) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        return factory.newDocumentBuilder().parse(url.openStream());
    }

    private Document getAnforandeLista() throws IOException, SAXException, ParserConfigurationException {
        URL url = new URL("http://data.riksdagen.se/anforandelista/?anftyp=Nej&sz=10");
        return getDocument(url);
    }

    private Document getLedamot(String intressentId) throws IOException, SAXException, ParserConfigurationException {
        URL url = new URL("http://data.riksdagen.se/personlista/?iid=" + intressentId);
        return getDocument(url);
    }

    private Speech extractData(NodeList nl) throws ParserConfigurationException, SAXException, IOException, ParseException {
        Speech.SpeechBuilder sb = new Speech.SpeechBuilder();
        for (int j = 0; j < nl.getLength(); j++) {

            NodeList n = nl;
            for (int i = 0; i < n.getLength(); i++) {
                Node item = n.item(i);
                switch (item.getNodeName()) {
                    case "intressent_id": {
                        sb.withIID(item.getTextContent());
                        buildLedamot(getLedamot(item.getTextContent()), sb);
                        break;

                    }
                    case "dok_datum": {
                        sb.withDate(item.getTextContent());
                        break;

                    }
                    case "parti": {
                        sb.withAffiliation(item.getTextContent());
                        break;

                    }
                    case "kammaraktivitet": {
                        sb.withSubject(item.getTextContent());
                        break;

                    }
                    case "protokoll_url_www": {
                        sb.withSpeechURL(new URL(item.getTextContent()));
                        break;

                    }
                    case "talare": {
                        List<String> name = Arrays.asList(item.getTextContent().split(" "));
                        sb.withName(name.get(name.size() - 3) + " " + name.get(name.size() - 2));
                        break;

                    }
                }
            }
        }


        return sb.build();
    }

    public MergedResource() {
    }

    private void buildLedamot(Document doc, Speech.SpeechBuilder sb) throws IOException {
        // Fetch data from second API endpoint
        NodeList image = doc.getElementsByTagName("bild_url_80");
        NodeList personlista = doc.getElementsByTagName("person").item(0).getChildNodes();
        for (int i = 0; i < personlista.getLength(); i++) {

            Node item = personlista.item(i);
            if ("valkrets".equals(item.getNodeName())) {
                sb.withConstituency(item.getTextContent());
            }

        }


        sb.withImg(new URL(image.item(0).getTextContent()));
        NodeList personuppgifter = doc.getElementsByTagName("uppgift");

        for (int i = 0; i < personuppgifter.getLength(); i++) {
            Node item = personuppgifter.item(i);
            if(item.getTextContent().contains("e-postadress")) {
                NodeList childNodes = item.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    if(childNodes.item(j).getTextContent().contains("[på]")) {
                        sb.withEmail(childNodes.item(j).getTextContent().replaceFirst("\\[på\\]", "@"));
                    }

                }
            }
        }


    }

}

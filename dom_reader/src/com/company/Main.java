package com.company;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class Main {

    public static void main(String argv[]) throws ParserConfigurationException, SAXException, IOException {
        ReadDomXml readDomXml=new ReadDomXml();
        VideoGames games =readDomXml.getGameList();
        createXML(games);
    }

    private static void createXML(VideoGames games) {
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(VideoGames.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(games, new File("dom.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


}

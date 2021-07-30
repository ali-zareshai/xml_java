package com.company;

import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            InputStream    xmlInput  =
                    new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\company\\videogames.xml");

            SAXParser saxParser = factory.newSAXParser();
            XmlReader handler   = new XmlReader();
            saxParser.parse(xmlInput, handler);

            List<Game> games =handler.getResult();
            Game[] gameArray =new Game[games.size()];
            for(int i=0;i<games.size();i++){
                gameArray[i] =games.get(i);
            }
            Arrays.sort(gameArray);

            for (Game game:gameArray){
                if(game.getPlatform().equalsIgnoreCase("PSP")) {
                    System.out.println(game.getId()+";"+game.getName()+";"+game.getPublisher()+";"+game.getGenre()+";"+game.getYearOfRelease());
                }
            }
        } catch (Throwable err) {
            err.printStackTrace ();
        }
    }

}

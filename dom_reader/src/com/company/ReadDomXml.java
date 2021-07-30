package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ReadDomXml {
    private List<Game> gameList;
    public ReadDomXml(){
        gameList =new ArrayList<>();
    }
    public VideoGames getGameList() throws SAXException, IOException, ParserConfigurationException {
        File xmlFile = new File(System.getProperty("user.dir")+"\\src\\com\\company\\videogames.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("game");

        for (int i = 0; i < nList.getLength(); i++) {
            Game game =new Game();
            Node nNode = nList.item(i);


            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) nNode;

//                game.setId(Integer.parseInt(elem.getAttribute("id")));
                game.setName(elem.getElementsByTagName("name").item(0).getTextContent());
                game.setPlatform(elem.getElementsByTagName("platform").item(0).getTextContent());
                game.setYearOfRelease(elem.getElementsByTagName("year_of_release").item(0).getTextContent());
                game.setGenre(elem.getElementsByTagName("genre").item(0).getTextContent());
                game.setPublisher(elem.getElementsByTagName("publisher").item(0).getTextContent());
                game.setDeveloper(elem.getElementsByTagName("developer").item(0).getTextContent());

                Element salesChilds =(Element)elem.getElementsByTagName("sales").item(0);
                double naVal =Double.parseDouble(salesChilds.getElementsByTagName("na_sales").item(0).getTextContent());
                double euVal =Double.parseDouble(salesChilds.getElementsByTagName("eu_sales").item(0).getTextContent());
                double jpVal =Double.parseDouble(salesChilds.getElementsByTagName("jp_sales").item(0).getTextContent());
                double otVal =Double.parseDouble(salesChilds.getElementsByTagName("other_sales").item(0).getTextContent());
                game.setSales(new DecimalFormat("0.00").format(naVal+euVal+jpVal+otVal));

                Element reviewChilds =(Element)elem.getElementsByTagName("review_scores").item(0);
                double criticCount =Double.parseDouble(reviewChilds.getElementsByTagName("critic_count").item(0).getTextContent());
                double criticScore =Double.parseDouble(reviewChilds.getElementsByTagName("critic_score").item(0).getTextContent());
                double userScore   =Double.parseDouble(reviewChilds.getElementsByTagName("user_score").item(0).getTextContent());
                double userCount   =Double.parseDouble(reviewChilds.getElementsByTagName("user_count").item(0).getTextContent());

                double avgScore =(criticScore*criticCount + userCount*userScore)/(criticCount+userCount);
                game.setReviewScores(getNameScore((int)avgScore));

                gameList.add(game);
            }
        }

        VideoGames videoGames =new VideoGames();
        videoGames.setGameList(gameList);
        return videoGames;
    }

    private String getNameScore(int score){
        if(score>=0 && score<20){
            return "very negative";
        }else if(score>=20 && score<40){
            return "mostly negative";
        }else if(score>=40 && score<60){
            return "mixed";
        }else if(score>=60 && score<80){
            return "mostly positive";
        }else if(score>=80 && score<=100){
            return "very positive";
        }else {
            return "not range:"+score;
        }
    }
}

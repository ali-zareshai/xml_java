package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class XmlReader extends DefaultHandler {
    private StringBuilder currentValue = new StringBuilder();
    private Game game;
    private Game.Sales sales;
    private Game.ReviewScores reviewScores;
    List<Game> result;

    public List<Game> getResult() {
        return result;
    }

    @Override
    public void startDocument() {
        result = new ArrayList<>();
    }

    @Override
    public void startElement(
            String uri,
            String localName,
            String qName,
            Attributes attributes) {

        currentValue.setLength(0);

        if (qName.equalsIgnoreCase("game")) {
            String id = attributes.getValue("id");
            game =new Game();
            sales =new Game.Sales();
            reviewScores =new Game.ReviewScores();
            game.setId(Integer.parseInt(id));
        }
    }

    public void endElement(String uri,
                           String localName,
                           String qName) {

        if(qName.equalsIgnoreCase("name")){
            game.setName(currentValue.toString());
        }else if(qName.equalsIgnoreCase("platform")){
            game.setPlatform(currentValue.toString());
        }else if(qName.equalsIgnoreCase("year_of_release")){
            game.setYearOfRelease(currentValue.toString());
        }else if(qName.equalsIgnoreCase("genre")){
            game.setGenre(currentValue.toString());
        }else if(qName.equalsIgnoreCase("publisher")){
            game.setPublisher(currentValue.toString());
        }else if(qName.equalsIgnoreCase("developer")){
            game.setDeveloper(currentValue.toString());
        }else if(qName.equalsIgnoreCase("rating")){
            game.setRating(currentValue.toString());
        }else if(qName.equalsIgnoreCase("platform_type")){
            game.setPlatformType(currentValue.toString());
        }else if(qName.equalsIgnoreCase("na_sales")){
            sales.setNaSales(currentValue.toString());
        }else if(qName.equalsIgnoreCase("eu_sales")){
            sales.setEuSales(currentValue.toString());
        }else if(qName.equalsIgnoreCase("jp_sales")){
            sales.setJpSales(currentValue.toString());
        }else if(qName.equalsIgnoreCase("other_sales")){
           sales.setOtherSales(currentValue.toString());
        }else if(qName.equalsIgnoreCase("critic_score")){
            reviewScores.setCriticScore(currentValue.toString());
        }else if(qName.equalsIgnoreCase("critic_count")){
            reviewScores.setCriticCount(currentValue.toString());
        }else if(qName.equalsIgnoreCase("user_score")){
            reviewScores.setUserScore(currentValue.toString());
        }else if(qName.equalsIgnoreCase("user_count")){
            reviewScores.setUserCount(currentValue.toString());
        }else if(qName.equalsIgnoreCase("game")){
            game.setSales(sales);
            game.setReviewScores(reviewScores);
            result.add(game);
        }



    }

    public void characters(char ch[], int start, int length) {
        currentValue.append(ch, start, length);

    }
}

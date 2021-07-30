package com.company;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Game{
    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "platform")
    private String platform;

    @XmlElement(name = "year_of_release")
    private String yearOfRelease;

    @XmlElement(name = "genre")
    private String genre;

    @XmlElement(name = "publisher")
    private String publisher;

    @XmlElement(name = "developer")
    private String developer;

    @XmlElement(name = "global_sales")
    private String globalSales;

    @XmlElement(name = "review_scores")
    private String reviewScores;

    public Game() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getSales() {
        return globalSales;
    }

    public void setSales(String sales) {
        this.globalSales = sales;
    }

    public String getReviewScores() {
        return reviewScores;
    }

    public void setReviewScores(String reviewScores) {
        this.reviewScores = reviewScores;
    }

}

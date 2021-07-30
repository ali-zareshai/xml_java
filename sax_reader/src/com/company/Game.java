package com.company;

public class Game implements Comparable<Game>{
    private int id;
    private String name;
    private String platform;
    private String yearOfRelease;
    private String genre;
    private String publisher;
    private String developer;
    private String rating;
    private String platformType;
    private Sales sales;
    private ReviewScores reviewScores;

    public Game() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        this.platformType = platformType;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public ReviewScores getReviewScores() {
        return reviewScores;
    }

    public void setReviewScores(ReviewScores reviewScores) {
        this.reviewScores = reviewScores;
    }

    @Override
    public int compareTo(Game o) {
        int compareId = ((Game) o).getId();
        return this.id - compareId;
    }

    public static class Sales{
        private String naSales;
        private String euSales;
        private String jpSales;
        private String otherSales;

        public Sales() {
        }

        public String getNaSales() {
            return naSales;
        }

        public void setNaSales(String naSales) {
            this.naSales = naSales;
        }

        public String getEuSales() {
            return euSales;
        }

        public void setEuSales(String euSales) {
            this.euSales = euSales;
        }

        public String getJpSales() {
            return jpSales;
        }

        public void setJpSales(String jpSales) {
            this.jpSales = jpSales;
        }

        public String getOtherSales() {
            return otherSales;
        }

        public void setOtherSales(String otherSales) {
            this.otherSales = otherSales;
        }
    }

    public static class ReviewScores{
        private String criticScore;
        private String criticCount;
        private String userScore;
        private String userCount;

        public ReviewScores() {
        }

        public String getCriticScore() {
            return criticScore;
        }

        public void setCriticScore(String criticScore) {
            this.criticScore = criticScore;
        }

        public String getCriticCount() {
            return criticCount;
        }

        public void setCriticCount(String criticCount) {
            this.criticCount = criticCount;
        }

        public String getUserScore() {
            return userScore;
        }

        public void setUserScore(String userScore) {
            this.userScore = userScore;
        }

        public String getUserCount() {
            return userCount;
        }

        public void setUserCount(String userCount) {
            this.userCount = userCount;
        }
    }
}

package com.company;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "video_games")
public class VideoGames {
    private List<Game> gameList;

    public VideoGames() {
    }

    @XmlElement(name = "game")
    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }
}

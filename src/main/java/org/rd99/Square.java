package org.rd99;

import java.util.List;

public class Square {
    List<Player> players;
    int value;
    boolean hasSnake ;
    boolean hasLadder ;
    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    public boolean isHasSnake() {
        return hasSnake;
    }
    public void setHasSnake(boolean hasSnake) {
        this.hasSnake = hasSnake;
    }
    public boolean isHasLadder() {
        return hasLadder;
    }
    public void setHasLadder(boolean hasLadder) {
        this.hasLadder = hasLadder;
    }

}

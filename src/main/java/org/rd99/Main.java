package org.rd99;

public class Main {
    public static void main(String[] args) {
        System.out.println("welcome to snakes/ladders");
        Game game = new Game();
        game.initializeGame();
        game.startGame();
    }
}
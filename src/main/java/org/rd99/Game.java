package org.rd99;

import java.util.*;

public class Game {

    Board board;
    List<Player> rankings;

    List<Player> players;
    int currentTurn;
    int noOfPlayers;

    Game() {
        rankings = new ArrayList<>();
        players = new ArrayList<>();
        board = new Board();
        currentTurn = 0;
    }

    public void addPlayer(String name) {
        Player newPlayer = new Player(name);
        newPlayer.setId(players.size());
        players.add(newPlayer);
        System.out.printf("player %s added - ", newPlayer.getName());
    }

    public int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public void initializeGame() {
        System.out.println("enter no. of players playing - ");
        Scanner scanner = new Scanner(System.in);
        int playerNo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter all players name");
        for (int i = 1; i <= playerNo; i++) {
            String name = scanner.nextLine();
            addPlayer(name);
        }
        noOfPlayers = players.size();
    }

    public void startGame() {
        int rankedPlayers = 0;

        while (rankedPlayers < noOfPlayers) {
            System.out.println(currentTurn + Arrays.toString(players.toArray()));
            while (players.get(currentTurn) == null) {
                currentTurn += 1;
                currentTurn %= noOfPlayers;
            }
            int diceNum = rollDice();
            int currPosOfPlayer = players.get(currentTurn).playerPosition;
            if (currPosOfPlayer + diceNum > 100) {
                currentTurn++;
                currentTurn %= noOfPlayers;
                continue;
            }
            if (currPosOfPlayer + diceNum == 100) {
                rankings.add(players.get(currentTurn));
                players.set(currentTurn, null);
                currentTurn++;
                currentTurn %= noOfPlayers;
                rankedPlayers++;
                continue;
            }
            if (board.board[currPosOfPlayer + diceNum].hasLadder) {
                int newPostionOfPlayer = board.ladders.ladders.get(board.board[currPosOfPlayer + diceNum].value);
                players.get(currentTurn).setPlayerPosition(newPostionOfPlayer);
                currentTurn++;
                currentTurn %= noOfPlayers;
                continue;
            }
            if (board.board[currPosOfPlayer + diceNum].hasSnake) {
                int newPostionOfPlayer = board.snakes.snakes.get(board.board[currPosOfPlayer + diceNum].value);
                players.get(currentTurn).setPlayerPosition(newPostionOfPlayer);
                currentTurn++;
                currentTurn %= noOfPlayers;
                continue;
            }
            players.get(currentTurn).setPlayerPosition(currPosOfPlayer + diceNum);
            currentTurn++;
            currentTurn %= noOfPlayers;
        }

        System.err.println("Game Over");
        System.out.println("Rankings - ");
        for (int i = 0; i < rankings.size(); i++) {
            System.out.printf("%d - %s\n", i + 1, rankings.get(i).getName());
        }
    }
}

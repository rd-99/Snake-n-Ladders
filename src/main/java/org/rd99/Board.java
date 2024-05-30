package org.rd99;

import org.rd99.LaderObject.Ladders;
import org.rd99.SnakeObject.Snakes;

public class Board {
    Square[] board;
    Ladders ladders;
    Snakes snakes;

    Board() {
        board = new Square[100];
        for (int i = 0; i < 100; i++) {
            board[i] = new Square();
            board[i].value = i;
            board[i].hasLadder = false;
            board[i].hasSnake = false;
        }
        ladders = new Ladders();
        snakes = new Snakes();
    }

    public void addSnake(int start, int end) {
        board[start].hasSnake = true;
        snakes.addSnake(start, end);
    }

    public void addLadder(int start, int end) {
        board[start].hasLadder = true;
        ladders.addLadder(start, end);
    }

}

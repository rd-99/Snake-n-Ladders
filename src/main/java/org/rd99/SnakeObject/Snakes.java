package org.rd99.SnakeObject;

import java.util.*;

public class Snakes {
    public Map<Integer, Integer> snakes; // List of snakes

    public Snakes() {
        snakes = new HashMap<>();
    }

    public void addSnake(int start, int end) {
        snakes.put(start, end);
    }
}

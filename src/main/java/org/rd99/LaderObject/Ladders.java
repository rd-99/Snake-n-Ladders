package org.rd99.LaderObject;

import java.util.*;

public class Ladders {
    public Map<Integer, Integer> ladders; // List of ladders

    public Ladders() {
        ladders = new HashMap<>();
    }

    public void addLadder(int start, int end) {
        ladders.put(start, end);
    }
}

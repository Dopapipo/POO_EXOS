package fr.pantheonsorbonne.cri;

import java.util.Scanner;

public abstract class Player {
    private String name;
    private int score;
    Scanner scanner = new Scanner(System.in);
    public Player(String name) {
        this.setName(name);
        this.setScore(0);
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getNumberInput() {
        int toReturn;
        do {
            toReturn = scanner.nextInt();
        }
        while (isValidNumber(toReturn));
        return toReturn;
    }

    public int[] getPositionInput() {
        int x;
        int y;
        do {
             x = scanner.nextInt();
             y = scanner.nextInt();
        }
        while (!isValidPosition(x)||!isValidPosition(y));
        return new int[]{x,y};
    }

    public abstract boolean isValidNumber(int x);
    public abstract boolean isValidPosition(int y);

}
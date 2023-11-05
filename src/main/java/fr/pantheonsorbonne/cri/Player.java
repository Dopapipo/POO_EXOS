package fr.pantheonsorbonne.cri;

import java.util.Scanner;

public class Player {
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
        System.out.println("Enter number: ");
        toReturn = scanner.nextInt();
        return toReturn;
    }

    public int[] getPositionInput() {
        int x;
        int y;
        System.out.println("Enter x position: ");
         x = scanner.nextInt();
         System.out.println("Enter y position: ");
         y = scanner.nextInt();
        return new int[]{x,y};
    }

}
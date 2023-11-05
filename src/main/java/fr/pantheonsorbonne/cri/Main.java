package fr.pantheonsorbonne.cri;

public class Main {
    public static void main(String[] args) {
        Player[] players = new Player[2];
        players[0] = new Player("Player 1");
        players[1] = new Player("Player 2");
        Atteindre10 game = new Atteindre10(players);
        game.play();
    }
}

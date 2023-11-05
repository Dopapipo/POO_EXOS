package fr.pantheonsorbonne.cri;

import java.util.ArrayList;
import java.util.List;

public abstract class GameAbstract {
    protected Player[] players;
    protected Player currentPlayer;
    protected  int gridSize;
    protected Grid grid;
    protected List<Integer> availableNumbers;
    /*
     * On specific games that inherit from this, call super(players,3,new int[]{1,2,3,4,5,6,7,8,9}), or new int[] {-1,1} etc...
     */
    public GameAbstract(Player[] players,List<Integer> availableNumbers) {
        this.players=players;
        this.gridSize=3;
        this.grid= new Grid(gridSize);
        this.availableNumbers=new ArrayList<>();
    }
      public void printGrid() {
            for (int i = 0; i < gridSize; i++) {
                for (int j = 0; j < gridSize; j++) {
                    System.out.print(grid.getCellValue(i, j) + " ");
                }
                System.out.println();
            }
        }
   
    public abstract boolean makeMove(int row, int col, int number);
    /*
     * Check if the game is finished
     */
    protected abstract boolean isGameFinished();
    /*
     * Main play game loop
     */
    protected abstract void play();
    /*
     * Print the winner
     */
    protected abstract void printWinner();
    /*
     * Check if the number chosen by a player is valid
     */
    protected abstract boolean isValidNumber(int x);
    /*
     * Check if the position chosen by a player is valid
     */
    protected abstract boolean isValidPosition(int y);
    /*
     * Check if any player has won on the last move made
     */
    protected abstract boolean checkForWinner(int row, int col, int number);
}

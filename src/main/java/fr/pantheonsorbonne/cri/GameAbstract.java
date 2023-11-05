package fr.pantheonsorbonne.cri;


public abstract class GameAbstract {
    Player[] players;
    int gridSize;
    int[][] grid;
    int[] availableNumbers;
    /*
     * On specific games that inherit from this, call super(players,3,new int[]{1,2,3,4,5,6,7,8,9}), or new int[] {-1,1} etc...
     */
    public GameAbstract(Player[] players,int gridSize,int[] availableNumbers) {
        this.players=players;
        this.gridSize=gridSize;
        this.grid=new int[gridSize][gridSize];
        this.availableNumbers=availableNumbers;
    }
      public void printGrid() {
            for (int i = 0; i < gridSize; i++) {
                for (int j = 0; j < gridSize; j++) {
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }
        }
    public void makeMove(int x, int y, int number) {
        this.grid[x][y]=number;
    }
    /*
     * Check if the game is finished
     */
    public abstract boolean isGameFinished();
    /*
     * Main play game loop
     */
    public abstract void play();
    /*
     * Print the winner
     */
    public abstract void printWinner();
    /*
     * Check if the number chosen by a player is valid
     */
    public abstract boolean isValidNumber(int x);
    /*
     * Check if the position chosen by a player is valid
     */
    public abstract boolean isValidPosition(int y);
    /*
     * Check if any player has won on the last move made
     */
    public abstract boolean checkForWinner(int row, int col, int number);
}

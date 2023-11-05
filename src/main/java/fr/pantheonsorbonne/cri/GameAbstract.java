package fr.pantheonsorbonne.cri;


public abstract class GameAbstract {
    Player[] players;
    int gridSize;
    int[][] grid;
    int[] availableNumbers;
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

    public abstract boolean isGameFinished();
    public abstract void play();
    public abstract void printWinner();
    public abstract boolean isValidNumber(int x);
    public abstract boolean isValidPosition(int y);
    public abstract boolean checkForWinner(int row, int col, int number);
}

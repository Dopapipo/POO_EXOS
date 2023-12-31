package fr.pantheonsorbonne.cri;
import java.util.ArrayList;
import java.util.Random;

public class Atteindre10 extends GameAbstract{
    private Player currentPlayer;
    Random random = new Random();
    
    public Atteindre10(Player[] players ) {
        super(players,new ArrayList<>());
        for (int i = 1;i<10;i++){
            this.availableNumbers.add(i);
        }
        currentPlayer = (random.nextBoolean()) ? this.players[0] : this.players[1];

    }

    public boolean makeMove(int row, int col, int number) {
        if (grid.isCellEmpty(row, col) && this.availableNumbers.contains(number)) {
            grid.setCellValue(row, col, number);
            this.availableNumbers.remove(Integer.valueOf(number));
            if (checkForWinner(row, col, number)) {
                printWinner();
                return true;
            } else {
                currentPlayer = (currentPlayer == this.players[0]) ? this.players[1] : this.players[0];
            }
        }
        return false;
    }
    @Override
     protected boolean checkForWinner(int row, int col, int number) {
        int sum = 0;

        for (int c = 0; c < 3; c++) {
            sum += grid.getCellValue(row, c);
        }
        if (sum == 10) {
            return true;
        }

        sum = 0;

        for (int r = 0; r < 3; r++) {
            sum += grid.getCellValue(r, col);
        }
        if (sum == 10) {
            return true;
        }

        if (row == col) {
            sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += grid.getCellValue(i, i);
            }
            if (sum == 10) {
                return true;
            }
        }

        if (row + col == 2) {
            sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += grid.getCellValue(i, 2 - i);
            }
            if (sum == 10) {
                return true;
            }
        }

        return false;
    }

    public Grid getGrid() {
        return grid;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameFinished() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid.isCellEmpty(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void play() {
        for (;;) {
            this.printGrid();
            int[] position;
            int number;
            System.out.println(currentPlayer.getName() + "'s turn");
            do {
                position = currentPlayer.getPositionInput();
                }
            while (!isValidPosition(position[0]) || !isValidPosition(position[1]));
            do {
                number = currentPlayer.getNumberInput();
               }
            while (!this.isValidNumber(number)); 
                if (makeMove(position[0], position[1], number)) {
                    break;
                }

            }
            grid.clearGrid();
    }

    @Override
    public void printWinner() {
         System.out.println(currentPlayer.getName() + " has won !");

    }

    @Override
    public boolean isValidNumber(int x) {
        return this.availableNumbers.contains(x);
    }

    @Override
    public boolean isValidPosition(int y) {
        return y>=0 && y<3;
    }

}

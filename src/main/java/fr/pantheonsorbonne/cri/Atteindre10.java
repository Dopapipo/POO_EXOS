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
            if (checkForWinner(row, col, number)) {
                System.out.println(currentPlayer.getName() + " a gagné !");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }

    @Override
    public void printWinner() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printWinner'");
    }

    @Override
    public boolean isValidNumber(int x) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isValidNumber'");
    }

    @Override
    public boolean isValidPosition(int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isValidPosition'");
    }

}

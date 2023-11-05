package fr.pantheonsorbonne.cri;

public class Grid {
    private int[][] cells;

    public Grid(int gridSize) {
        cells = new int[gridSize][gridSize];
    }

    public int getCellValue(int row, int col) {
        return cells[row][col];
    }

    public void setCellValue(int row, int col, int value) {
        cells[row][col] = value;
    }

    public boolean isCellEmpty(int row, int col) {
        return cells[row][col] == 0;
    }

    public void clearGrid() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = 0;
            }
        }
    }
}
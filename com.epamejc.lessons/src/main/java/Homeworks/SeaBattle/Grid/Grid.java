package Homeworks.SeaBattle.Grid;

public class Grid {
    // 10x10 + letters and row nums
    // enum a b c d e f g h i j k (0-10)
    int[][] grid;

    public Grid() {
        grid = new int[11][11];
    }

    public void printGrid() {
        for (int row = 0; row < grid.length; row++) {
            if (row == 0) {
                System.out.print("   ");
                Letters[] letters = Letters.values();
                for(Letters letter : letters) {
                    System.out.print(letter + " ");
                }
            }
            for (int col = 0; col < grid.length; col++) {
                if (col == 0 && row != 0) {
                    if (row < 10) {
                        System.out.print(" ");
                    }
                    System.out.print(row + " ");
                } else {
                    if (row != 0) {
                        System.out.print(grid[row][col] + " ");
                    }
                }
            }
            System.out.println("");
        }
    }
}

import java.util.Scanner;

public class Grid {
    private int rows;
    private int cols;
    private boolean[][] grid;
    private int start;
    private int end;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new boolean[rows][cols];
    }

    // Constructor to get user input for rows and columns
    public Grid() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        this.rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        this.cols = scanner.nextInt();
        this.grid = new boolean[rows][cols];
    }

    public void generateGrid() {
        System.out.println("Grid:");
        int cellNumber = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(cellNumber + "\t");
                cellNumber++;
            }
            System.out.println();
        }
    }

    public void setUserInput(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}

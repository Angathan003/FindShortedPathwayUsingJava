import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = 0, cols = 0, numObstacles = 0, start = 0, end = 0;

        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter number of rows for the grid: ");
                rows = scanner.nextInt();
                System.out.print("Enter number of columns for the grid: ");
                cols = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear the invalid input
            }
        }

        // Create Grid instance with user input
        Grid grid = new Grid(rows, cols);
        grid.generateGrid();

        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the number of obstacles: ");
                numObstacles = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear the invalid input
            }
        }

        // Place obstacles randomly
        ObstaclePlacer.placeObstaclesRandomly(grid, numObstacles);

        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter start number: ");
                start = scanner.nextInt();
                System.out.print("Enter end number: ");
                end = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear the invalid input
            }
        }

        // Set user input
        grid.setUserInput(start, end);

        // Find and print the shortest path
        int[] shortestPath = ShortestPathFinder.findShortestPath(grid, start, end);
        PathPrinter.printShortestPath(grid, shortestPath, start, end);
    }
}

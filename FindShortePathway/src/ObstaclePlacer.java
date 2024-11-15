import java.util.Random;

public class ObstaclePlacer {
    public static void placeObstaclesRandomly(Grid grid, int numObstacles) {
        Random random = new Random();
        boolean[][] gridArray = grid.getGrid();
        int rows = grid.getRows();
        int cols = grid.getCols();

        // Place obstacles randomly in the grid
        for (int i = 0; i < numObstacles; i++) {
            int row = random.nextInt(rows); // Random row
            int col = random.nextInt(cols); // Random column
            gridArray[row][col] = true;
        }
    }
}

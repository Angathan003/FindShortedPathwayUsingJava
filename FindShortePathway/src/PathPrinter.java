public class PathPrinter {
    public static void printShortestPath(Grid grid, int[] shortestPath, int start, int end) {
        int rows = grid.getRows();
        int cols = grid.getCols();
        boolean[][] gridArray = grid.getGrid();

        System.out.println("Shortest Path:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int cellNumber = i * cols + j + 1;
                if (contains(shortestPath, cellNumber)) {
                    if (cellNumber == start) {
                        System.out.print("S\t");
                    } else if (cellNumber == end) {
                        System.out.print("E\t");
                    } else {
                        System.out.print("*\t"); // Path cell
                    }
                } else if (gridArray[i][j]) {
                    System.out.print("X\t"); // Obstacle
                } else {
                    System.out.print(cellNumber + "\t"); // Empty cell
                }
            }
            System.out.println();
        }
    }

    private static boolean contains(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}

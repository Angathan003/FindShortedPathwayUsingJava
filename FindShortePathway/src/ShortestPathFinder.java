import java.util.Arrays;

public class ShortestPathFinder {
    public static int[] findShortestPath(Grid grid, int start, int end) {
        int rows = grid.getRows();
        int cols = grid.getCols();
        boolean[][] gridArray = grid.getGrid();

        int[] queue = new int[rows * cols];
        boolean[][] visited = new boolean[rows][cols];
        int[][] parent = new int[rows][cols];
        int front = 0, rear = 0;

        queue[rear++] = start;
        visited[(start - 1) / cols][(start - 1) % cols] = true;

        while (front < rear) {
            int current = queue[front++];
            if (current == end) {
                break;
            }

            int row = (current - 1) / cols;
            int col = (current - 1) % cols;

            int[] dx = {0, 1, 0, -1}; // Directional offsets for rows
            int[] dy = {-1, 0, 1, 0}; // Directional offsets for columns

            for (int i = 0; i < 4; i++) {
                int newRow = row + dx[i];
                int newCol = col + dy[i];
                int newCell = newRow * cols + newCol + 1;

                if (isValidCell(newRow, newCol, rows, cols) && !visited[newRow][newCol] && !gridArray[newRow][newCol]) {
                    queue[rear++] = newCell;
                    visited[newRow][newCol] = true;
                    parent[newRow][newCol] = current;
                }
            }
        }

        // Reconstruct path using parent array
        Stack shortestPath = new Stack(rows * cols);
        int currentNode = end;
        while (currentNode != start) {
            shortestPath.push(currentNode);
            int row = (currentNode - 1) / cols;
            int col = (currentNode - 1) % cols;
            currentNode = parent[row][col];
        }
        shortestPath.push(start);

        // Convert stack to array
        int[] pathArray = new int[shortestPath.size()];
        int index = 0;
        while (!shortestPath.isEmpty()) {
            pathArray[index++] = shortestPath.pop();
        }
        return pathArray;
    }

    private static boolean isValidCell(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}

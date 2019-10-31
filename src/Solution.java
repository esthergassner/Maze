import java.util.ArrayList;
import java.util.Stack;

class Solution
{
    private Maze maze;
    private Stack<Cell> cellStack = new Stack<>();

    Solution(Maze maze)
    {
        this.maze = maze;
    }

     boolean solveDepthFirst(int row, int col, ArrayList<Cell> visitedCells)
    {
        System.out.println(row + ", " + col);
        Cell current = maze.getCells()[row][col];
        if (!visitedCells.contains(current)) //if cell was never visited
        {
            visitedCells.add(current);

            // if we've reached the exit
            if (row == (maze.getMAZE_DIMENSION() - 1) && col == (maze.getMAZE_DIMENSION() - 1))
            {
                System.out.println("solved.");
                return true;
            }

            //otherwise, let's keep searching
            return (current.getBottWall() == 0 && solveDepthFirst(row + 1, col, visitedCells)) ||
                    (current.getRiteWall() == 0 && solveDepthFirst(row, col + 1, visitedCells)) ||
                    (current.getTopWall() == 0 && solveDepthFirst(row - 1, col, visitedCells)) ||
                    (current.getLeftWall() == 0 && solveDepthFirst(row, col - 1, visitedCells));
        }
        else
        {
            return false;
        }
    }
}

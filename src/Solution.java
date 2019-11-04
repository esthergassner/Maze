import java.util.ArrayList;

class Solution
{
    private Maze maze;

    Solution(Maze maze)
    {
        this.maze = maze;
    }

     boolean solveDepthFirst(int row, int col, ArrayList<Cell> visitedCells)
    {
        Cell current = maze.getCells()[row][col];
        if (!visitedCells.contains(current)) //if cell was never visited
        {
            maze.getCells()[row][col].setSolution();
            visitedCells.add(current);

            // if we've reached the exit
            if (row == (maze.getMAZE_DIMENSION() - 1) && col == (maze.getMAZE_DIMENSION() - 1))
            {
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

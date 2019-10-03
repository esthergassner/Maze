import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Maze
{
    private final int MAZE_DIMENSION = 30;
    private Cell[][] cells = new Cell[MAZE_DIMENSION][MAZE_DIMENSION];
    private int unvisitedCount = 0;
    private Cell current;
    private Random unvisitedNeighborIx = new Random();
    private Stack<Cell> cellStack = new Stack<>();

    Cell[][] getCells()
    {
        return cells;
    }

    void generateMaze()
    {
        current = cells[0][0];
        cells[0][0].setVisited();
        unvisitedCount--;
        while (unvisitedCount > 0)
        {
            current.setUnvisitedNeighbors(findUnvisitedNeighbors());
            if (current.UnvisitedNeighborsCount() > 0) //current cell has unvisited neighbors
            {
                int ix = unvisitedNeighborIx.nextInt(current.UnvisitedNeighborsCount());
                Cell next = current.getUnvisitedNeighbors().get(ix); //get a random unvisited neighbor
                removeWall(next);
                if (current.UnvisitedNeighborsCount() > 1)
                {
                    cellStack.push(current);
                }
                current = next;
                cells[current.getRow()][current.getCol()].setVisited();
                unvisitedCount--;
            }

            else if (!cellStack.isEmpty())
            {
                current = cellStack.pop();
            }
        }
    }

    private void removeWall(Cell next)
    {
        int rowDif = current.getRow() - next.getRow();
        int colDif = current.getCol() - next.getCol();
        if (colDif == 1) //next is to current's left
        {
            cells[current.getRow()][current.getCol()].setLeftWall(0);
            cells[next.getRow()][next.getCol()].setRiteWall(0);
        }
        else if (colDif == -1) //next is to current's right
        {
            cells[current.getRow()][current.getCol()].setRiteWall(0);
            cells[next.getRow()][next.getCol()].setLeftWall(0);
        }
        else if (rowDif == 1) //next is above current
        {
            cells[current.getRow()][current.getCol()].setTopWall(0);
            cells[next.getRow()][next.getCol()].setBottWall(0);
        }
        else if (rowDif == -1) //next is below current
        {
            cells[current.getRow()][current.getCol()].setBottWall(0);
            cells[next.getRow()][next.getCol()].setTopWall(0);
        }
    }

    private ArrayList<Cell> findUnvisitedNeighbors()
    {
        ArrayList<Cell> unvisitedNeighbors = new ArrayList<>();
        int curX = current.getRow();
        int curY = current.getCol();

        if (curX > 0 && !cells[curX - 1][curY].isVisited())
        {
            unvisitedNeighbors.add(cells[curX - 1][curY]);
        }
        if (curX < (MAZE_DIMENSION - 1) && !cells[curX + 1][curY].isVisited())
        {
            unvisitedNeighbors.add(cells[curX + 1][curY]);
        }
        if (curY > 0 && !cells[curX][curY - 1].isVisited())
        {
            unvisitedNeighbors.add(cells[curX][curY - 1]);
        }
        if (curY < (MAZE_DIMENSION - 1) && !cells[curX][curY + 1].isVisited())
        {
            unvisitedNeighbors.add(cells[curX][curY + 1]);
        }
        return unvisitedNeighbors;
    }

    void setUpCells()
    {
        for (int ix = 0; ix < MAZE_DIMENSION; ++ix)
        {
            for (int iy = 0; iy < MAZE_DIMENSION; ++iy)
            {
                Cell toAdd = new Cell(ix, iy);
                cells[ix][iy] = toAdd;
                unvisitedCount++;
            }
        }
    }

    void setEntranceAndExit()
    {
        cells[0][0].setLeftWall(0);
        cells[MAZE_DIMENSION - 1][MAZE_DIMENSION - 1].setRiteWall(0);
    }

    int getMAZE_DIMENSION()
    {
        return MAZE_DIMENSION;
    }
}

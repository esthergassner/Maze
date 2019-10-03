import java.util.ArrayList;

class Cell
{
    private boolean visited;
    private int row;
    private int col;
    private ArrayList<Cell> unvisitedNeighbors;
    private int topWall = 2;
    private int bottWall = 2;
    private int riteWall = 2;
    private int leftWall = 2;

    int getTopWall()
    {
        return topWall;
    }

    void setTopWall(int topWall)
    {
        this.topWall = topWall;
    }

    int getBottWall()
    {
        return bottWall;
    }

    void setBottWall(int bottWall)
    {
        this.bottWall = bottWall;
    }

    int getRiteWall()
    {
        return riteWall;
    }

    void setRiteWall(int riteWall)
    {
        this.riteWall = riteWall;
    }

    int getLeftWall()
    {
        return leftWall;
    }

    void setLeftWall(int leftWall)
    {
        this.leftWall = leftWall;
    }

    Cell(int row, int col)
    {
        this.visited = false;
        this.row = row;
        this.col = col;
    }

    void setVisited()
    {
        this.visited = true;
    }

    boolean isVisited()
    {
        return visited;
    }

    int getRow()
    {
        return row;
    }

    int getCol()
    {
        return col;
    }

    void setUnvisitedNeighbors(ArrayList<Cell> unvisitedNeighbors)
    {
        this.unvisitedNeighbors = unvisitedNeighbors;
    }

    ArrayList<Cell> getUnvisitedNeighbors()
    {
        return unvisitedNeighbors;
    }

    int UnvisitedNeighborsCount()
    {
        return unvisitedNeighbors.size();
    }
}

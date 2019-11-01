import java.util.ArrayList;

class Cell
{
    private boolean visited;
    private boolean solution;

    public boolean isSolution()
    {
        return solution;
    }

    public void setSolution(boolean solution)
    {
        this.solution = solution;
    }

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

    void removeTopWall()
    {
        this.topWall = 0;
    }

    int getBottWall()
    {
        return bottWall;
    }

    void removeBottWall()
    {
        this.bottWall = 0;
    }

    int getRiteWall()
    {
        return riteWall;
    }

    void removeRiteWall()
    {
        this.riteWall = 0;
    }

    int getLeftWall()
    {
        return leftWall;
    }

    void removeLeftWall()
    {
        this.leftWall = 0;
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

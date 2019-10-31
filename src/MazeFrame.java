import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

class MazeFrame extends JFrame
{
    MazeFrame()
    {
        setTitle("Maze");
        setSize(1500, 1500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Maze maze = new Maze();
        maze.setUpCells();
        maze.setEntranceAndExit();
        maze.generateMaze();

        JPanel root = new JPanel();
        setUpContents(root, maze);
        root.setLayout(new GridLayout(maze.getMAZE_DIMENSION(), maze.getMAZE_DIMENSION()));
        setContentPane(root);

        Solution solution = new Solution(maze);
        solution.solveDepthFirst(0,0, new ArrayList<Cell>());
    }

    private void setUpContents(JPanel root, Maze maze)
    {
        int dimension = maze.getMAZE_DIMENSION();
        Cell[][] cells = maze.getCells();

        for (int ix = 0; ix < dimension; ++ix)
        {
            for (int iy = 0; iy < dimension; ++iy)
            {
                Cell currentCell = cells[ix][iy];

                JPanel panel = new JPanel();
                panel.setBackground(new Color(134, 255, 238));
                if (ix == 0 && iy == 0)
                {
                    panel.setBackground(new Color(27, 133, 123));
                    panel.add(new JLabel("<html><br/>ENTER--></html>"));
                }
                else if ((ix == (dimension - 1)) && (iy == (dimension - 1)))
                {
                    panel.setBackground(new Color(27, 133, 123));
                    panel.add(new JLabel("<html><br/>EXIT--></html>"));
                }
                Border currBorders = BorderFactory.createMatteBorder(currentCell.getTopWall(),
                        currentCell.getLeftWall(),
                        currentCell.getBottWall(),
                        currentCell.getRiteWall(),
                        Color.BLACK);
                panel.setBorder(currBorders);
                panel.setSize(7, 7);
                root.add(panel);
            }
        }
    }
}

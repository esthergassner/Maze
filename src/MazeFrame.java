import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

class MazeFrame extends JFrame
{
    private Maze maze = new Maze();
    private JPanel root = new JPanel();

    MazeFrame()
    {
        setTitle("Maze");
        setSize(1500, 1500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        maze.setUpCells();
        maze.setEntranceAndExit();
        maze.generateMaze();

        JPanel mazePanel = setUpMazePanel(maze);

        root.setLayout(new BorderLayout());
        root.add(mazePanel, BorderLayout.CENTER);

        JButton solverButton = setUpSolverButton(mazePanel);

        root.add(solverButton, BorderLayout.SOUTH);
        setContentPane(root);
    }

    private JButton setUpSolverButton(JPanel mazePanel)
    {
        JButton solverButton = new JButton("Show Solution");
        solverButton.setBackground(Color.YELLOW);
        solverButton.addActionListener(e ->
        {
            root.remove(mazePanel);
            Solution solution = new Solution(maze);
            solution.solveDepthFirst(0,0, new ArrayList<Cell>());
            JPanel solutionPanel = setUpMazePanel(maze);
            root.add(solutionPanel, BorderLayout.CENTER);
            setContentPane(root);
        });
        return solverButton;
    }

    private JPanel setUpMazePanel(Maze maze)
    {
        JPanel returnPanel = new JPanel();
        returnPanel.setLayout(new GridLayout(maze.getMAZE_DIMENSION(), maze.getMAZE_DIMENSION()));
        int dimension = maze.getMAZE_DIMENSION();
        Cell[][] cells = maze.getCells();

        for (int ix = 0; ix < dimension; ++ix)
        {
            for (int iy = 0; iy < dimension; ++iy)
            {
                Cell currentCell = cells[ix][iy];

                JPanel panel = new JPanel();
                panel.setBackground(currentCell.isSolution() ? new Color(198, 255, 240) : new Color(134, 255, 238));
                if (ix == 0 && iy == 0)
                {
                    panel.add(new JLabel("<html><br/>ENTER--></html>"));
                }
                else if ((ix == (dimension - 1)) && (iy == (dimension - 1)))
                {
                    panel.add(new JLabel("<html><br/>EXIT--></html>"));
                }
                Border currBorders = BorderFactory.createMatteBorder(currentCell.getTopWall(),
                        currentCell.getLeftWall(),
                        currentCell.getBottWall(),
                        currentCell.getRiteWall(),
                        Color.BLACK);
                panel.setBorder(currBorders);
                panel.setSize(7, 7);
                returnPanel.add(panel);
            }
        }
        return returnPanel;
    }
}

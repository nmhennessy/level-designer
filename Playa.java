import java.awt.*;

public class Playa extends PaletteSingleItem
{
    
    public Playa(int x, int y)
    {
        super(x, y);
        width = 1;
        height = 1;
    }

    public void paint (Graphics g)
    {
        Color tempColour = g.getColor();
        if (selected) {
            g.setColor(Color.red);
        } else {
            g.setColor(Color.black);
        }
        g.fillOval(x * CELL, y * CELL, CELL + 4, CELL + 4);
        g.setColor(tempColour);
    }

    public void writeToGrid(int[][] gameState)
    {
        gameState[x][y] = 0;
    }

}
import java.awt.*;

public class Road extends PaletteItem
{
    
    Color colour = Color.yellow;
    
    public Road(int a, int b)
    {
        super(a, b);
        width = 1;
        height = 1;    
    }

    public void paint (Graphics g)
    {
        g.setColor(colour);
        g.fillRect (x * CELL, y * CELL, width * CELL, height * CELL);
        if (selected) {
            g.setColor(Color.red);
        } else {
            g.setColor(Color.black);
        }
        g.drawRect (x * CELL, y * CELL, width * CELL, height * CELL);
    }
    
    public void writeToBoard (int xcoord, int ycoord, int[][] gameState)
    {
        gameState[xcoord][ycoord] = 0;
    }


}
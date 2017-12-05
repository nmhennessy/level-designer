import java.awt.*;

public class Powerup extends PaletteSingleItem
{
    Color colour;
    boolean onCanvas;
    int gameStateColour;
    
    public Powerup(int x, int y, int width, int height, Color colour, int gameStateColour)
    {
        super(x, y);
        this.colour = colour;
        this.width = width;
        this.height = height;
        this.gameStateColour = gameStateColour;
    }

    public void paint (Graphics g)
    {
        Color tempColour = g.getColor();
        g.setColor(colour);
        g.fillRect (x * CELL, y * CELL, width * CELL, height * CELL);
        if (selected) {
            g.setColor(Color.red);
        } else {
            g.setColor(Color.black);
        }
        g.drawRect(x * CELL, y * CELL, width * CELL, height * CELL);
        g.setColor(tempColour);
    }

    public void writeToGrid(int[][] gameState)
    {
        for (int i = x; i < x + width; i += 1)
        {
            for (int j = y; j < y + height; j += 1)
            {
                gameState[i][j] = 0;
                gameState[i][j] = gameState[i][j] | LevelDesigner.GS_POWERUP;
                gameState[i][j] = gameState[i][j] | gameStateColour;
            }
        }
    }
}
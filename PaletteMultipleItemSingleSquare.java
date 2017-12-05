import java.awt.*;

public class PaletteMultipleItemSingleSquare extends PaletteItem
{
    
    Color colour;
    int gameStateCode;
    
    public PaletteMultipleItemSingleSquare(int a, int b, Color colour, int code)
    {
        super(a, b);
        this.colour = colour;
        width = 1;
        height = 1;    
        gameStateCode = code;
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
        gameState[xcoord][ycoord] = gameStateCode;
    }

}
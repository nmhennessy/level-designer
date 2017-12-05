import java.awt.*;

abstract public class PaletteSingleItem extends PaletteItem
{
    
    public PaletteSingleItem(int x, int y)
    {
        super(x, y);
    }

    public void writeToBoard (int xcoord, int ycoord, int[][] m_gameState)
    {
        x = xcoord;
        y = ycoord;
    }

    abstract public void writeToGrid(int[][] gameState);

}
import java.awt.*;

abstract public class PaletteItem
{
    int x, y, originX, originY, width, height;
    public static final int CELL = 12;
    boolean selected = false;
    
    public PaletteItem(int x, int y)
    {
        this.x = x;
        this.y = y;
        originX = x;
        originY = y;
    }

    public boolean intersect(int xpos, int ypos)
    {
        if (xpos >= x * CELL && xpos <= (x + width) * CELL
            && ypos >= y * CELL && ypos <= (y + height) * CELL)
            return true;
        return false;
    }
    
    public boolean collision(int xcoord, int ycoord, PaletteItem thing)
    {
        int x1, x2, y1, y2;
        if (this.equals(thing))
            return false;
        if (x < xcoord) {
            x1 = x;
        } else {
            x1 = xcoord;
        }
        if (x + width > xcoord + thing.width) {
            x2 = x + width;
        } else {
            x2 = xcoord + thing.width;
        }
        if (y < ycoord) {
            y1 = y;
        } else {
            y1 = ycoord;
        }
        if (y + height > ycoord + thing.height) {
            y2 = y + height;
        } else {
            y2 = ycoord + thing.height;
        }
        if (x2 - x1 < width + thing.width && y2 - y1 < height + thing.height)
            return true;
        return false;
    }
    
    abstract public void paint (Graphics g);
    
    abstract public void writeToBoard (int xcoord, int ycoord, int[][] m_gameState);
    
    //abstract public boolean place (int x, int y, boolean board);
    
}
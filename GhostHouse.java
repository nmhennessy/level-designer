import java.awt.*;

public class GhostHouse extends PaletteSingleItem
{
    
    public GhostHouse(int a, int b)
    {
        super(a, b);
        width = 8;
        height = 6;    
    }

    public void paint (Graphics g)
    {
        Color tempColour = g.getColor();
        g.setColor(Color.white);
        g.fillRect (x * CELL, y * CELL, width * CELL, height * CELL);
        g.setColor(Color.yellow);
        g.fillRect(x * CELL, y * CELL, width * CELL, 1 * CELL);
        g.fillRect((x+2) * CELL, (y+1) * CELL, 4 * CELL, 1 * CELL);
        g.fillRect((x+1) * CELL, (y+2) * CELL, (width-2) * CELL, 3 * CELL);
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
        gameState[x]  [y] = 0;
        gameState[x+1][y] = 0;
        gameState[x+2][y] = LevelDesigner.GS_SOUTH;
        gameState[x+3][y] = LevelDesigner.GS_SOUTH;
        gameState[x+4][y] = LevelDesigner.GS_SOUTH;
        gameState[x+5][y] = LevelDesigner.GS_SOUTH;
        gameState[x+6][y] = 0;
        gameState[x+7][y] = 0;
        gameState[x]  [y+1] = LevelDesigner.PAL_CANVAS;
        gameState[x+1][y+1] = LevelDesigner.PAL_CANVAS;
        gameState[x+2][y+1] = 0;
        gameState[x+3][y+1] = 0;
        gameState[x+4][y+1] = 0;
        gameState[x+5][y+1] = 0;
        gameState[x+6][y+1] = LevelDesigner.PAL_CANVAS;
        gameState[x+7][y+1] = LevelDesigner.PAL_CANVAS;
        gameState[x]  [y+2] = LevelDesigner.PAL_CANVAS;
        gameState[x+1][y+2] = 0;
        gameState[x+2][y+2] = 0;
        gameState[x+3][y+2] = 0;
        gameState[x+4][y+2] = 0;
        gameState[x+5][y+2] = 0;
        gameState[x+6][y+2] = 0;
        gameState[x+7][y+2] = LevelDesigner.PAL_CANVAS;
        gameState[x]  [y+3] = LevelDesigner.PAL_CANVAS;
        gameState[x+1][y+3] = 0;
        gameState[x+2][y+3] = LevelDesigner.GS_NORTH | LevelDesigner.GS_SOUTH | LevelDesigner.GS_WEST;
        gameState[x+3][y+3] = LevelDesigner.GS_NORTH | LevelDesigner.GS_SOUTH; 
        gameState[x+4][y+3] = LevelDesigner.GS_NORTH | LevelDesigner.GS_SOUTH;
        gameState[x+5][y+3] = LevelDesigner.GS_NORTH | LevelDesigner.GS_SOUTH | LevelDesigner.GS_EAST;
        gameState[x+6][y+3] = 0;
        gameState[x+7][y+3] = LevelDesigner.PAL_CANVAS;
        gameState[x]  [y+4] = LevelDesigner.PAL_CANVAS;
        gameState[x+1][y+4] = 0;
        gameState[x+2][y+4] = 0;
        gameState[x+3][y+4] = 0;
        gameState[x+4][y+4] = 0;
        gameState[x+5][y+4] = 0;
        gameState[x+6][y+4] = 0;
        gameState[x+7][y+4] = LevelDesigner.PAL_CANVAS;
        gameState[x]  [y+5] = LevelDesigner.PAL_CANVAS;
        gameState[x+1][y+5] = LevelDesigner.PAL_CANVAS;
        gameState[x+2][y+5] = LevelDesigner.PAL_CANVAS;
        gameState[x+3][y+5] = LevelDesigner.PAL_CANVAS;
        gameState[x+4][y+5] = LevelDesigner.PAL_CANVAS;
        gameState[x+5][y+5] = LevelDesigner.PAL_CANVAS;
        gameState[x+6][y+5] = LevelDesigner.PAL_CANVAS;
        gameState[x+7][y+5] = LevelDesigner.PAL_CANVAS;
    }

}
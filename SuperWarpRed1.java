import java.awt.*;

public class SuperWarpRed1 extends PaletteSingleItem
{
    
    public SuperWarpRed1(int a, int b)
    {
        super(a, b);
        width = 5;
        height = 6;    
    }

    public void paint (Graphics g)
    {
        Color tempColour = g.getColor();
        g.setColor(Color.red);
        g.fillRect (x * CELL, y * CELL, width * CELL, height * CELL);
        g.setColor(Color.gray);
        g.fillRect((x + 1) * CELL, (y + 2) * CELL, 3 * CELL, 2 * CELL);
        if (selected) {
            g.setColor(Color.red);
        } else {
            g.setColor(Color.black);
        }
        g.drawRect(x * CELL, y * CELL, width * CELL, height * CELL);
    }

    public void writeToGrid(int[][] gameState)
    {
        gameState[x]  [y] = LevelDesigner.PAL_RED;
        gameState[x+1][y] = LevelDesigner.PAL_RED;
        gameState[x+2][y] = LevelDesigner.PAL_RED;
        gameState[x+3][y] = LevelDesigner.PAL_RED;
        gameState[x+4][y] = LevelDesigner.PAL_RED;
        gameState[x]  [y+1] = LevelDesigner.PAL_RED;
        gameState[x+1][y+1] = LevelDesigner.PAL_RED;
        gameState[x+2][y+1] = LevelDesigner.PAL_RED;
        gameState[x+3][y+1] = LevelDesigner.PAL_RED;
        gameState[x+4][y+1] = LevelDesigner.PAL_RED;
        gameState[x]  [y+2] = LevelDesigner.PAL_RED;
        gameState[x+1][y+2] = LevelDesigner.PAL_GREY | LevelDesigner.GS_SUPERWARP;
        gameState[x+2][y+2] = LevelDesigner.PAL_GREY | LevelDesigner.GS_SUPERWARP;
        gameState[x+3][y+2] = LevelDesigner.PAL_GREY | LevelDesigner.GS_SUPERWARP;
        gameState[x+4][y+2] = LevelDesigner.PAL_RED;
        gameState[x]  [y+3] = LevelDesigner.PAL_RED;
        gameState[x+1][y+3] = LevelDesigner.PAL_GREY | LevelDesigner.GS_SUPERWARP;
        gameState[x+2][y+3] = LevelDesigner.PAL_GREY | LevelDesigner.GS_SUPERWARP;
        gameState[x+3][y+3] = LevelDesigner.PAL_GREY | LevelDesigner.GS_SUPERWARP;
        gameState[x+4][y+3] = LevelDesigner.PAL_RED;
        gameState[x]  [y+4] = LevelDesigner.PAL_RED;
        gameState[x+1][y+4] = LevelDesigner.PAL_RED;
        gameState[x+2][y+4] = LevelDesigner.PAL_RED;
        gameState[x+3][y+4] = LevelDesigner.PAL_RED;
        gameState[x+4][y+4] = LevelDesigner.PAL_RED;
        gameState[x]  [y+5] = LevelDesigner.PAL_RED;
        gameState[x+1][y+5] = LevelDesigner.PAL_RED;
        gameState[x+2][y+5] = LevelDesigner.PAL_RED;
        gameState[x+3][y+5] = LevelDesigner.PAL_RED;
        gameState[x+4][y+5] = LevelDesigner.PAL_RED;
    }

}
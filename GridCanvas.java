import java.awt.*;
import java.util.*;
import java.applet.*;
import java.awt.event.*;
import java.lang.Math;

public class GridCanvas extends Canvas
{
   LevelDesigner  m_levelDesigner;
   
   
   GridCanvas (LevelDesigner levelDesigner)
   {
      setSize (637, 624);
      m_levelDesigner = levelDesigner;
      addMouseListener (new MouseAdapter ()
                        {
                           public void mousePressed (MouseEvent e)
                           {
                              updateCell (e.getX (), e.getY ());
                           }
                        });
   
		//{{REGISTER_LISTENERS
		SymMouseMotion aSymMouseMotion = new SymMouseMotion();
		this.addMouseMotionListener(aSymMouseMotion);
		//}}
	}
   
    public void updateCell (int mouseX, int mouseY)
    {
        PaletteItem dummy;
        int x = (int)Math.floor(mouseX / PaletteItem.CELL);
        int y = (int)Math.floor(mouseY / PaletteItem.CELL);
        if (m_levelDesigner.selection == null)
        {
            for (int i = 0; i < m_levelDesigner.boardstuff.size(); i += 1) {
                dummy = (PaletteItem)m_levelDesigner.boardstuff.elementAt(i);
                if (dummy.intersect(mouseX, mouseY))
                {
                    if (m_levelDesigner.selection != null)
                        m_levelDesigner.selection.selected = false;
                    m_levelDesigner.selection  = dummy;
                    dummy.selected = true;
                    break;
                }
            } //for
//        } else if (m_levelDesigner.selection.intersect(mouseX, mouseY)) {
//            m_levelDesigner.selection.selected = false;
//            m_levelDesigner.selection = null;
        }  else {
            boolean collided = false;
            for (int i = 0; i < m_levelDesigner.boardstuff.size(); i += 1) {
                dummy = (PaletteItem)m_levelDesigner.boardstuff.elementAt(i);
                if (dummy.collision(x, y, m_levelDesigner.selection)) {
                    collided = true;
                    break;
                }
            }
            if (!collided) 
            {
                try
                {
                    PaletteMultipleItemSingleSquare dummy1 = (PaletteMultipleItemSingleSquare) m_levelDesigner.selection;
                    if (dummy1.gameStateCode == m_levelDesigner.m_gameState[x][y])
                        return;
                    m_levelDesigner.selection.writeToBoard(x, y, m_levelDesigner.m_gameState);
                }
                catch (Exception e)
                {
                    m_levelDesigner.selection.writeToBoard(x, y, m_levelDesigner.m_gameState);
                    m_levelDesigner.palettestuff.remove(m_levelDesigner.selection);
                    if (!m_levelDesigner.boardstuff.contains(m_levelDesigner.selection))
                        m_levelDesigner.boardstuff.add(m_levelDesigner.selection);
                    m_levelDesigner.selection.selected = false;
                    m_levelDesigner.selection = null;
                }
            } else {
                //do beeping or warning stuff here
            }
        }
        repaint();
        m_levelDesigner.m_stuffCanvas.repaint();
    }
   
   
   
   public void paint (Graphics g)
   {
      Dimension dim = getSize ();
      int       gridState;
      int      x1;
      int      x2;
      int y1;
      int y2;

      Image offImage = createImage(dim.width, dim.height);
      Graphics offGraphics = offImage.getGraphics();
      
      int cellWidth = dim.width / m_levelDesigner.m_gridSizeX;
      int cellHeight = dim.height / m_levelDesigner.m_gridSizeY;
      
      offGraphics.setColor (Color.white);
      offGraphics.fillRect (0, 0, dim.width, dim.height);

      offGraphics.setColor (Color.gray);
      for (int x = 0; x <= m_levelDesigner.m_gridSizeX; x++)
      {
         offGraphics.drawLine (x * cellWidth, 0, x * cellWidth, dim.height - 1);
      }
         
      for (int y = 0; y <= m_levelDesigner.m_gridSizeY; y++)
      {
         offGraphics.drawLine (0, y * cellHeight, dim.width - 1, y * cellHeight);
      }                                                   
      Color tempColor;
      for (int x = 0; x < m_levelDesigner.m_gridSizeX; x++)
      {
         for (int y = 0; y < m_levelDesigner.m_gridSizeY; y++)
         {
            x1 = cellWidth * x;
            x2 = x1 + cellWidth;
            y1 = cellHeight * y;
            y2 = y1 + cellHeight;
            //////////////////////////
            gridState = m_levelDesigner.m_gameState[x][y];
            if (gridState == 0)
            {
               offGraphics.setColor (Color.yellow);
               offGraphics.fillRect(x1+1, y1+1, cellWidth, cellHeight);
            }
            if ((gridState & LevelDesigner.PAL_CANVAS) != 0)
            {
               offGraphics.setColor (Color.white);
               offGraphics.fillRect(x1+1, y1+1, cellWidth-2, cellHeight-2);
            }
            if ((gridState & LevelDesigner.PAL_GREY) != 0)
            {
                tempColor = offGraphics.getColor();
                offGraphics.setColor(Color.gray);
               offGraphics.fillRect (x1, y1, cellWidth, cellHeight);
               offGraphics.setColor(tempColor);
               
            }
            if ((gridState & LevelDesigner.PAL_RED) != 0)
            {
                
                tempColor = offGraphics.getColor();
                offGraphics.setColor(Color.red);
               offGraphics.fillRect (x1, y1, cellWidth, cellHeight);
               offGraphics.setColor(tempColor);
               
            }

            if ((gridState & LevelDesigner.PAL_BLUE) != 0)
            {                
               tempColor = offGraphics.getColor();
               offGraphics.setColor(Color.blue);
               offGraphics.fillRect (x1, y1, cellWidth, cellHeight);
               offGraphics.setColor(tempColor);               
            }

            if ((gridState & LevelDesigner.GS_FOOD) != 0)
            {
               tempColor = offGraphics.getColor();
               offGraphics.setColor(Color.cyan);
               offGraphics.fillRect (x1 + cellWidth / 4, y1 + cellHeight / 4, cellWidth / 2, cellHeight / 2);
               offGraphics.setColor(tempColor);
            }

            if ((gridState & LevelDesigner.GS_SUPERWARP) != 0)
            {
               tempColor = offGraphics.getColor();
               offGraphics.setColor(Color.green);
               offGraphics.fillRect (x1 + cellWidth / 4, y1 + cellHeight / 4, cellWidth / 2, cellHeight / 2);
               offGraphics.setColor(tempColor);
            }
            if ((gridState & LevelDesigner.GS_POWERUP) != 0)
            {
                tempColor = offGraphics.getColor();
                offGraphics.setColor(Color.pink);
               offGraphics.fillRect (x1 + cellWidth / 4, y1 + cellHeight / 4, cellWidth / 2, cellHeight / 2);
               offGraphics.setColor(tempColor);
            }

            /*
            if ((gridState & LevelDesigner.PAL_WARP_ZONE) != 0)
            {
               offGraphics.drawLine (x1, y1, x2 - 1, y2 - 1);
               offGraphics.drawLine (x1, y2 - 1, x2 - 1, y1);
            }
            */
            
            //////////////////////////////////
         }   
      }
      
      for (int i = 0; i < m_levelDesigner.boardstuff.size(); i += 1) {
          ((PaletteItem)m_levelDesigner.boardstuff.elementAt(i)).paint(offGraphics);
      } //for	  

        
      g.drawImage(offImage, 0, 0, this);

      
   }
  

	class SymMouseMotion extends java.awt.event.MouseMotionAdapter
	{
		public void mouseDragged(java.awt.event.MouseEvent event)
		{
			Object object = event.getSource();
			if (object == GridCanvas.this)
				GridCanvas_MouseDragged(event);
		}
	}

	void GridCanvas_MouseDragged(java.awt.event.MouseEvent event)
	{
		// to do: code goes here.
	    updateCell (event.getX (), event.getY ());		 
	}
}

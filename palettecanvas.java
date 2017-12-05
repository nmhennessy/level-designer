import java.awt.*;
import java.util.*;
import java.applet.*;
import java.awt.event.*;
import java.lang.Math;

public class PaletteCanvas extends Canvas
{
   LevelDesigner  m_levelDesigner;
   
   PaletteCanvas (LevelDesigner levelDesigner)
   {
      m_levelDesigner = levelDesigner;
      setSize (600, 50);
      
      addMouseListener (new MouseAdapter ()
                        {
                           public void mousePressed (MouseEvent e)
                           {
                              updateSelection (e.getX (), e.getY ());
                           }
                        });
   }
   
   
   public void updateSelection (int x, int y)
   {
      Dimension dim = getSize ();
      int itemWidth = 30;
      int itemHeight = 30;
      int x1 = 10;
      int x2 = 0;
      
      if (y < 0 || y > itemHeight - 1)
         return;
      
      for (int i = 0; i < m_levelDesigner.m_nPalItems; i++)
      {
         x2 = x1 + itemWidth;
         
         if (x >= x1 && x < x2 - 1)
         {
//            m_levelDesigner.m_selection = (int)Math.pow (2,i);
            repaint ();
            return;
         }
         
         x1 += itemWidth + 10;
      }
         
      
   }
   
   
   public void paint (Graphics g)
   {
      Dimension dim = getSize ();
      int itemWidth = 30;
      int itemHeight = 30;
      int x1 = 10;
      int x2 = 0;
      Color tempColor;

      Image offImage = createImage(dim.width, dim.height);
      Graphics offGraphics = offImage.getGraphics();
      
      offGraphics.setColor (Color.white);
      offGraphics.fillRect (0, 0, dim.width, dim.height);

      for (int i = 0; i < m_levelDesigner.m_nPalItems; i++)
      {
         x2 = x1 + itemWidth;
         
         offGraphics.setColor (Color.black);
         offGraphics.fillRect (x1 - 1, 0, itemWidth + 2, itemHeight + 2);
         
         offGraphics.setColor (Color.black);
         switch ((int)Math.pow (2,i))
         {
         case LevelDesigner.PAL_CANVAS:
               offGraphics.setColor(Color.white);
               offGraphics.fillRect (x1, 0, itemWidth, itemHeight);
            break;
                        
         case LevelDesigner.GS_FOOD:
               tempColor = offGraphics.getColor();
               offGraphics.setColor(Color.cyan);
               offGraphics.fillRect (x1 + itemWidth / 4, itemHeight / 4, itemWidth / 2, itemHeight / 2);
               offGraphics.setColor(tempColor);
            break;
            
         case LevelDesigner.GS_POWERUP:
               tempColor = offGraphics.getColor();
               offGraphics.setColor(Color.pink);
               offGraphics.fillRect (x1 + itemWidth / 4, itemHeight / 4, itemWidth / 2, itemHeight / 2);
               offGraphics.setColor(tempColor);
            break;
            
            case LevelDesigner.GS_SUPERWARP:
               tempColor = offGraphics.getColor();
               offGraphics.setColor(Color.green);
               offGraphics.fillRect (x1 + itemWidth / 4, itemHeight / 4, itemWidth / 2, itemHeight / 2);
               offGraphics.setColor(tempColor);
               break;
               
         case LevelDesigner.PAL_RED:
            offGraphics.setColor(Color.red);
            offGraphics.fillRect(x1, 0, itemHeight, itemWidth);
            offGraphics.setColor (Color.black);
            break;
            
         case LevelDesigner.PAL_GREY:
            offGraphics.setColor(Color.gray);
            offGraphics.fillRect(x1, 0, itemHeight, itemWidth);
            offGraphics.setColor (Color.black);
            break;

         case LevelDesigner.PAL_BLUE:
               tempColor = offGraphics.getColor();
               offGraphics.setColor(Color.blue);
               offGraphics.fillRect (x1, 0, itemWidth, itemHeight);
               offGraphics.setColor(tempColor);               
            break;
         }
            /*
         case LevelDesigner.PAL_WARP_ZONE:
            offGraphics.drawLine (x1, 0, x2 - 1, itemHeight - 1);
            offGraphics.drawLine (x1, itemHeight - 1, x2 - 1, 0);
            break;
            */
                     
         if (m_levelDesigner.m_selection == (int)Math.pow (2,i))
         {
            offGraphics.setColor (Color.red);
            offGraphics.fillRect (x1, itemHeight + 5, itemWidth, 20);
         }
             
         x1 += itemWidth + 10;
         //offGraphics.drawLine (x * itemWidth, 0, x * itemWidth, dim.height - 1);
      }
      
      g.drawImage(offImage, 0, 0, this);
   }
  
}
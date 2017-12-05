import java.awt.*;
import java.util.*;
import java.applet.*;
import java.awt.event.*;
import java.lang.Math;

public class StuffCanvas extends Canvas
{
   LevelDesigner  m_levelDesigner;
   
   StuffCanvas (LevelDesigner levelDesigner)
   {
      m_levelDesigner = levelDesigner;
      setSize (300, 624);
      
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
      PaletteItem dummy;
      boolean intersected = false;
      for (int i = 0; i < m_levelDesigner.palettestuff.size(); i += 1) {
          dummy = (PaletteItem)m_levelDesigner.palettestuff.elementAt(i);
          if (dummy.intersect(x, y))
          {
            if (m_levelDesigner.selection != null)
                m_levelDesigner.selection.selected = false;
            m_levelDesigner.selection  = dummy;
            dummy.selected = true;
            intersected = true;
            break;
          }
      } //for
      if (!intersected && m_levelDesigner.selection != null)
      {
        m_levelDesigner.selection.selected = false;
        dummy = m_levelDesigner.selection;
        m_levelDesigner.selection = null;
        m_levelDesigner.boardstuff.remove(dummy);
        m_levelDesigner.palettestuff.add(dummy);
        dummy.x = dummy.originX;
        dummy.y = dummy.originY;
      }
      repaint();
      m_levelDesigner.m_gridCanvas.repaint();
      int j = 0;
   }
   
   
   public void paint (Graphics g)
   {
      g.drawString("PowerUps", 2, 28);
      g.drawString("SuperWarps", 84, 28);
      g.drawString("GhostHouse", 84, 420);
      g.drawString("Playa", 84, 528);
      g.drawString("Pills", 176, 28);
      g.drawString("Road", 176, 114);
            
      for (int i = 0; i < m_levelDesigner.palettestuff.size(); i += 1) {
          ((PaletteItem)m_levelDesigner.palettestuff.elementAt(i)).paint(g);
      } //for	  
   }
  
}
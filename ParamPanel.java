import java.awt.*;
import java.applet.*;
import java.util.*;
import java.awt.event.*;


public class ParamPanel extends Panel
{
   Button      reset;
   Button      output;
   LevelDesigner  levelDesigner;
   
   ParamPanel (LevelDesigner levelDesigner)
   {
      setSize (900, 750);
      this.levelDesigner = levelDesigner;
      reset = new Button ("Reset");
      output = new Button ("Output");
      
      ButtonHandler butHandler = new ButtonHandler (levelDesigner, this);
      
      reset.addActionListener (butHandler);
      output.addActionListener (butHandler);
      
      add (reset);
      add (output);
      
   }
}

class ButtonHandler implements ActionListener
{
   LevelDesigner  levelDesigner;
   ParamPanel paramPanel;
   
   ButtonHandler (LevelDesigner levelDesigner, ParamPanel paramPanel)
   {
      super ();
      this.levelDesigner = levelDesigner;
      this.paramPanel = paramPanel;
   }
   
   public void actionPerformed (ActionEvent e)
   {
      if (e.getSource () == paramPanel.reset)
         levelDesigner.resetGridState();
      else if (e.getSource() == paramPanel.output)
         levelDesigner.dumpGridState();
   }
}

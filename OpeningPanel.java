import java.awt.*;
import java.applet.*;
import java.util.*;
import java.awt.event.*;


public class OpeningPanel extends Panel
{
   Button      play;
   Button      make;
   PacMondrian  pacMondrian;
   
   OpeningPanel (PacMondrian pacMondrian)
   {
      setSize (900, 750);
      this.pacMondrian = pacMondrian;
      play = new Button ("Play Game");
      make = new Button ("Make Board");
      
      ButtonOpeningHandler butHandler = new ButtonOpeningHandler (pacMondrian, this);
      
      play.addActionListener (butHandler);
      make.addActionListener (butHandler);
      
      add (play);
      add (make);
      
   }
}

class ButtonOpeningHandler implements ActionListener
{
   PacMondrian  pacMondrian;
   OpeningPanel openingPanel;
   
   ButtonOpeningHandler (PacMondrian pacMondrian, OpeningPanel openingPanel)
   {
      super ();
      this.pacMondrian = pacMondrian;
      this.openingPanel = openingPanel;
   }
   
   public void actionPerformed (ActionEvent e)
   {
      if (e.getSource () == openingPanel.play)
         pacMondrian.initGame();
      else if (e.getSource() == openingPanel.make)
         pacMondrian.initLevelDesigner();
   }
}

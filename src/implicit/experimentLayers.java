package implicit;

import implicitForms.announcePanel;
import implicitForms.fourStimulusPanel;
import implicitForms.twoStimulusPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class experimentLayers extends JLayeredPane {
	
	int cursor=0;
        
	long initTime;
	long elapsedTime;
        implicitOutputWriter writer;
	JLabel incorrect = createIncorrectLabel();
        int numberToCorrect=0;
        String defaultBeginMessage = "<html><b>Welcome to the Implicit Association Test.<br>"
                               + "Press spacebar when you are ready to begin.</b></html>";
                		
	experimentLayers( List<experimentView> views, implicitOutputWriter output ) throws IOException, NumberFormatException
	{
            JPanel panelLayer;
            int zIndex=0;
            writer = output;
            announcePanel defaultInstructions;
                              
            //let's just iterate through the list and add them based on their position in the list
            for (experimentView view : views)
            {
                //draw the panel
                panelLayer = fillPanelFromView(view);
                
                //set the layer to the size of the window
                panelLayer.setSize(new Dimension(800,800));
                panelLayer.setLocation(0,0);
                
                //add the panel in the frame in descending order
                add(panelLayer,zIndex);
                
                //add the keystroke listeners to each one of the panels
                panelLayer.getInputMap().put(KeyStroke.getKeyStroke("E"), "leftPressed");
                panelLayer.getInputMap().put(KeyStroke.getKeyStroke("I"), "rightPressed");
                panelLayer.getActionMap().put("leftPressed", new leftPressed(panelLayer,view.isleft));
                panelLayer.getActionMap().put("rightPressed", new rightPressed(panelLayer,view.isleft));
                
                
                zIndex--;
            }
            
            defaultInstructions = new announcePanel(defaultBeginMessage);
            defaultInstructions.setSize(new Dimension(800,800));
            defaultInstructions.setLocation(0,0);
            defaultInstructions.getInputMap().put(KeyStroke.getKeyStroke(' '), "spacebarStart");
            defaultInstructions.getActionMap().put("spacebarStart", new spacebarStart(defaultInstructions));
            add(defaultInstructions,0);
            add(incorrect, 1);
        }
        
        private JPanel fillPanelFromView(experimentView view) throws IOException
        {
          //create a custom panel form based on the panel type
          JPanel fillPanel = createPanelFromIndex(view.panelType);
          Component labelMapping[];
          JLabel fillLabel;
          int stimulusIndex;
          Stimulus fillStimulus;

          //here we iterate through the panel components and write the stimulus
          //data into each label
          //the label name string contains an integer index into the stimulus array
          labelMapping = fillPanel.getComponents();
          for (Component label : labelMapping)
          {
              if (label instanceof JLabel)
              {
                //cast the component in the array to a label
                fillLabel = (JLabel) label;
                  
                try{
                stimulusIndex = Integer.parseInt(fillLabel.getName());
                }
                catch (NumberFormatException e) {continue;}
                fillStimulus = view.stimulusArray[stimulusIndex];
                
                if (fillStimulus.isText) 
                  {
                    fillLabel.setText(fillStimulus.entry);
                  }
                else
                  {
                    File picFile = new File(fillStimulus.entry);
                    BufferedImage stimulusImage;			

                    stimulusImage = ImageIO.read(picFile);
                    fillLabel.setIcon(new ImageIcon(stimulusImage));
                    fillLabel.setText("");
                   }
                }
          }
            return fillPanel;
        }
        
        private JPanel createPanelFromIndex(int index)
        {
            switch(index)
            {
                case 0:
                   return new twoStimulusPanel();     
                case 1:
                    return new fourStimulusPanel();
                case 2:
                    return new announcePanel();
            }
            return null;
        }
		
        //we will handle all of the button pressing logic here
        class leftPressed extends AbstractAction
        {
                JPanel currentPanel;
                boolean correctAnswer;

                leftPressed (JPanel panelCurrent, boolean answerCorrect)
                {
                    currentPanel = panelCurrent;    
                    correctAnswer = answerCorrect;
                }

                @Override
                public void actionPerformed(ActionEvent e) {

                        if (correctAnswer)		
                        {
                            correctAnswer(correctAnswer,e.getWhen() - initTime);
                            currentPanel.setVisible(false);
                            initTime = System.currentTimeMillis();
                        }
                        else
                        {
                            wrongAnswer();
                        }
                }
        }

        class rightPressed extends AbstractAction
        {
                JPanel currentPanel;
                boolean correctAnswer;

                rightPressed (JPanel panelCurrent, boolean answerCorrect)
                {
                    currentPanel = panelCurrent;    
                    correctAnswer = answerCorrect;
                }

                @Override
                public void actionPerformed(ActionEvent e) {

                        if (!correctAnswer)		
                        {
                            correctAnswer(correctAnswer,e.getWhen() - initTime);                            
                            currentPanel.setVisible(false);
                            initTime = System.currentTimeMillis();
                        }
                        else
                        {
                            wrongAnswer();
                        }
                }
        }
        
         class spacebarStart extends AbstractAction
        {
             JPanel currentPanel;
             
                spacebarStart (JPanel panelCurrent)
                {
                    currentPanel = panelCurrent;    
                }

                @Override
                public void actionPerformed(ActionEvent e) {

                    currentPanel.setVisible(false);
                    initTime = System.currentTimeMillis();
                }
        }
        
        private void correctAnswer(boolean correctSide, long timeItTook)
        {
            //increment attempt counter
            numberToCorrect++;
            
            //write the results to the file
            writer.writeAssociationResult(cursor, correctSide , numberToCorrect, timeItTook);
            incorrect.setVisible(false);
            numberToCorrect=0;
            cursor++;
        }
        
        private void wrongAnswer()
        {
            //increment attempt counter
            numberToCorrect++;
            
            //show the incorrect label
            incorrect.setVisible(true);
        }
        
        private JLabel createIncorrectLabel()
        {
            JLabel errorLabel = new JLabel("X");
            errorLabel.setFont(new Font(null, Font.BOLD|Font.ITALIC, 60));
            errorLabel.setForeground(Color.red);
            errorLabel.setBounds(400,400,80,80);
            errorLabel.setVisible(false);
           
            return errorLabel;
        
        }

}
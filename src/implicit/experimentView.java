package implicit;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class experimentView {
    
        //define constants for indexing into the stimulus array from the config
        public static int LEFT_TOP_INDEX=0;
        public static int RIGHT_TOP_INDEX=1;
	public static int LEFT_BOTTOM_INDEX=2;
        public static int RIGHT_BOTTOM_INDEX=3;
        public static int FOCUS_INDEX=4;
	//holds what will be shown on the left side of the panel
        
        Stimulus stimulusArray[] = new Stimulus[5];
                
	//variable to hold which stimulus is correct
	//left = TRUE and right = FALSE
	public boolean isleft;
        int panelType;
        
        public experimentView(Stimulus[] stimulusGroup, int typePanel, boolean rightLeft)
        {
            panelType = typePanel;
                    
            if ( !(stimulusGroup == null) )
            {
                switch (panelType)
                {
                    case 0:
                        assignTopLabels(stimulusGroup);
                        assignFocusLabel(stimulusGroup);
                        break;
                    case 1:
                        assignTopLabels(stimulusGroup);
                        assignBottomLabels(stimulusGroup);
                        assignFocusLabel(stimulusGroup);
                        break;
                    case 2:
                        assignFocusLabel(stimulusGroup);
                        break;
                 }
            }
            isleft = rightLeft;
           }
        
	//method to convert Stimulus object data into a label
	static JLabel makeLabelfromStimulus(Stimulus filler)
	{
            if (filler.isText)
            {
                return new JLabel(filler.entry);
            }
            else
            {
                File picFile = new File(filler.entry);
                BufferedImage stimulusImage;			
                try {
                        stimulusImage = ImageIO.read(picFile);
                        return new JLabel(new ImageIcon(stimulusImage));
                    } 
                catch (IOException e) {return null;}
            }
	}
        
        private void assignTopLabels(Stimulus[] stimulusGroup)
        {
            stimulusArray[LEFT_TOP_INDEX] = stimulusGroup[LEFT_TOP_INDEX];
            stimulusArray[RIGHT_TOP_INDEX] = stimulusGroup[RIGHT_TOP_INDEX];
        }
        
        private void assignBottomLabels(Stimulus[] stimulusGroup)
        {
            stimulusArray[LEFT_BOTTOM_INDEX] = stimulusGroup[LEFT_BOTTOM_INDEX];
            stimulusArray[RIGHT_BOTTOM_INDEX] = stimulusGroup[RIGHT_BOTTOM_INDEX];
        }
        
        private void assignFocusLabel(Stimulus[] stimulusGroup)
        {
            stimulusArray[FOCUS_INDEX] = stimulusGroup[FOCUS_INDEX];
        }
        
}
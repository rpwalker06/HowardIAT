package implicit;

import java.awt.Container;
import java.io.IOException;
import java.util.List;
import javax.swing.*;

public class implicitTestRun {
	
	//create the main frame for the experiment
	JFrame frame = new JFrame("Howard Implicit Association Test");
	
	//initialize a handle to a content pane
	Container contentHolder = new Container();
		
	public implicitTestRun (String nameConfig, String idParticipant, String nameParticipant, List<experimentView> work) throws IOException, NumberFormatException
	{
            implicitOutputWriter writer;
            
            //set configurable properties of the main frame window
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            //instanstiate the writer for the test
            writer = new implicitOutputWriter(nameConfig, idParticipant, nameParticipant);
                        
            //start configuring the content pane layout and add the experiment panels
            contentHolder.setLayout(new BoxLayout(contentHolder, BoxLayout.X_AXIS));
            contentHolder.add(new experimentLayers(work, writer));
            
            
            //show the frame
            frame.setContentPane(contentHolder);
            frame.setSize(800,800);
            frame.setVisible(true);
            frame.setResizable(false);
	}	
}
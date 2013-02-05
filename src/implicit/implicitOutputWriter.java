/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implicit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Robert Walker
 */
public class implicitOutputWriter {
    
  FileWriter outfile;
  BufferedWriter out;
  DateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd HHmm-ss");
  String outputFileName;
  String OUTPUT_COLUMNS = "Participant ID\tParticipant Name\tConfig Name\tPanel No\tCorrect Answer\tTimes to Correct\tTime to Correct";
  String participantID, participantName, configName;
  
  
  implicitOutputWriter(String nameConfig, String idParticipant, String nameParticipant)
  {
      configName = nameConfig;
      participantID =  idParticipant;
      participantName = nameParticipant;
      
      outputFileName = nameParticipant+"_"+dateFormatter.format(new Date());
      try {
            outfile = new FileWriter(outputFileName);
            out = new BufferedWriter(outfile);
            out.write(OUTPUT_COLUMNS);
            out.write(System.lineSeparator());
            out.flush();
          }
      catch (IOException e) {JOptionPane.showMessageDialog(null, "Error Writing Output File");}
  }
  
  public void writeAssociationResult(int panelNo, boolean answerCorrect, int correctTries, long associationTime )
  {
      String correctAnswer = answerCorrect ? "Left" : "Right";
      try {
            out.write(participantID+"\t");
            out.write(participantName+"\t");
            out.write(configName+"\t");
            out.write(panelNo+"\t");
            out.write(correctAnswer+"\t");
            out.write(correctTries+"\t");
            out.write(associationTime+"\t");
            out.write(System.lineSeparator());
            out.flush();
           }
      catch (IOException e) {JOptionPane.showMessageDialog(null, "Error Writing Results");
      }
  }
  
    
}

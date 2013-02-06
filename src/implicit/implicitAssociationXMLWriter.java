/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implicit;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author Robert Walker
 */
public class implicitAssociationXMLWriter implements implicitAssociationXML {
    
    static XMLOutputFactory outFactory = XMLOutputFactory.newInstance();
    static XMLStreamWriter writer;
    
    public static void writeImplicitAssociationXML (List<experimentView> views, String filename) 
    {
        try {
                //create the writer 
                writer = outFactory.createXMLStreamWriter(new FileWriter(filename + ".config"));
                
                //write the root node and attribues
                writer.writeStartDocument();
                writer.writeCharacters(System.lineSeparator());
                writer.writeStartElement(configString);
                writer.writeAttribute(configName, filename );
                writer.writeAttribute(configDateCreated, ""+System.currentTimeMillis() );
                writer.writeCharacters(System.lineSeparator());
                for (int i=0; i<views.size(); i++)
                {
                    //write panel level attributes
                    writePanelConfig(i, views.get(i), writer);
                }
                 writer.writeEndDocument();
                 writer.flush();
                 writer.close();
            }
        catch (XMLStreamException | IOException e) {JOptionPane.showMessageDialog(null, "Error Accessing File" + "\n"+e.getMessage());}
    }
    
    private static void writePanelConfig(int numPanel, experimentView panel, XMLStreamWriter writer) throws XMLStreamException
    {
        writer.writeStartElement(panelDataType);
        writer.writeAttribute(panelNo, ""+numPanel );
        writer.writeAttribute(panelType, ""+panel.panelType );
        writer.writeAttribute(correctAnswer, Boolean.toString(panel.isleft));
        writer.writeCharacters(System.lineSeparator());
        writeStimulusConfig(panel.stimulusArray, writer);
        writer.writeEndElement();
        writer.writeCharacters(System.lineSeparator());
    }
    
    private static void writeStimulusConfig(Stimulus[] stim, XMLStreamWriter writer) throws XMLStreamException
    {
        for (int i=0; i<5; i++)
        {
            if ( stim[i] != null ) 
            {
                writer.writeStartElement(stimulusDataType);
                writer.writeAttribute(stimulusIndex, ""+i );
                writer.writeAttribute(isText, Boolean.toString(stim[i].isText) );
                writer.writeCharacters(stim[i].entry);
                writer.writeEndElement();
                writer.writeCharacters(System.lineSeparator());
            }
         }
    }
}
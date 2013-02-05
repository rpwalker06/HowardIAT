/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implicit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Robert Walker
 */
interface implicitAssociationXML {
    
    public static String configString = "configuration";
    public static String configName = "name";
    public static String configDateCreated = "dateCreated";
    public static String panelDataType = "experimentView";
    public static String panelNo = "panelNo";
    public static String panelType = "panelType";
    public static String correctAnswer = "correctAnswer";
    public static String stimulusDataType = "Stimulus";
    public static String stimulusIndex = "stimulusIndex";
    public static String isText = "isText";
    
    }

class implicitAssociationXMLReader implements implicitAssociationXML {
    
    static DocumentBuilderFactory inFactory = DocumentBuilderFactory.newInstance();
    String nameConfig; 
    
    public List<experimentView> readImplicitAssociationXML(String filename)
    {   
        try{
            DocumentBuilder xmlBuilder = inFactory.newDocumentBuilder();
            File xmlConfigFile = new File(filename);
            
            Document xmlConfig = xmlBuilder.parse(xmlConfigFile);
            NodeList xmlExperimentViews;
            
            Node xmlExpermientViewNode;
            Element xmlExperimentViewElement;
            List<experimentView> readViews = new ArrayList<>();
            
            
            //read attribues from root node
            nameConfig = xmlConfig.getDocumentElement().getAttribute("configName");
            
            //create a list of nodes
            xmlExperimentViews = xmlConfig.getElementsByTagName(panelDataType);
            
            for (int i = 0; i < xmlExperimentViews.getLength(); i++ )
            {
                xmlExpermientViewNode = xmlExperimentViews.item(i);
                
                if ( xmlExpermientViewNode.getNodeType() == Node.ELEMENT_NODE )
                {
                    //now iterate through the stimuli to populate the view node
                    xmlExperimentViewElement = (Element) xmlExpermientViewNode;
                    readViews.add(readPanelXMLElement(xmlExperimentViewElement));
                    //read stimulus loop
                }
            }
            
            return readViews;
                    
            }   
            catch (ParserConfigurationException | SAXException e) {
                JOptionPane.showMessageDialog(null, "Error Parsing Config File" + "\n"+e.getMessage());
                return null;
            }   catch (IOException e)
            {
                JOptionPane.showMessageDialog(null, "Error Accessing File" + "\n"+e.getMessage());
                return null;
            }
    }
    
    private experimentView readPanelXMLElement(Element view)
            {
                int panelTypeNo;
                boolean answerCorrect;
                Stimulus stimulusArray[] = new Stimulus[5];
                NodeList xmlStimulusArray;
                Node xmlStimulusNode;
                Element xmlStimulusElement;
                int indexStimulus;
                
                panelTypeNo = Integer.parseInt(view.getAttribute(panelType));
                answerCorrect = Boolean.parseBoolean(view.getAttribute(correctAnswer));
                xmlStimulusArray = view.getElementsByTagName(stimulusDataType);
                
                for(int i=0; i<xmlStimulusArray.getLength(); i++)
                {
                    xmlStimulusNode = xmlStimulusArray.item(i);
                
                    if ( xmlStimulusNode.getNodeType() == Node.ELEMENT_NODE )
                    {
                        xmlStimulusElement = (Element) xmlStimulusNode;
                        indexStimulus = Integer.parseInt(xmlStimulusElement.getAttribute(stimulusIndex));
                        stimulusArray[indexStimulus] = readStimulusXMLElement(xmlStimulusElement);                    
                    }
                }
            
                return new experimentView(stimulusArray, panelTypeNo, answerCorrect);        
            }
            
     private static Stimulus readStimulusXMLElement(Element stim)
            {
                return new Stimulus(stim.getTextContent(), Boolean.parseBoolean(stim.getAttribute(isText)));
            
            }
    
}
   
class implicitAssociationXMLWriter implements implicitAssociationXML {
    
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
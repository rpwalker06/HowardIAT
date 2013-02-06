/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implicit;

/**
 *
 * @author Robert Walker
 */
//class to define the on-screen objects
//it is meant to be flexible enough to obscure the details about the type of stimulus it is
public class Stimulus {
	
	boolean isText;
	String entry="";
	
	public Stimulus ( String enter, boolean textEntry )
	{
            isText = textEntry;

            //Constructor: check if the Stimulus is a picture or text and assign accordingly 
            if (isText) {entry = enter;} else {entry = enter;}
	}
}
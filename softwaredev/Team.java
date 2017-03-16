/* Aaron Horler - s3481341 */

package softwaredev;

import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
public class Team implements Serializable{
	private String teamName, dateCreated;
	private Collection<Developer> members;
	
	public Team(String teamName, String dateCreated, Collection<Developer> members){
		this.teamName = teamName;
		this.dateCreated = dateCreated;
		this.members = members;
	}
	
	/* Get and set methods not required. */
	
	public String toString(){
		return "Team name: " + teamName + ". Date created: " + dateCreated + ". Members: " + members;
	}
}

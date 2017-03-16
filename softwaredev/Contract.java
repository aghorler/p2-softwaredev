/* Aaron Horler - s3481341 */

package softwaredev;

import java.io.*;

@SuppressWarnings("serial")
public class Contract implements Serializable{
	private int contractID;
	private double cost, duration;
	private Client client;
	private Team team;
	private static int nextID = 1;
	//I assume by 'store' you mean this needs to be Serializable.
	
	public Contract(double cost, double duration, Client client, Team team){
		contractID = nextID++;
		this.cost = cost;
		this.duration = duration;
		this.client = client;
		this.team = team;
	}
	
	/* Get and set methods not required. */
	
	public String toString(){
		return "<html>ID: " + contractID + " Cost: " + cost + " Duration: " + duration + "<br>Client: " + client + "<br>Team: " + team + "</html>";
	}
}

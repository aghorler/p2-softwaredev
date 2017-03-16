/* Aaron Horler - s3481341 */

package softwaredev;

import java.io.*;

@SuppressWarnings("serial")
public class Stakeholder implements Serializable{
	protected String name, email;
	protected int phone;
	
	public Stakeholder(String name, String email, int phone){
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	/* Get and set methods not required. */
	
	public String toString(){
		return "Name: " + name + ". Email: " + email + ". Phone: " + phone;
	}
}

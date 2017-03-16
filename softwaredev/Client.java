/* Aaron Horler - s3481341 */

package softwaredev;

import java.io.*;

@SuppressWarnings("serial")
public class Client extends Stakeholder implements Serializable{
	private String industry, projectName;
	
	public Client(String name, String email, int phone, String industry, String projectName) {
		super(name, email, phone);
		this.industry = industry;
		this.projectName = projectName;
	}
	
	/* Get and set methods not required. */
	
	@Override
	public String toString(){
		return super.toString() + ". Industry: " + industry + ". Project name: " + projectName;
	}
}

/* Aaron Horler - s3481341 */

package softwaredev;

import java.io.*;

@SuppressWarnings("serial")
public class Developer extends Stakeholder implements Serializable{
	private String expertise;
	private int yearsExperience;
	
	public Developer(String name, String email, int phone, String expertise, int yearsExperience) {
		super(name, email, phone);
		this.expertise = expertise;
		this.yearsExperience = yearsExperience;
	}
	
	/* Get and set methods not required. */
	
	@Override
	public String toString(){
		return super.toString() + ". Expertise: " + expertise + ". Experience (in years): " + yearsExperience;
	}
}

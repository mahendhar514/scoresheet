package scoresheet;

import java.io.*;

@SuppressWarnings("serial")
public class TeamRegBean implements Serializable {
	private String name,division,club,primaryName,primaryEmail,sccName,sccEmail;
	private long primaryNumber,sccNumber;
	public TeamRegBean() {}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public String getPrimaryName() {
		return primaryName;
	}
	public void setPrimaryName(String primaryName) {
		this.primaryName = primaryName;
	}
	public String getPrimaryEmail() {
		return primaryEmail;
	}
	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}
	public String getSccName() {
		return sccName;
	}
	public void setSccName(String sccName) {
		this.sccName = sccName;
	}
	public String getSccEmail() {
		return sccEmail;
	}
	public void setSccEmail(String sccEmail) {
		this.sccEmail = sccEmail;
	}
	public long getPrimaryNumber() {
		return primaryNumber;
	}
	public void setPrimaryNumber(long primaryNumber) {
		this.primaryNumber = primaryNumber;
	}
	public long getSccNumber() {
		return sccNumber;
	}
	public void setSccNumber(long sccNumber) {
		this.sccNumber = sccNumber;
	}
}
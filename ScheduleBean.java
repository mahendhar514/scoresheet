package scoresheet;

import java.io.*;
@SuppressWarnings("serial")
public class ScheduleBean implements Serializable{
	private String team1,team2,day,date,time,season,divison;
	private int code,round;
	public ScheduleBean() {	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getDivison() {
		return divison;
	}
	public void setDivison(String divison) {
		this.divison = divison;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getRound() {
		return round;
	}
	@Override
	public String toString() {
		return "ScheduleBean [team1=" + team1 + ", team2=" + team2 + ", day=" + day + ", date=" + date + ", time="
				+ time + ", season=" + season + ", divison=" + divison + ", code=" + code + ", round=" + round + "]";
	}
	public void setRound(int round) {
		this.round = round;
	}
}
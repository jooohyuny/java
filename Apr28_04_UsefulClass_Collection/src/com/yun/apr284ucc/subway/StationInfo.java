package com.yun.apr284ucc.subway;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StationInfo {
	private Date when;
	private String no;
	private String name;
	private int ride;
	private int alight;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); // when(String -> Date)
	private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd"); // when(String -> Date)

	public StationInfo() {
		// TODO Auto-generated constructor stub
	}
	

	public StationInfo(Date when, String no, String name, int ride, int alight, SimpleDateFormat sdf,
			SimpleDateFormat sdf2) {
		super();
		this.when = when;
		this.no = no;
		this.name = name;
		this.ride = ride;
		this.alight = alight;
		this.sdf = sdf;
		this.sdf2 = sdf2;
	}

	

	public Date getWhen() {
		return when;
	}


	public void setWhen(Date when) {
		this.when = when;
	}


	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getRide() {
		return ride;
	}


	public void setRide(int ride) {
		this.ride = ride;
	}


	public int getAlight() {
		return alight;
	}


	public void setAlight(int alight) {
		this.alight = alight;
	}


	public SimpleDateFormat getSdf() {
		return sdf;
	}


	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}


	public SimpleDateFormat getSdf2() {
		return sdf2;
	}


	public void setSdf2(SimpleDateFormat sdf2) {
		this.sdf2 = sdf2;
	}


	public StationInfo(String line) throws ParseException {
		String[] line2 = line.split(",");
		String when2 = line2[0] + line2[1] + line2[2];
		when = sdf.parse(when2);
		no = line2[3];
		name = line2[4];
		ride = Integer.parseInt(line2[5]); // ride(String -> int)
		alight = Integer.parseInt(line2[6]); // ride(String -> int)
		// alight
	}

	public void printInfo() {
		System.out.println(sdf2.format(when));
		System.out.println(no);
		System.out.println(name);
		System.out.println(ride);
		System.out.println(alight);
	}
}

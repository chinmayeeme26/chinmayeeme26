package com.library.dto;

import java.sql.Date;

public class Borrow {
	private int brid;
	private int bcid;
	private int bbid;
	private Date bod;
	private String bstatus;
	private int btime;
	public int getBrid() {
		return brid;
	}
	@Override
	public String toString() {
		return "Borrow [brid=" + brid + ", bcid=" + bcid + ", bbid=" + bbid + ", bod=" + bod + ", bstatus=" + bstatus
				+ ", btime=" + btime + "]";
	}
	public int getBcid() {
		return bcid;
	}
	public void setBcid(int bcid) {
		this.bcid = bcid;
	}
	public int getBbid() {
		return bbid;
	}
	public void setBbid(int bbid) {
		this.bbid = bbid;
	}
	public Date getBod() {
		return bod;
	}
	public void setBod(Date bod) {
		this.bod = bod;
	}
	public String getBstatus() {
		return bstatus;
	}
	public void setBstatus(String bstatus) {
		this.bstatus = bstatus;
	}
	public int getBtime() {
		return btime;
	}
	public void setBtime(int btime) {
		this.btime = btime;
	}
	public void setBrid(int brid) {
		this.brid = brid;
	}
	
}

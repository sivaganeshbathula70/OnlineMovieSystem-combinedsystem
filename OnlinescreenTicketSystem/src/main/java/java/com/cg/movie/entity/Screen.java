package com.cg.movie.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="lpu_movie_Screen")
public class Screen {
	@Id
	@Column(name="screen_id")
	private int screeinId;
	@Column(name="theater_name")
	private String theatername;
	@Column(name="screen_name")
	private String screenname;
	@Column(name="screen_show")
	private String show;
	@Column(name="screen_rows")
	private int screenrows;
	@Column(name="screen_columns")
	private int columns;
	@ManyToOne
	@JoinColumn(name="theaterId", referencedColumnName = "theaterId")
	private Theater theater;
	
	public Theater getTheater() {
		return theater;
	}
	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	public int getScreeinId() {
		return screeinId;
	}
	public void setScreeinId(int screeinId) {
		this.screeinId = screeinId;
	}
	public String getTheatername() {
		return theatername;
	}
	public void setTheatername(String theatername) {
		this.theatername = theatername;
	}
	public String getScreenname() {
		return screenname;
	}
	public void setScreenname(String screenname) {
		this.screenname = screenname;
	}
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	public int getScreenrows() {
		return screenrows;
	}
	public void setScreenrows(int screenrows) {
		this.screenrows = screenrows;
	}
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	


}

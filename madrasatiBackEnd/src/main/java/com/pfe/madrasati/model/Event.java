package com.pfe.madrasati.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table (name = "event")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "color_id_seq")
    @SequenceGenerator(name = "color_id_seq", sequenceName = "color_id_seq", initialValue = 1, allocationSize = 1)
	@Column(name="id")
      public  Integer id ;  
	
//	@JoinColumn(name = "allday")
//	 public  boolean allDay ; 
//	
//	@JoinColumn(name = "allow")
//   public String allow ;
//	
//	@JoinColumn(name = "backgroundcolor")
//   public  String backgroundColor  ;
//	
//	@JoinColumn(name = "bordercolor")
//     public  String borderColor ;
//	
//	@JoinColumn(name = "classnames")
//  public   Integer classNames ; 
//	@JoinColumn(name = "constraint")
//    public  String constraint ;
//	
//	@JoinColumn(name = "durationeditable")
//   public  String  durationEditable ; 
    @Column(name="end")
  public Date  end ;
////public  any extendedProps ;
//	@JoinColumn(name = "groupid")
//    public  String groupId ;
//	
//	@JoinColumn(name = "overlap")
//  public  String overlap ; 
//	
//	@JoinColumn(name = "rendering")
//    public  String rendering ; 
////public  EventSourceApi source:  ;

  @Column(name="start")
    public  Date start ;
  @Column(name="color")
	public String color ;
  @Column(name="textColor")
	public String textColor ;

//    public String  startEditable  ; 
//	

//   public  String textColor ; 
//	
  @Column(name="title")
    public String title  ; 
//	
//	@JoinColumn(name = "url")
//     public  String  url ; 
//	//@JoinColumn(name = "def")
//	 //public String def   ;
////public  any instance ; 
////public  Calendar calendar  ;
//
//	@JoinColumn(name = "nomclasse")
//     public String nomClasse ;
//	
//	@JoinColumn(name = "idClasse")
//     public Integer idClasse ;
//	
//	@JoinColumn(name = "editable")
//    public boolean editable ;
//

public Event() {
	super();
	// TODO Auto-generated constructor stub
}

public Event(Integer id, Date end, Date start, String color, String textColor, String title) {
	super();
	this.id = id;
	this.end = end;
	this.start = start;
	this.color = color;
	this.textColor = textColor;
	this.title = title;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public Date getEnd() {
	return end;
}

public void setEnd(Date end) {
	this.end = end;
}

public Date getStart() {
	return start;
}

public void setStart(Date start) {
	this.start = start;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public String getTextColor() {
	return textColor;
}

public void setTextColor(String textColor) {
	this.textColor = textColor;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}
	
	
}

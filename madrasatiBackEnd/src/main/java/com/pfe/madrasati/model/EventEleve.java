package com.pfe.madrasati.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table (name = "eventeleve")
public class EventEleve {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "color_id_seq")
    @SequenceGenerator(name = "color_id_seq", sequenceName = "color_id_seq", initialValue = 1, allocationSize = 1)
	@JoinColumn(name = "id")
      public  Integer id ;  
	
	@JoinColumn(name = "allday")
	 public  boolean allDay ; 
	
	@JoinColumn(name = "allow")
   public String allow ;
	
	@JoinColumn(name = "backgroundcolor")
   public  String backgroundColor  ;
	
	@JoinColumn(name = "bordercolor")
     public  String borderColor ;
	
	@JoinColumn(name = "classnames")
  public   Integer classNames ; 
//public  any constraint ;
//public  any  durationEditable ; 
	@JoinColumn(name = "end")
  public Date  end ;
//public  any extendedProps ;
	@JoinColumn(name = "groupid")
    public  String groupId ;
	
	
//public  any overlap ; 
	@JoinColumn(name = "rendering")
    public  String rendering ; 
//public  EventSourceApi source:  ;
	@JoinColumn(name = "start")
    public  Date start ;
//public any startEditable  ; 
//	@JoinColumn(name = "textcolor")
//   public  String textColor ; 
	
	@JoinColumn(name = "title")
    public String title  ; 
//public  any  url ; 
//public  Calendar calendar  ;
//public any def   ;
//public  any instance ; 
	@JoinColumn(name = "ideleve")
      public Integer idEleve ;
	
	@JoinColumn(name = "nomeleve")
     public String nomEleve ;
	public EventEleve() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EventEleve(Integer id, boolean allDay, String allow, String backgroundColor, String borderColor,
			Integer classNames, Date end, String groupId, String rendering, Date start, String textColor, String title,
			Integer idEleve, String nomEleve) {
		super();
		this.id = id;
		this.allDay = allDay;
		this.allow = allow;
		this.backgroundColor = backgroundColor;
		this.borderColor = borderColor;
		this.classNames = classNames;
		this.end = end;
		this.groupId = groupId;
		this.rendering = rendering;
		this.start = start;
//		this.textColor = textColor;
		this.title = title;
		this.idEleve = idEleve;
		this.nomEleve = nomEleve;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean isAllDay() {
		return allDay;
	}
	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}
	public String getAllow() {
		return allow;
	}
	public void setAllow(String allow) {
		this.allow = allow;
	}
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public String getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}
	public Integer getClassNames() {
		return classNames;
	}
	public void setClassNames(Integer classNames) {
		this.classNames = classNames;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getRendering() {
		return rendering;
	}
	public void setRendering(String rendering) {
		this.rendering = rendering;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
//	public String getTextColor() {
//		return textColor;
//	}
//	public void setTextColor(String textColor) {
//		this.textColor = textColor;
//	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getIdEleve() {
		return idEleve;
	}
	public void setIdEleve(Integer idEleve) {
		this.idEleve = idEleve;
	}
	public String getNomEleve() {
		return nomEleve;
	}
	public void setNomEleve(String nomEleve) {
		this.nomEleve = nomEleve;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (allDay ? 1231 : 1237);
		result = prime * result + ((allow == null) ? 0 : allow.hashCode());
		result = prime * result + ((backgroundColor == null) ? 0 : backgroundColor.hashCode());
		result = prime * result + ((borderColor == null) ? 0 : borderColor.hashCode());
		result = prime * result + ((classNames == null) ? 0 : classNames.hashCode());
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idEleve == null) ? 0 : idEleve.hashCode());
		result = prime * result + ((nomEleve == null) ? 0 : nomEleve.hashCode());
		result = prime * result + ((rendering == null) ? 0 : rendering.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
//		result = prime * result + ((textColor == null) ? 0 : textColor.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	
	
	
	
}

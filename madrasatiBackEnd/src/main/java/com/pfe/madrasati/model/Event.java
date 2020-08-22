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
@Table (name = "event")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "color_id_seq")
    @SequenceGenerator(name = "color_id_seq", sequenceName = "color_id_seq", initialValue = 1, allocationSize = 1)
	@JoinColumn(name = "id")
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
//	@JoinColumn(name = "end")
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
//	@JoinColumn(name = "start")
    public  Date start ;
//	
//	@JoinColumn(name = "starteditable")
//    public String  startEditable  ; 
//	
//	@JoinColumn(name = "textcolor")
//   public  String textColor ; 
//	
//	@JoinColumn(name = "title")
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
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	
}

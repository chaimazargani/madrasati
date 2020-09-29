package com.pfe.madrasati.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.pfe.madrasati.dao.LocalDateTimeConverter;

@Entity
@Table(name = "event")
public class Event implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "color_id_seq")
	@SequenceGenerator(name = "color_id_seq", sequenceName = "color_id_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "id")
	public Integer id;
	public LocalDateTime enddate;
	public LocalDateTime start;
	public Integer idclasse;
	@Column(name = "color")
	public String color;

	@Column(name = "title")
	public String title;

	public Event() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getIdclasse() {
		return idclasse;
	}

	public void setIdclasse(Integer idclasse) {
		this.idclasse = idclasse;
	}

	public LocalDateTime getEnddate() {
		return enddate;
	}

	public void setEnddate(LocalDateTime enddate) {
		this.enddate = enddate;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
//    public String  startEditable  ; 
//	

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
	
//   public  String textColor ; 
//	
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
	
}

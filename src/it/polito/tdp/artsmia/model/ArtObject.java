package it.polito.tdp.artsmia.model;

public class ArtObject {

	private int id;
	private String classification;
	private String continent;
	private String country;
	private int curatorApproved;
	private String dated;
	private String department;
	private String medium;
	private String nationality;
	private String name;
	private int restricted;
	private String rightsType;
	private String role;
	private String room;
	private String style;
	private String title;

	public ArtObject(int objectId, String classification, String continent, 
			String country, int curatorApproved, String dated, String department, 
			String medium, String nationality, String objectName, int restricted, 
			String rightsType, String role, String room, String style, String title) {
		super();
		this.id = objectId;
		this.classification = classification;
		this.continent = continent;
		this.country = country;
		this.curatorApproved = curatorApproved;
		this.dated = dated;
		this.department = department;
		this.medium = medium;
		this.nationality = nationality;
		this.name = objectName;
		this.restricted = restricted;
		this.rightsType = rightsType;
		this.role = role;
		this.room = room;
		this.style = style;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int objectId) {
		this.id = objectId;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getCuratorApproved() {
		return curatorApproved;
	}

	public void setCuratorApproved(int curatorApproved) {
		this.curatorApproved = curatorApproved;
	}

	public String getDated() {
		return dated;
	}

	public void setDated(String dated) {
		this.dated = dated;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getName() {
		return name;
	}

	public void setName(String objectName) {
		this.name = objectName;
	}

	public int getRestricted() {
		return restricted;
	}

	public void setRestricted(int restricted) {
		this.restricted = restricted;
	}

	public String getRightsType() {
		return rightsType;
	}

	public void setRightsType(String rightsType) {
		this.rightsType = rightsType;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
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
		result = prime * result + id;
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
		ArtObject other = (ArtObject) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "ArtObject [objectId=" + id + ", title=" + title + "]";
	}
}

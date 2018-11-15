package it.polito.tdp.artsmia.model;

public class Exhibition {

	int id;
	String department;
	String title;
	int beginYear;
	int endYear;

	public Exhibition(int id, String department, String title, int beginYear, int endYear) {
		super();
		this.id = id;
		this.department = department;
		this.title = title;
		this.beginYear = beginYear;
		this.endYear = endYear;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getBeginYear() {
		return beginYear;
	}

	public void setBeginYear(int beginYear) {
		this.beginYear = beginYear;
	}

	public int getEndYear() {
		return endYear;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(java.lang.Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exhibition other = (Exhibition) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Exhibition [id=" + id + ", title=" + title + "]";
	}
}

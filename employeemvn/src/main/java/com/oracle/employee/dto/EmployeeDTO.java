package com.oracle.employee.dto;


public class EmployeeDTO {

	private Integer id;
	private String name;
	private String middleInitial;
	private String lastName;
	private String dateOfBirth;
	private String dateOfEMployment;
	private Integer state;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getDateOfEMployment() {
		return dateOfEMployment;
	}
	public void setDateOfEMployment(String dateOfEMployment) {
		this.dateOfEMployment = dateOfEMployment;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	/*Not mine equals implementation, but i like this prime number based equals based 
	 * on entities properties hashcode values*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null)?0:id.hashCode());
		result = prime * result + ((name == null)?0:name.hashCode());
		result = prime * result + ((middleInitial == null)?0:middleInitial.hashCode());
		result = prime * result + ((lastName == null)?0:lastName.hashCode());
		result = prime * result + ((dateOfBirth == null)?0:dateOfBirth.hashCode());
		result = prime * result + ((dateOfEMployment == null)?0:dateOfEMployment.hashCode());
		result = prime * result + ((state == null)?0:state.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		EmployeeDTO other = (EmployeeDTO) obj;
		if(id == null) {
			if(other.id != null)
				return false;
		}else if(!id.equals(other.id)) {
			return false;
		}
		if(name==null) {
			if(other.name != null)
				return false;
		}else if(!name.equals(other.name)) {
			return false;
		}
		if(middleInitial==null) {
			if(other.middleInitial != null)
				return false;
		}else if(!middleInitial.equals(other.middleInitial)) {
			return false;
		}
		if(lastName==null) {
			if(other.lastName != null)
				return false;
		}else if(!lastName.equals(other.lastName)) {
			return false;
		}
		if(dateOfBirth==null) {
			if(other.dateOfBirth != null)
				return false;
		}else if(!dateOfBirth.equals(other.dateOfBirth)) {
			return false;
		}
		if(dateOfEMployment==null) {
			if(other.dateOfEMployment != null)
				return false;
		}else if(!dateOfEMployment.equals(other.dateOfEMployment)) {
			return false;
		}
		if(state==null) {
			if(other.state != null)
				return false;
		}else if(!state.equals(other.state)) {
			return false;
		}
		return true;
	}
}

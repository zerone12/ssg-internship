package ssg.prototype.ssginternshipwebapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="city")
	private String city;
	
	@Column(name="street")
	private String street;
	
	@Column(name="zip_code")
	private String zipCode;
	
	//getters & setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		String template = "UserEntity [%1$d, %2$s %3$s, %4$s, %5$s %6$s (%7$s)";
		return String.format(template, id, firstName, lastName, email, city, street, zipCode);
	}
	
	
	
	
	
}

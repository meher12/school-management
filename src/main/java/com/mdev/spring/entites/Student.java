package com.mdev.spring.entites;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY.AUTO)
	private Long id;

	@Column(name = "first_name", nullable = false, length = 50)
	private String fristName;

	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;

	private String email;

	@Column(name = "BIRTHDATE")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDateAsDate;

	@Column(name = "BIRTHDATE", insertable = false, updatable = false)
	private LocalDate brithDate;

	private boolean wantsNewsletter;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "ST_STREET")),
			@AttributeOverride(name = "number", column = @Column(name = "ST_NUMBER")),
			@AttributeOverride(name = "city", column = @Column(name = "ST_CITY")) })
	private Address address;

	@ManyToMany(mappedBy = "students")
	private List<Course> courses;

	public Student() {
		super();
	}

	public Student(Long id, String fristName, String lastName, String email, Date birthDateAsDate, LocalDate brithDate,
			boolean wantsNewsletter, Gender gender, Address address, List<Course> courses) {
		super();
		this.id = id;
		this.fristName = fristName;
		this.lastName = lastName;
		this.email = email;
		this.birthDateAsDate = birthDateAsDate;
		this.brithDate = brithDate;
		this.wantsNewsletter = wantsNewsletter;
		this.gender = gender;
		this.address = address;
		this.courses = courses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFristName() {
		return fristName;
	}

	public void setFristName(String fristName) {
		this.fristName = fristName;
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

	public Date getBirthDateAsDate() {
		return birthDateAsDate;
	}

	public void setBirthDateAsDate(Date birthDateAsDate) {
		this.birthDateAsDate = birthDateAsDate;
	}

	public LocalDate getBrithDate() {
		return brithDate;
	}

	public void setBrithDate(LocalDate brithDate) {
		this.brithDate = brithDate;
	}

	public boolean isWantsNewsletter() {
		return wantsNewsletter;
	}

	public void setWantsNewsletter(boolean wantsNewsletter) {
		this.wantsNewsletter = wantsNewsletter;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public enum Gender {
		MALE, FEMALE
	}

}

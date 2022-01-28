package com.mdev.spring.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 50)
	private String title;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name= "teacher_id", referencedColumnName = "id")
	private Teacher teacher;

	@OneToOne(mappedBy = "course")
	private CourseMaterial courseMaterial;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name= "students_courses",
	joinColumns = @JoinColumn(name = "students_id", referencedColumnName = "id"),
	inverseJoinColumns  = @JoinColumn(name="coures_id", referencedColumnName = "id")
	)
	private List<Student>students;

	public Course() {
		super();
	}

	public Course(Long id, String title, Teacher teacher, CourseMaterial courseMaterial, List<Student> students) {
		super();
		this.id = id;
		this.title = title;
		this.teacher = teacher;
		this.courseMaterial = courseMaterial;
		this.students = students;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public CourseMaterial getCourseMaterial() {
		return courseMaterial;
	}

	public void setCourseMaterial(CourseMaterial courseMaterial) {
		this.courseMaterial = courseMaterial;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", teacher=" + teacher + ", courseMaterial=" + courseMaterial
				+ ", students=" + students + "]";
	}

	
	
}

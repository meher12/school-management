package com.mdev.spring.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.mdev.spring.entites.Student;


public interface StudentService {
	
	public List<Student> getAllStudent();
	
	public void saveStudent(Student student);
	
	public Student findStudentById(Long id);
	
	public void deleteStudentById(Long id);
	
	public Page<Student> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}

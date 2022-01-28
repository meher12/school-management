package com.mdev.spring.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.mdev.spring.entites.Teacher;

public interface TeacherService {
	
	public List<Teacher> getAllTeacher();
	
	public Teacher findTeacherById(Long id);
	
	public void deleteTeacherById(Long id);
	
	public void saveTeacher(Teacher teacher);
	
	

}

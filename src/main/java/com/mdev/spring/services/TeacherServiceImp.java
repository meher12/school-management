package com.mdev.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdev.spring.entites.Teacher;
import com.mdev.spring.repositorie.TeacherRepository;

@Service
@Transactional
public class TeacherServiceImp implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public List<Teacher> getAllTeacher() {
		return this.teacherRepository.findAll();
	}

	@Override
	public void saveTeacher(Teacher teacher) {
		this.teacherRepository.save(teacher);
	}

	@Override
	public Teacher findTeacherById(Long id) {
		Optional<Teacher> optional = this.teacherRepository.findById(id);

		Teacher teacher = null;
		if (optional.isPresent()) {
			teacher = optional.get();
		} else {
			throw new RuntimeException("Teacher not foud for id ::" + id);
		}
		return teacher;
	}

	@Override
	public void deleteTeacherById(Long id) {
		this.teacherRepository.deleteById(id);

	}

	

}

package com.mdev.spring.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdev.spring.entites.Teacher;

@Repository
public interface TeacherRepository  extends JpaRepository<Teacher, Long>{
	
}

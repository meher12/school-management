package com.mdev.spring.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdev.spring.entites.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}

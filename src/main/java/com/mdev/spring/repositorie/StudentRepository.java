package com.mdev.spring.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdev.spring.entites.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}

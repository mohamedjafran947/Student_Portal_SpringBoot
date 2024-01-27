package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Student;

import jakarta.transaction.Transactional;

@EnableJpaRepositories
@Transactional
public interface StudentDB extends JpaRepository<Student, Integer>{

	@Modifying
	@Query(value = "update student set name=:name, marks=:marks, result=:result where id=:id", nativeQuery = true)
	public void updateById(@Param("id") int id, @Param("name") String name,@Param("marks") int marks,@Param("result") String result);

	@Query(value = "select * from Student k where k.marks = :marks", nativeQuery = true)
	public List<Student> searchByMarks(@Param("marks") int marks );
}

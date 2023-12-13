package com.portal.app.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.portal.app.entity.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer>{
	@Query("Select s from Student s join Address a on s.address=a.aId where a.city=:city")
   public List<Student> getStudentByCity(String city);
	@Query("Select s from Student s left join Address a on s.address=a.aId")
	public List<Student> getAllStudentAndAddress();
	
	@Query("Select s,a from Student s Right join Address a on s.address=a.aId")
	public List<Object[]> getAdressAndStudents();
}

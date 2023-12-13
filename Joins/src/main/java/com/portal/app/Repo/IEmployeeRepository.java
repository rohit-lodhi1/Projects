package com.portal.app.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.portal.app.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    
	@Query("Select e.eName,d.dName from Employee e inner Join Department d on e.department=d.dId")
	public List<Object[]> getEmpNameDeptName();
	@Query("Select e.eName,d.dName from Employee e left Join Department d on e.department=d.dId where d is Null")
	public List<Object[]> getALlEmpNameDeptIsNull();
	
	@Query("Select e.eName,d.dName from Employee e left Join Department d on e.department=d.dId ")
	public List<Object[]> getALlEmpNameDeptIfExists();
	
	@Query("Select e.eName,d.dName from Employee e left Join Department d on e.department=d.dId where d is not Null")
	public List<Object[]> getALlEmpNameDeptIsNotNull();
	@Query("Select e from Employee e left Join Department d on e.department=d.dId order By e.eName")
	public List<Object[]> getAllEmpNameDeptASC();
	@Query("Select d,e from Employee e Right join Department d on e.department = d.dId")
	public List<Object[]> getAllDeptEmpIfExists();
	
	@Query("Select e,d from Employee e Full join Department d ")
	public List<Object[]> getAllData();
	
}

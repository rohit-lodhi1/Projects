package com.Api.demo.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Api.demo.entity.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer> {
	
	
	@Query("select c from Contact c where c.userId=:id")
	public Page<Contact> getContactListByUid(@Param("id") Integer userId,org.springframework.data.domain.Pageable pageable);
	
	
	@Query("select c from Contact c where c.isFavourate=true and c.userId=:id")
	public Page<Contact> getContactListByUidAndFavourate(@Param("id") Integer userId,org.springframework.data.domain.Pageable pageable);
	
	@Query("select c from Contact c where c.contactName=:n")
	public Page<Contact> getContactListByName(@Param("n") String userName,org.springframework.data.domain.Pageable pageable);

	
	@Query("select c from Contact c where c.contactNumber=:n")
	public Contact getContactByNumber(@Param("n") Long contactNumber);

	@Transactional
	@Modifying
	@Query("update Contact c set c.isDeleted=true where c.contactId=:id")
	public void deleteContactById(@Param("id") Integer contactId);
	
	@Query(value ="select count(c.contactId) from Contact c where c.userId=:id")
	public Long getContactListByUid(@Param("id") Integer userId);
	
	
	@Query("select c.contactEmail from Contact c where c.userId=:id")
	List<String> getAllEmails(@Param("id")Integer userId);
	
	@Query("select c.contactNumber from Contact c where c.userId=:id")
	List<Long> getAllContactNumbers(@Param("id")Integer userId);
	

}

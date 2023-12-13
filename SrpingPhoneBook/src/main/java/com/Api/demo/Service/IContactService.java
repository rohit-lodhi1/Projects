package com.Api.demo.Service;

import java.util.ArrayList;

import org.springframework.data.domain.Page;

import com.Api.demo.entity.Contact;

public interface IContactService {
	public Integer createContactByUserId(Contact contact);
	public Contact getContactById(Integer contactId);
	public void deleteContactById(Integer contactId);
	public Long getContactCountByUid(Integer userId);
	public Page<Contact>  getContactByName(String contactName,Integer pageNumber,Integer pageSize);
	public Contact getContactByNumber(Long contactNumber);
	public Page<Contact> getFavourateContactByUserId(Integer userId,Integer pageNumber, Integer pageSize);
	
	
	public Iterable<Contact> getContactListByUid(Integer userId, Integer pageNumber,Integer pageSize);
	public Page<Contact> getContactsCreatedInMonth(Integer month, Integer pageNumber, Integer pageSize);

	
}

package com.Api.demo.ServiceImpl;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Api.demo.Service.IContactService;
import com.Api.demo.entity.Contact;
import com.Api.demo.exception.NotFoundException;
import com.Api.demo.repo.ContactRepo;
import com.Api.demo.repo.UserRepo;

@Service
public class ContactServiceImpl implements IContactService {
	@Autowired
	ContactRepo contactRepo;

	@Autowired
	private UserRepo userRepo;

	@Override
	public Integer createContactByUserId(Contact contact) {

		if (userRepo.existsById(contact.getUserId())) {
			List<String> allEmails = contactRepo.getAllEmails(contact.getUserId());
			for (String string : allEmails) {
				if (contact.getContactEmail().equals(string))
					return 0;

			}

			List<Long> allContactNumbers = contactRepo.getAllContactNumbers(contact.getUserId());

			for (Long long1 : allContactNumbers) {
				if (contact.getContactNumber().equals(long1))
					return 0;
			}
			
			Contact save = contactRepo.save(contact);return save.getContactId();


		}

	

	
	else 
		throw new NotFoundException("User "+contact.getUserId()+" Not Exists");
	}

	

	

	@Override
	public Contact getContactById(Integer contactId) {
		return contactRepo.findById(contactId).orElseThrow(() ->

		new NotFoundException("Contact " + contactId + " Not Found"));

	}

	@Override
	public void deleteContactById(Integer contactId) {
		if (contactRepo.existsById(contactId))
			contactRepo.deleteContactById(contactId);

		else
			throw new NotFoundException("Contact " + contactId + " Not Found");

	}

	@Override
	public Long getContactCountByUid(Integer userId) {
		if (userRepo.existsById(userId)) {
			Long count = contactRepo.getContactListByUid(userId);
			return count;
		}

		else
			throw new NotFoundException("User " + userId + " Not Exists");

	}

	@Override
	public Page<Contact> getContactByName(String contactName, Integer pageNumber, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Contact> contactList = null;

		contactList = contactRepo.getContactListByName(contactName, pageable);
		System.out.println(contactList);

		if (contactList.hasContent())
			return contactList;

		else
			throw new NotFoundException("Contact " + contactName + " Not Exists");
	}

	@Override
	public Contact getContactByNumber(Long contactNumber) {
		Contact contact = contactRepo.getContactByNumber(contactNumber);
		if (contact != null)
			return contact;
		else
			throw new NotFoundException("Contact with contact number " + contactNumber + " Not Exists");

	}

	@Override
	public Page<Contact> getFavourateContactByUserId(Integer userId, Integer pageNumber, Integer pageSize) {

		if (userRepo.existsById(userId)) {
			Pageable pageable = PageRequest.of(pageNumber, pageSize);
			Page<Contact> contactListByUid = contactRepo.getContactListByUidAndFavourate(userId, pageable);

			return contactListByUid;

		}

		else
			throw new NotFoundException("User " + userId + " Not Exists");

	}

	@Override
	public Iterable<Contact> getContactListByUid(Integer userId, Integer pageNumber, Integer pageSize) {
		if (userRepo.existsById(userId)) {
			Pageable page = PageRequest.of(pageNumber, pageSize);
			Page<Contact> findAll = contactRepo.getContactListByUid(userId, page);
			return findAll;
		} else
			throw new NotFoundException("User " + userId + " Not Exists");

	}

	@Override
	public Page<Contact> getContactsCreatedInMonth(Integer month, Integer pageNumber, Integer pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		List<Contact> findAll = contactRepo.findAll();

		for (Contact contact : findAll) {

			if (!(month == contact.getRegistrationDate().getMonth().getValue())) {
				findAll.remove(contact);
			}

		}

		int start = (int) page.getOffset();
		int end = (start + page.getPageSize()) > findAll.size() ? findAll.size() : (start + page.getPageSize());
		int totalRows = findAll.size();
		Page<Contact> pageToReturn = new PageImpl<Contact>(findAll.subList(start, end), page, totalRows);

		return pageToReturn;

	}

}

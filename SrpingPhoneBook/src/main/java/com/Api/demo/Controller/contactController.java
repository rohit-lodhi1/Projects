package com.Api.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Api.demo.Service.IContactService;
import com.Api.demo.entity.Contact;
import com.Api.demo.exception.NotFoundException;

@RestController
@RequestMapping("/phonebook/contact")
public class contactController {
	@Autowired
	IContactService contactService;
	String msg;
	Contact contact;
	

	@PostMapping("/createContact/{userId}")
	public ResponseEntity<String> createContact(@RequestBody Contact contact,@PathVariable Integer userId)
	{
		contact.setUserId(userId);
		Integer contactId=contactService.createContactByUserId(contact);
		
		
		if(contactId!=0)
			msg="Contact "+contactId+" created";
		else
			msg="Contact already exists";
		
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);		
		
	}
	
	@GetMapping("/getContact/{id}")
	public ResponseEntity<Contact> getContactById(@PathVariable Integer id) 
	{
		Contact contactById=null;
		 contactById = contactService.getContactById(id);
		
		return new ResponseEntity<Contact>(contactById,HttpStatus.OK);	
		
	}
	
	@DeleteMapping("/deleteContact/{id}")
	public ResponseEntity<String> deleteContactById(@PathVariable Integer id){
		msg="Contact "+id+" Deleted!";
		contactService.deleteContactById(id);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@PutMapping("/updateContact")
	public ResponseEntity<String> updateContact(@RequestBody Contact contact)
	{
		contactService.createContactByUserId(contact);
		msg="Contact "+contact.getContactId()+" updated!";
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/contactList/{userId}/{pageNumber}/{pageSize}")
	public ResponseEntity<Iterable<Contact>> getContactListByUid(@PathVariable Integer userId,@PathVariable Integer pageNumber,@PathVariable Integer pageSize)
	{
		return new ResponseEntity<Iterable<Contact>>(contactService.getContactListByUid(userId,pageNumber,pageSize),HttpStatus.OK);
	}
	
	@GetMapping("/contactCount/{userId}")
	public ResponseEntity<Long> getContactCountByUid(@PathVariable Integer userId){
		System.out.println(userId);
		return new ResponseEntity<Long> (contactService.getContactCountByUid(userId),HttpStatus.OK);
	}
	
	@GetMapping("/getContactList/{name}/{pageNumber}/{pageSize}")
	public ResponseEntity<Iterable<Contact>> getContactListByName(@PathVariable String name,@PathVariable Integer pageNumber,@PathVariable Integer pageSize)
	{
		return new ResponseEntity<Iterable<Contact>>(contactService.getContactByName(name,pageNumber,pageSize),HttpStatus.OK);
	}
	
	@GetMapping("/getContactByNumber/{number}")
	public ResponseEntity<Contact> getContactByNumber(@PathVariable Long number)
	{
		return new ResponseEntity<Contact>(contactService.getContactByNumber(number),HttpStatus.OK);
	}
	
	
	@GetMapping("/getContactsInMonth/{month}/{pageNumber}/{pageSize}")
	public ResponseEntity<Page<Contact>> getContactsCreatedInMonth(@PathVariable Integer month,@PathVariable Integer pageNumber,@PathVariable Integer pageSize)
	{
		return new ResponseEntity<Page<Contact>>(contactService.getContactsCreatedInMonth(month,pageNumber,pageSize),HttpStatus.OK);
	}
	
	
	@GetMapping("/favourateContact/{userId}/{pageNumber}/{pageSize}")
	public ResponseEntity<Page<Contact>> getFavourateContact(@PathVariable Integer userId, @PathVariable Integer pageNumber,@PathVariable Integer pageSize){
				return new ResponseEntity<Page<Contact>> (contactService.getFavourateContactByUserId(userId,pageNumber,pageSize),HttpStatus.OK);
	}
	
	
}

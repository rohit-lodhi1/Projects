package com.roverse.com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="book_tbl")
//@AllArgsConstructor
@NoArgsConstructor
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int bookId;
public Book(int bookId, String bookName, String author, int bookCost, String bookType) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.bookCost = bookCost;
		this.bookType = bookType;
	}
private String bookName;
private String author;
private int bookCost;
private String bookType;
}

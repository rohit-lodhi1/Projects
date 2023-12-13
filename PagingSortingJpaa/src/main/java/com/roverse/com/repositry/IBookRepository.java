package com.roverse.com.repositry;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.roverse.com.entity.Book;

public interface IBookRepository extends JpaRepository<Book, Integer> {
	
 /// fetch SIngle column data
	@Query("select b.bookName from Book b")
  public List<String> getAllBookName();
	
///  fetch All Column data
	@Query("select b from Book b")
	public List<Book> getAllBookNames();
	
///	 fetch Multiple Column data
	@Query("select b.bookName, b.bookCost from Book b")
	public List<Object[]> getAllBookNamesAndBookCost();

	@ Query("select b.bookName from Book b where b.bookId=?1")// b.bookId=?
	 public Optional<String> getBookNameByBookId(Integer id);

	@Query("select b from Book b where b.bookName Like  :prefix AND b.bookCost >= :cost")
	public List<Book> getBookByNameLikeAndCost(String prefix,Integer cost);
	@Query("select b from Book b where b.bookId IN (:list)")
	public List<Book> getBookByBookIdIn(List<Integer> list);
	
	
//	@Query("select b from Book b where b.bookName=:id AND b.bookCost=:cost")// b.bookId=?
   public List<Book> getBookNameByBookNameAndBookCost(String name,Integer cost);
	@Query("select b from Book b where b.bookName=:name")
	public List<Book> getBookByBookName(@Param("name")String bname);
	
   public List<Book> findByAuthor(String Author);
   
   public List<Book> findByBookNameOrAuthor(String Name,String Author);
   
   public List<Book> findByBookCostLessThanEqual(int cost);
   
   public List<Book> findByBookIdNot(int id);
   
   public List<Book> findByBookCostEquals(int cost);
   
   public List<Book> findByBookCostGreaterThan(int cost);
   
   public List<Book> findByAuthorIsNull();
   
   public List<Book> findByAuthorNotNull(); //findByAuthorIsNotNull
   
   public List<Book> findByAuthorLike(String expression);
   
   public List<Book> findByAuthorNotLike(String expression);
   
   public List<Book> findByAuthorStartingWith(String input);
   
   public List<Book> findByOrderByAuthorDesc();
   
   public List<Book> findByBookNameAndBookCostLessThanEqual(String name,int cost);
   
   public List<Book> findByBookIdIn(List<Integer> list);
}

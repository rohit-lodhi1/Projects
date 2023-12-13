
package com.roverse.com.runner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.roverse.com.entity.Book;
import com.roverse.com.repositry.IBookRepository;

//@Component
public class BookRunner implements CommandLineRunner {
@Autowired
private IBookRepository books;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
         List<Book>  list = Arrays.asList(new Book(0,"C","Pravesh",3000,"Language"),new Book(0,"python","bidu",500,"Language"),
        		 new Book(0,"C++","Maya",3700,"Language"),
        		 new Book(0,"java","Shankar",30000,"Language"),
        		 new Book(0,"C++","Shiv",40000,"Language"));
    //     books.saveAll(list);
         
      //      books.findByAuthor("Shiv");
         
      //      books.findByBookCostLessThanEqual(30000).forEach(System.out::println);;
         
      //      books.findByBookIdNot(17).forEach(System.out::println);
         
      //      books.findByBookCostEquals(40000).forEach(System.out::println);;
         
      //      books.findByBookCo\stGreaterThan(30000).forEach(System.out::println);;
       
      //      books.findByAuthorIsNull().forEach(System.out::println);
            
      //      books.findByAuthorNotNull().forEach(System.out::println);
         
      //      books.findByAuthorLike("Sha%").forEach(System.out::println);
              
      //      books.findByAuthorNotLike("Sha%").forEach(System.out::println);
         
      //      books.findByAuthorStartingWith("S").forEach(System.out::println);
         
      //      books.findByOrderByAuthorDesc().forEach(System.out::println);
         
       //       List<Object[]> allBookNamesAndBookCost = books.getAllBookNamesAndBookCost();
       //       allBookNamesAndBookCost.stream().map(e-> e[0]+" :"+e[1]).forEach(System.out::println);
         
//                  Optional<String> opt = books.getBookNameByBookId(15);
//
//if(opt.isPresent())
//	System.out.println(opt.get());
//else
// System.out.println(opt);
         
//         books.getBookByBookName("php").forEach(System.out::println);;
         
         //books.getBookByNameLikeAndCost("C", 400).forEach(System.out::println);;
         
     //    books.getBookByBookIdIn(Arrays.asList(15,16,10)).forEach(System.out::println);
      //      books.findByBookNameAndBookCostLessThanEqual("C", 800).forEach(System.out::println);;
         List<Book> book = books.findByBookIdIn(Arrays.asList(15,16,17));
         book.forEach(System.out::println);
	}

}

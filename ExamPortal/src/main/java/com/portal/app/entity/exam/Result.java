package com.portal.app.entity.exam;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;

import com.portal.app.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer rId;
	
   private Double marksGot;
   
   private Integer attempted;
   
   private Integer correctAnswers;
   
   
   private Date generateDate;
   
   public Result(Double marksGot,Integer attempted,Integer correctAnswers) {
	   this.marksGot=marksGot;
	   this.attempted=attempted;
	   this.correctAnswers=correctAnswers;
   }
   
   @ManyToOne
   private Quiz quiz;

   @ManyToOne
   private User user;
}

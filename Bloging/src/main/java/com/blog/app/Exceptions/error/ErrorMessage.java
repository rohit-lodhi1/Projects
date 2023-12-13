package com.blog.app.Exceptions.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

	private String message;
  
  private String code;
  private String status;
  
  
  private String date;

}

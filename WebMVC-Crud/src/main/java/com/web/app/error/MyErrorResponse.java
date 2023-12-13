package com.web.app.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyErrorResponse {
	
    private String date;
    
    private String status;
    
    private Integer code;
    
    private String message;
}

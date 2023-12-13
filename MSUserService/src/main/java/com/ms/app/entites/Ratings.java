package com.ms.app.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ratings {

	private String id;
	
	private String userId;
	
	private String hotelId;
	
	private int rating;
	
	private String feedback;
	
}

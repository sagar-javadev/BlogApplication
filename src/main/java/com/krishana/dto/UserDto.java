package com.krishana.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private Integer id;
	
	@NotEmpty(message = "User Name Not Empty"  )
	@Size(min = 2 , max = 100 , message = "User Name is min 2 and Max 100")
	private String name;
	
	@Email
	private String email;
	
	@NotEmpty(message = "User Password Not empty")
	@Size(min = 6 , max=15 , message =  "User Password Min 6 and Max =15")
	private String password;
	
	@NotBlank(message = "User Infor Not Balnk")
	private String userAbout;

}

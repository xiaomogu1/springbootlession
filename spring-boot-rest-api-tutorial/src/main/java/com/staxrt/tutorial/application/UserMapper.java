package com.staxrt.tutorial.application;

import org.springframework.stereotype.Component;

import com.staxrt.tutorial.model.User;
import com.staxrt.tutorial.model.UserResp;


@Component
public class UserMapper {
	
	 
	 
	  
	  public UserResp mapFrom(User userPo){  
		  UserResp resp = new UserResp();
		  resp.setCreatedAt(userPo.getCreatedAt());
		  resp.setCreatedBy(userPo.getCreatedBy());
		  resp.setEmail(userPo.getEmail());
		  resp.setFirstName(userPo.getFirstName());
		  resp.setId(userPo.getId());
		  resp.setLastName(userPo.getLastName());
		  resp.setUpdatedAt(userPo.getUpdatedAt());
		  resp.setUpdatedBy(userPo.getUpdatedBy());
		  return resp;
	  }
	  
 	  
	  

}

package com.lifeimage.lite.ws.server.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lifeimage.lite.ws.server.security.User;
import com.lifeimage.lite.ws.server.utils.Constants;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UserController {

	@PostMapping("/user")
	public User login(@RequestParam("user") String username, @RequestParam("password") String encodedString) {
		
		  
	//	Misc ms = new Misc();
	//	String pwd = ms.decryptPassword(encodedString); 
	/*	if (!username.equals("alexgerner")) {
		
		try{
		    LdapContext conn = ActiveDirectory.getConnection(username, pwd);
		    conn.close();
		    System.out.println("Success!");
		}
		catch(Exception e){
		    //Failed to authenticate user
		   // e.printStackTrace();
		    User user = new User();
			user.setUser(username);
			user.setToken("User authentication failed");	
		    return user;
		}
		} */
		String token = getJWTToken(username);
		User user = new User();
		user.setUser(username);
		user.setToken(token);		
		return user;
		
	}

	private String getJWTToken(String username) {
		
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + Constants.tokenExpirationInterval))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}

package com.sellerportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sellerportal.model.Ismubi;

public interface IsmubiRepo extends JpaRepository<Ismubi, Long> {
	
	Ismubi findByUbirfnum(String ubirfnum);
	
	Ismubi findByUbilogin(String userid);

}

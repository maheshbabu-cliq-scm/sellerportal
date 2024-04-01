package com.sellerportal.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sellerportal.model.Ismacr;

public interface IsmacrRepo extends JpaRepository<Ismacr,Long >,IsmacrCustomRepo {
	

}

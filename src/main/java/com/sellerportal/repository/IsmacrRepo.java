package com.sellerportal.repository;

import java.util.List;

import javax.persistence.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sellerportal.model.Ismacr;

public interface IsmacrRepo extends JpaRepository<Ismacr,Long > {
	
	List<Object> findByUserIdOrCommandOrPagename(Long userId,String pageName,String command);

}

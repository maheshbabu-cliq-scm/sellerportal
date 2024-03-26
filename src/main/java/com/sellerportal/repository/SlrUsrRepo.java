package com.sellerportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sellerportal.model.OctSlrUsr;

public interface SlrUsrRepo extends JpaRepository<OctSlrUsr,Long> {
	
	OctSlrUsr findByIsmubi(long ismubi);

}

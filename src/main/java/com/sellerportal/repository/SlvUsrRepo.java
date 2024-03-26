package com.sellerportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sellerportal.model.OctSlvUsr;

@Repository
public interface SlvUsrRepo extends JpaRepository<OctSlvUsr, Long> {
	
	OctSlvUsr findByIsmubi(long ismubi);

}

package com.sellerportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sellerportal.model.OctSlvUsr;

@Repository
public interface SlvUsrRepo extends JpaRepository<OctSlvUsr, Long> {
	
	@Query("from OctSlvUsr slv where slv.ismubi.ubirfnum=:ubirfnum")
	OctSlvUsr findByIsmubi(long ubirfnum);

}

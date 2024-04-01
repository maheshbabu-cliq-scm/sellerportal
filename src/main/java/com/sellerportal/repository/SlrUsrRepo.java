package com.sellerportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sellerportal.model.OctSlrUsr;

@Repository
public interface SlrUsrRepo extends JpaRepository<OctSlrUsr,Long> {
	
	@Query("from OctSlrUsr slr where slr.ismubi.ubirfnum=?1 order by slr.createdate desc")
	OctSlrUsr findByIsmubi(long ismubi);

}

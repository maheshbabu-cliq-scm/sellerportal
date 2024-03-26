package com.sellerportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sellerportal.model.OctParam;

public interface ParamRepo extends JpaRepository<OctParam, Long> {
	
	OctParam findByParamcode(String paramcode);
	
	OctParam findByParamgroupAndParamcode(String paramgroup,String paramcode);

}

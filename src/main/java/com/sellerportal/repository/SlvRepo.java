package com.sellerportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sellerportal.model.OctSlv;

public interface SlvRepo extends JpaRepository<OctSlv,Long> {
	
	@Query(value="SELECT osi.slvinfofname, slv.octslvRetAddress.uatphone FROM OctSlv slv,"
			+ " OctSlvInfo osi WHERE slv.octslvrfnum = osi.octSlv.octslvrfnum AND slv.octslvcode = ?1 ")
	Object[] findBySlaveCode(String slaveCode);

}

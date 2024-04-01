package com.sellerportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sellerportal.model.Ismubi;

@Repository
public interface LoginRepository extends JpaRepository<Ismubi,Long> {
	
	@Query("SELECT ubi.ubilogin FROM Ismubi ubi WHERE ubi.ubilogin =?1 AND ubi.ubipass = ?2 " +
	           "AND (ubi.ubilogin != 'superadmin@anmsoft.com' OR (ubi.ubiactive = 'Y' AND ubi.deleted = 'N'))")
	String findByUbiloginAndUbipass(String ubilogin,String ubipass);

	Ismubi findByUbilogin(String loginId);
	
	@Query("SELECT ubi.ubilogin FROM Ismubi ubi WHERE ubi.ubilogin =?1 " +
	           "AND (ubi.ubilogin != 'superadmin@anmsoft.com' OR (ubi.ubiactive = 'Y' AND ubi.deleted = 'N'))")
	String checkValidLoginUser(String ubilogin);

}

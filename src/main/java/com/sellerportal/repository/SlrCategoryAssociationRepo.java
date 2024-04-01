package com.sellerportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sellerportal.model.SlrCategoryAssociation;

public interface SlrCategoryAssociationRepo extends JpaRepository<SlrCategoryAssociation,Long> {
	
	@Query("from SlrCategoryAssociation where ismcmt.cmtcode=:categorycode and octSlr.octslrlcode=:sellerCode")
	SlrCategoryAssociation   findBySellercodeCatgoryCode(String sellerCode,String categorycode);

}

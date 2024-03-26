package com.sellerportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sellerportal.model.OctSlrScore;

public interface SlrScoreRepo extends JpaRepository<OctSlrScore, Long> {

	@Query("select imgUrl,rating,sellerRatingPdfUrl,totalScore from OctSlrScore where slrCode=?1 order by modidate desc")
	Object[] findImgUrl(String slrCode,String resultOfDays);
}

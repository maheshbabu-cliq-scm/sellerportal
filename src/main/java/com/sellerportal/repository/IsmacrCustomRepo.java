package com.sellerportal.repository;

import java.util.List;

public interface IsmacrCustomRepo {

	List<Object> findByUserIdOrCommandOrPagename(Long userId, String pageName, String command);

}

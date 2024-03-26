package com.sellerportal.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.sellerportal.model.Ismacr;
import com.sellerportal.repository.IsmacrCustomRepo;
import com.sellerportal.repository.IsmacrRepo;

public class IsmacrRepoImpl implements IsmacrCustomRepo{

	@Autowired
	EntityManager entityManager;

	@Override
	public List<Object> findByUserIdOrCommandOrPagename(Long userId,String pageName,String command) {
	
		List retval = new ArrayList();
		Session hibSession = null;
		StringBuffer sb = new StringBuffer();
			String queryString = "";
			boolean check = true;
			sb.append("select ismacm.ismapm.apmpagetitle || '-' || ismacm.ismapm.apmpagename,ismacm.command from Ismacr acr WHERE acr.ismarm in (select aur.ismarm from Ismaur aur where aur.ismubi.ubirfnum=:userId and aur.deleted='N' and aur.active='Y') and acr.deleted = 'N' and ismacm.ismapm.active = 'Y'"); 

			if(command!=null && !command.equals("") && pageName!=null && !pageName.equals("")){
				sb.append("AND acr.ismacm in (from Ismacm acm where acm.command=:command AND acm.ismapm.apmpagename=:pageName)");
				check = false;
			}

			if(check && command!=null && !command.equals("")){
				sb.append("AND acr.ismacm in (from Ismacm acm where acm.command=:command");
			}
			if(check && pageName!=null && !pageName.equals("")){
				sb.append("AND acr.ismacm in (from Ismacm acm where acm.ismapm.apmpagename=:pageName");
			}

			queryString = sb.toString();
			javax.persistence.Query query=entityManager.createNativeQuery(queryString);
			query.setParameter("userId", userId);
			if(command!=null && !command.equals("")){
				query.setParameter("command", command);
			}
			if(pageName!=null && !pageName.equals("")){
				query.setParameter("pageName",pageName);
			}
			
			retval = query.getResultList();
			return retval;
	}

}


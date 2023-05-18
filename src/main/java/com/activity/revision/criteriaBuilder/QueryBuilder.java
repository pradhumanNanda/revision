package com.activity.revision.criteriaBuilder;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Service;
import com.activity.revision.requests.SearchRequest;
import com.activity.revision.user.Role;
import com.activity.revision.user.UserDb;

@Service
public class QueryBuilder {
	
	@PersistenceContext EntityManager entityManager;
	
	public List<UserDb> searchUser(SearchRequest searchRequest){
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<UserDb> criteriaQuery = criteriaBuilder.createQuery(UserDb.class);
		
		Root<UserDb> root = criteriaQuery.from(UserDb.class);
		
		String userName = searchRequest.getUserName();
		
		String email = searchRequest.getEmail();
		
		String contactNumber = searchRequest.getContactNumber();
		
		String salaryRange = searchRequest.getSalaryRange();
		
		Boolean isDeleted = searchRequest.getIsDeleted();
		
		Role role = searchRequest.getRole();
		
		List<Predicate> searchCriteria = new ArrayList<>();
		
		if(userName != null) {
			searchCriteria.add(criteriaBuilder.like(root.get("userName"), userName));
		}
		if(email != null) {
			searchCriteria.add(criteriaBuilder.like(root.get("email"), email));
		}
		if(contactNumber != null) {
			searchCriteria.add(criteriaBuilder.like(root.get("contactNumber"), contactNumber));
		}
		if(salaryRange != null) {
			Integer idx = salaryRange.indexOf('-');
			Double lowerBound = Double.parseDouble(salaryRange.substring(0,idx)), 
				   upperBound = Double.parseDouble(salaryRange.substring(idx+1,salaryRange.length()));
			
			searchCriteria.add(criteriaBuilder.between(root.get("salary"),lowerBound,upperBound));
		}
		if(isDeleted != null) {
			searchCriteria.add(criteriaBuilder.equal(root.get("isDeleted"), isDeleted));
		}
		if(role != null) {
			searchCriteria.add(criteriaBuilder.equal(root.get("role"), role));
		}
		
		criteriaQuery.select(root).where(criteriaBuilder.and(searchCriteria.toArray(new Predicate[searchCriteria.size()])));
		
		return entityManager.createQuery(criteriaQuery).getResultList();
		
	}

}

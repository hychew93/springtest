package com.springtest.search2.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springtest.search2.configuration.CommentRepositoryCustom;
import com.springtest.search2.model.Comment;
@Repository
public class CommentRepositoryImpl implements CommentRepositoryCustom<Comment>{
	 @Autowired
	 private EntityManager em;
	 
	 @Override
	 public List<Comment> findByProperty(Map<String, String> map) {
	        CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<Comment> cq = cb.createQuery(Comment.class);
	 
	        Root<Comment> comment = cq.from(Comment.class);
	        List<Predicate> predicates = new ArrayList<>();
	        for(String key : map.keySet()){
	        	Predicate prec = cb.equal(comment.get(key), map.get(key));
	        	predicates.add(prec);
	        }
	        cq.where(predicates.toArray(new Predicate[predicates.size()]));
	        TypedQuery<Comment> query = em.createQuery(cq); 
	        return query.getResultList();
	    }

 
}

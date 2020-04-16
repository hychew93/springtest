package com.springtest.search2;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepositoryImp implements CommentRepositoryCustom{
	 	@Autowired
	    @Lazy
	    CommentRepository commentRepository;

		@Override
		public List<Comment> findByProperty(Map<String, String> map) {
			// TODO Auto-generated method stub
			return null;
		}
	 
	 /*@Override
	 public List<Comment> findByProperty(Map<String, String> map) {
	        CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<Comment> cq = cb.createQuery(Comment.class);
	 
	        Root<Comment> comment = cq.from(Comment.class);
	        for(String key : map.keySet()){
	        	Predicate test = cb.equal(comment.get(key), map.get(key));
	        	cq.where(test);
	        }
	        TypedQuery<Comment> query = em.createQuery(cq);
	        return query.getResultList();
	    }*/
}

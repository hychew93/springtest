package com.springtest.search2.repo;
import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.springtest.search2.model.IPostCount;
import com.springtest.search2.model.Post;


public interface PostRepository extends PagingAndSortingRepository<Post, Integer>  {
	
	List<Post> findById(Long pid);
	
	@Query(value = "select P.id as id,p.body as body,p.title as title,count(*) as totalComments " + 
			"from posts as P " + 
			"left join comments on P.id = post_id " + 
			"group by P.id " + 
			"order by totalComments desc " + 
			"LIMIt 1", nativeQuery = true)
	List<IPostCount> findTopPost();

}

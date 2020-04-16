package com.springtest.search2.configuration;

import java.util.List;
import java.util.Map;

public interface  CommentRepositoryCustom<Comment> {
	/*List<Comment> findByProperty(Map<String, String> map);*/

	List<Comment> findByProperty(Map<String, String> map);
}

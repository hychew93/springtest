package com.springtest.search2.configuration;

import java.util.List;
import java.util.Map;

public interface  CommentRepositoryCustom<T> {
	/*List<Comment> findByProperty(Map<String, String> map);*/

	List<T> findByProperty(Map<String, String> map);
}

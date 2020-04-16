package com.springtest.search2;

import java.util.List;
import java.util.Map;

public interface  CommentRepositoryCustom {
	List<Comment> findByProperty(Map<String, String> map);
}

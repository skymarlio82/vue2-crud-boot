
package com.vue2.test.boot.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vue2.test.boot.data.entity.Todo;

@Repository("todoDao")
public interface TodoDao extends JpaRepository<Todo, Long> {

	@Query("from Todo td")
	List<Todo> findAll();

}
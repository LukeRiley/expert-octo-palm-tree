package io.trade.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.trade.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
	
	List<Category> findAll();
	List<Category> findByName(String name);
}


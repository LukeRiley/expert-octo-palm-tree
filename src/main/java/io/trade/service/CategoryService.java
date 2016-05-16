package io.trade.service;

import java.util.List;

import io.trade.model.Category;

public interface CategoryService {

	List<Category> findAll();

	List<Category> findByName(String name);

	void add(Category category);


}

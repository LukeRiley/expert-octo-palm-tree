package io.trade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.trade.model.Category;
import io.trade.repository.CategoryRepository;
@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categories;
	private final DatabaseService database;

	@Autowired
	public CategoryServiceImpl(CategoryRepository categories, DatabaseService db) {
		this.categories = categories;
		this.database = db;
		this.database.setCategories(this);
	}

	@Override
	public List<Category> findAll() {
		return categories.findAll();
	}

	@Override
	public List<Category> findByName(String name) {
		return categories.findByName(name);
	}

	@Override
	public void add(Category category) {
		try{
		categories.save(category);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}

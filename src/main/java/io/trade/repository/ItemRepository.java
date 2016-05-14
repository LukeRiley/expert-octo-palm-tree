package io.trade.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.trade.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {
	
	List<Item> findAll();
	List<Item> findByNameContains(String search);
	List<Item> findByDescriptionContains(String search);
}


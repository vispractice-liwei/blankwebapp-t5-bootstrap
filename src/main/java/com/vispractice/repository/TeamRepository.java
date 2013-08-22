package com.vispractice.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vispractice.domain.Team;

public interface TeamRepository extends CrudRepository<Team, String> {
	
	Team findByName(String name);
	
	@Query("{'name': ?0}")
	List<Team> findByName2(String names, Pageable page);

}

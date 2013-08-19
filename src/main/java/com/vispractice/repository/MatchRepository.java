package com.vispractice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vispractice.domain.Match;

public interface MatchRepository extends CrudRepository<Match, Long> {

	@Query("select u from Match u where u.name = ?")
	Match findByName(String name);
	
	

}

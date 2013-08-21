package com.vispractice.repository;

import org.springframework.data.repository.CrudRepository;

import com.vispractice.domain.Match;

public interface MatchRepository extends CrudRepository<Match, String> {

	Match findByName(String name);
	
}

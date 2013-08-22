package com.vispractice.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vispractice.domain.Match;

public interface MatchRepository extends CrudRepository<Match, String> {

	Match findByName(String name);
	
	@Query("{'kickoff': ?0, 'name': ?1}")
	Match findByVersus(Date kickoff, String name);
	
	@Query("{'kickoff': ?0, 'name': ?1, 'home.$id': ?2}")
	Match findByVersusId(Date kickoff, String name, String homeId);
	
}

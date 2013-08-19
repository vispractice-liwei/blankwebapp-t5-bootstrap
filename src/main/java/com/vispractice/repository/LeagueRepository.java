package com.vispractice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vispractice.domain.League;

public interface LeagueRepository extends CrudRepository<League, Long> {

	@Query("select u from League u JOIN FETCH u.matches where u.name = ? and u.season = ?")
	public League findByNameAndSeason(String name,String season);
	
	@Query("select u from League u LEFT JOIN FETCH u.matches where u.id = ?")
	public League findById(Long id);
	
}

package com.vispractice.repository;

import org.springframework.data.repository.CrudRepository;

import com.vispractice.domain.League;

public interface LeagueRepository extends CrudRepository<League, String> {

	public League findByNameAndSeason(String name,String season);
	
	public League findById(Long id);
	
}

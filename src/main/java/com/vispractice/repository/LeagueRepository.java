package com.vispractice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.vispractice.domain.League;

public interface LeagueRepository extends PagingAndSortingRepository<League, String> {

	public League findByNameAndSeason(String name,String season);
	
	public League findById(Long id);
	
}

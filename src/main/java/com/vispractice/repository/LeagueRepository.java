package com.vispractice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vispractice.domain.League;

public interface LeagueRepository extends CrudRepository<League, Long> {

	@Query("select u from League u where u.name = ? and u.season = ?")
	League findByNameAndSeason(String name,String season);

}

package com.vispractice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vispractice.domain.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {

	@Query("select u from Team u where u.name = ?")
	Team findByName(String name);

}

package com.vispractice.repository;

import org.springframework.data.repository.CrudRepository;

import com.vispractice.domain.Team;

public interface TeamRepository extends CrudRepository<Team, String> {
	
	Team findByName(String name);

}

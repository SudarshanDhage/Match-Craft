package com.matchcraft.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matchcraft.domain.Hobby;

@Repository
public interface HobbyRepository extends JpaRepository<Hobby, Long> {
	
	public List<Hobby> findAll();
    public List<Hobby> findByName(String name);
}

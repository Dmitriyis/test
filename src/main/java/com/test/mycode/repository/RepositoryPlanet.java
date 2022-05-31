package com.test.mycode.repository;

import com.test.mycode.entity.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryPlanet extends JpaRepository<Planet, Long> {
    Optional<Planet> findByName(String name);

}

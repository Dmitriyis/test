package com.test.mycode.service;

import com.test.mycode.entity.Planet;
import com.test.mycode.exception.ExceptionPlanet;
import com.test.mycode.repository.RepositoryPlanet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ServicePlanet {

    private final RepositoryPlanet repositoryPlanet;

    @Transactional
    public Planet savePlanet(Planet planet) {
        return repositoryPlanet.save(planet);
    }

    @Transactional(readOnly = true)
    public Planet getPlanetName(String name) {
        var planet = repositoryPlanet.findByName(name)
                .orElseThrow(() -> new ExceptionPlanet("There is no planet with that name"));
        return planet;
    }

    @Transactional(readOnly = true)
    public Planet getPlanetId(Long id) {
        return repositoryPlanet.findById(id)
                .orElseThrow(() -> new ExceptionPlanet("There is no planet with that id"));
    }

    @Transactional
    public void deletePlanet(Planet planet) {
        repositoryPlanet.delete(planet);
    }
}

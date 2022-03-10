package com.test.mycode.web.rest;

import com.test.mycode.dto.PlanetDto;
import com.test.mycode.entity.Planet;
import com.test.mycode.service.ServicePlanet;
import com.test.mycode.util.mappeng.PlanetMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("planet/")
@RequiredArgsConstructor
public class RestControllerPlanet {

    private final ServicePlanet servicePlanet;

    @PostMapping("add")
    public ResponseEntity<PlanetDto> savePlanet(@RequestParam String name) {
        return ResponseEntity.ok().body(PlanetMapping.PlanetToPlanetDtoSave(servicePlanet
                .savePlanet(Planet.builder().name(name).build())));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Long> deletePlanet(@PathVariable Long id) {

        var planet = servicePlanet.getPlanetId(id);

        servicePlanet.deletePlanet(planet);

        return ResponseEntity.ok().build();
    }

}

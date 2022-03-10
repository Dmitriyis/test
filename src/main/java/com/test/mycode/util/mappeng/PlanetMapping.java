package com.test.mycode.util.mappeng;

import com.test.mycode.dto.PlanetDto;
import com.test.mycode.entity.Planet;

public class PlanetMapping {

    public static PlanetDto PlanetToPlanetDtoSave(Planet planet) {
        return PlanetDto.builder().name(planet.getName()).build();
    }
}

package com.test.mycode.util.mappeng;

import com.test.mycode.dto.LordDto;
import com.test.mycode.dto.PlanetDto;
import com.test.mycode.entity.Lord;

import java.util.List;
import java.util.stream.Collectors;

public class LordMapping {

    public static LordDto lordToLordDtoSave(Lord lord) {
        return LordDto.builder().name(lord.getName()).age(lord.getAge()).build();
    }

    public static LordDto lordToLordDtoAddPlanet(Lord lord) {

        var listPlanetDto = lord.getPlanetList().stream().map(planet -> {
            return PlanetDto.builder().name(planet.getName()).nameLord(lord.getName()).build();
        }).collect(Collectors.toList());

        return LordDto.builder().name(lord.getName()).age(lord.getAge()).planetDto(listPlanetDto).build();
    }

    public static List<LordDto> listLordToListLordDto(List<Lord> listLord) {
        return listLord.stream().map(lord -> {
            return LordDto.builder().name(lord.getName()).age(lord.getAge()).build();
        }).collect(Collectors.toList());
    }

}

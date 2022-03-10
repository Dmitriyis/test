package com.test.mycode.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class LordDto {

    private String name;

    private Long age;

    private List<PlanetDto> planetDto;

}

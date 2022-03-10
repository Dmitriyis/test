package com.test.mycode.web.rest;

import com.test.mycode.dto.LordDto;
import com.test.mycode.entity.Lord;
import com.test.mycode.service.ServiceLord;
import com.test.mycode.service.ServicePlanet;
import com.test.mycode.util.mappeng.LordMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("lord/")
public class RestControllerLord {

    private final ServiceLord serviceLord;
    private final ServicePlanet servicePlanet;

    @PostMapping("add")
    public ResponseEntity<LordDto> saveLord(@RequestParam String name,
                                      @RequestParam Long age) {

        return ResponseEntity.ok().body(LordMapping.lordToLordDtoSave(serviceLord
                .saveLord(Lord.builder().name(name).age(age).build())));
    }

    @PatchMapping("addPlanet")
    public ResponseEntity<LordDto> addPlanet(@RequestParam String namePlanet, @RequestParam Long lordId) {

        var planet = servicePlanet.getPlanetName(namePlanet);

        var lord = serviceLord.getLordId(lordId);

        lord.getPlanetList().add(planet);

        return ResponseEntity.ok().body(LordMapping.lordToLordDtoAddPlanet(serviceLord.addPlanet(lord)));
    }

    @GetMapping("allLord")
    public ResponseEntity<List<LordDto>> getAllLordNoPlanet() {
        return ResponseEntity.ok().body(LordMapping
                .listLordToListLordDto(serviceLord.showLordNoPlanet()));
    }

    @GetMapping("limitLordYoung/{limit}")
    public ResponseEntity<List<LordDto>> getYoungLordLimit(@PathVariable Long limit) {
        return ResponseEntity.ok().body(LordMapping
                .listLordToListLordDto(serviceLord.showLordYoungLordLimit(limit)));
    }
}

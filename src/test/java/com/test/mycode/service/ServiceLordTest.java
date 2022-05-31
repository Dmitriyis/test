package com.test.mycode.service;


import com.test.mycode.entity.Lord;
import com.test.mycode.entity.Planet;

import com.test.mycode.repository.RepositoryLord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ServiceLordTest {

    @Mock
    private RepositoryLord repositoryLord;

    @InjectMocks
    private ServiceLord serviceLord;

    @Test
    void saveLord() {
        Lord lord = Lord.builder().name("LordTest").age(22l).planetList(null).build();
        when(repositoryLord.save(any(Lord.class))).thenReturn(lord);

        Lord actualLord = serviceLord.saveLord(lord);

        assertEquals(actualLord, lord);

    }

    @Test
    void addPlanet() {
        Lord lord = Lord.builder().name("LordTest").age(22l).id(1l).planetList(null).build();
        Planet planet = Planet.builder().name("MarsTest").lord(lord).build();
        lord.setPlanetList(List.of(planet));
        when(repositoryLord.save(any(Lord.class))).thenReturn(lord);

        Lord actualLord = serviceLord.addPlanetToLord(lord);

        assertEquals(actualLord, lord);
    }

    @Test
    void getLordId() {
        Lord lord = Lord.builder().name("LordTest").age(22l).planetList(null).id(1l).build();
        when(repositoryLord.findById(1l)).thenReturn(Optional.ofNullable(lord));

        Lord actualLord = serviceLord.getLordById(1l);

        assertEquals(actualLord, lord);
    }

    @Test
    void showLordNoPlanet() {
        List lordNotPlanet = List.of(
                Lord.builder().name("LordTest1").age(22l).planetList(null).id(1l).build(),
                Lord.builder().name("LordTest2").age(22l).planetList(null).id(2l).build(),
                Lord.builder().name("LordTest3").age(22l).planetList(null).id(3l).build(),
                Lord.builder().name("LordTest4").age(22l).planetList(null).build()
        );
        when(repositoryLord.getLordNoPlanet()).thenReturn(lordNotPlanet);

        List<Lord> actualLords = serviceLord.showLordNoPlanet();
        long count = actualLords.stream().filter(lord -> lord.getPlanetList() != null).count();

        assertEquals(0, count);
    }
}
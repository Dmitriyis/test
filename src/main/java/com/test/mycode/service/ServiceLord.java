package com.test.mycode.service;

import com.test.mycode.entity.Lord;
import com.test.mycode.exception.ExceptionLord;
import com.test.mycode.repository.RepositoryLord;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceLord {

    private final RepositoryLord repositoryLord;

    @Transactional
    public Lord saveLord(Lord lord) {
        return repositoryLord.save(lord);
    }

    @Transactional
    public Lord addPlanet(Lord lord) {
        lord.getPlanetList();
        return repositoryLord.save(lord);
    }

    @Transactional(readOnly = true)
    public Lord getLordId(Long id) {
        return repositoryLord.findById(id)
                .orElseThrow(() -> new ExceptionLord("There is no lord by such id"));
    }

    @Transactional(readOnly = true)
    public List<Lord> showLordNoPlanet() {
        return repositoryLord.getLordNoPlanet();
    }

    @Transactional
    public List<Lord> showLordYoungLordLimit(Long limit) {
        return repositoryLord.getYoungLordLimit(limit);
    }
}

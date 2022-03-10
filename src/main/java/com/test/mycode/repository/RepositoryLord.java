package com.test.mycode.repository;

import com.test.mycode.entity.Lord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RepositoryLord extends JpaRepository<Lord, Long> {

    @Query("select l from Lord l where l.planetList.size < 1")
    List<Lord> getLordNoPlanet();

    @Query(value = "select * from lord l order by l.age limit :limit", nativeQuery = true)
    List<Lord> getYoungLordLimit(@Param(value = "limit") Long limit);

}

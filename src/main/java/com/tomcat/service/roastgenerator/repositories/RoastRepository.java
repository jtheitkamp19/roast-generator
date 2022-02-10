package com.tomcat.service.roastgenerator.repositories;

import com.tomcat.service.roastgenerator.models.Roast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoastRepository extends JpaRepository<Roast, Long> {
    @Query(value = "SELECT COUNT(*) FROM roast")
    int getRoastCount();
}

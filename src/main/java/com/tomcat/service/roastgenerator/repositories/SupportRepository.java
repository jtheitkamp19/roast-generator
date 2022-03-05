package com.tomcat.service.roastgenerator.repositories;

import com.tomcat.service.roastgenerator.models.Support;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportRepository extends JpaRepository<Support, Long> {
    @Query(value = "SELECT COUNT(*) FROM support")
    int getRoastCount();

    @Query(value = "SELECT MAX(id) FROM support")
    int getCurrentId();
}

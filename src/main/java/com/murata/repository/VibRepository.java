package com.murata.repository;

import com.murata.model.TempSensor;
import com.murata.model.VibSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VibRepository extends JpaRepository<VibSensor,String> {

    public VibSensor findBySensorId(String id);

    public VibSensor findTopBySensorIdOrderByTsDesc(String id);

    @Query(value="select distinct s.sensorId  from VibSensor s ")
    public List<String> findDistinctSensorsId();

}

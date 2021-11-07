package com.murata.repository;

import com.murata.model.Sensor;
import com.murata.model.TempSensor;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TempRepository extends JpaRepository<TempSensor,String> {

    public TempSensor findBySensorId(String id);

    public TempSensor findTopBySensorIdOrderByTsDesc(String id);

    @Query(value="select distinct s.sensorId  from TempSensor s ")
    public List<String> findDistinctSensorsId();



}

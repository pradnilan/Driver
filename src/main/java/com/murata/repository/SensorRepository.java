package com.murata.repository;

import com.murata.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface SensorRepository<E extends Sensor> extends JpaRepository<Sensor,String> {
}

package com.murata.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Comparator;


@MappedSuperclass
@ToString @Getter @Setter
public class Sensor  implements Serializable{

    private LocalDateTime ts;
    private String sensorId ;
    private String stateCode ;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value",column =@Column(name="volt_value")),
            @AttributeOverride(name = "scale",column =@Column(name="volt_scale")),
            @AttributeOverride(name = "unit",column =@Column(name="volt_unit"))
    })
    private Reading volt;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value",column =@Column(name="temp_value")),
            @AttributeOverride(name = "scale",column =@Column(name="temp_scale")),
            @AttributeOverride(name = "unit",column =@Column(name="temp_unit"))
    })
    private Reading temp;

    public Sensor() {}

    public Sensor(String sensorId) {
        this.sensorId = sensorId;
    }



}

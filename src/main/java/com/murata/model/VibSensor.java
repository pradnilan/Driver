package com.murata.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter@Setter@ToString
public class VibSensor extends Sensor implements Comparable<VibSensor>{

    @Id
    @SequenceGenerator(name="VibSensor_Sequence",sequenceName = "VibSensor_Sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "VibSensor_Sequence")
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value",column =@Column(name="accRMS_value")),
            @AttributeOverride(name = "scale",column =@Column(name="accRMS_scale")),
            @AttributeOverride(name = "unit",column =@Column(name="accRMS_unit"))
    })
    private Reading accRms;

    public VibSensor() {}

    @Override
    public int compareTo(VibSensor o) {
        return this.getSensorId().compareTo(o.getSensorId());
    }
}

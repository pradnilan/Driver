package com.murata.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter@Setter@ToString
public class TempSensor extends Sensor implements Comparable<TempSensor>{

    @Id
    @SequenceGenerator(name="TempSensor_Sequence",sequenceName = "TempSensor_Sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "TempSensor_Sequence")
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value",column =@Column(name="rh_value")),
            @AttributeOverride(name = "scale",column =@Column(name="rh_scale")),
            @AttributeOverride(name = "unit",column =@Column(name="rh_unit"))
    })
    private Reading rh;

    public TempSensor() {}


    @Override
    public int compareTo(TempSensor o) {
       return this.getSensorId().compareTo(o.getSensorId());
    }
}

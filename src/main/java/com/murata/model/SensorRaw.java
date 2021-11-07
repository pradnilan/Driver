package com.murata.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter@Setter@AllArgsConstructor
public class SensorRaw implements Comparable<SensorRaw>{

    private String sensorId;
    private Integer fileTs;
    private String line;
    private LocalDateTime ts;
    @Id
    @SequenceGenerator(name="SensorRaw_Sequence",sequenceName = "SensorRaw_Sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SensorRaw_Sequence")
    private Long id;

    public SensorRaw() {}

    public SensorRaw(String sensorId, Integer fileTs, String line,LocalDateTime ts) {
        this.sensorId = sensorId;
        this.fileTs = fileTs;
        this.line = line;
        this.ts=ts;
    }

    @Override
    public int compareTo(SensorRaw sensorRaw) {
        if(this.getTs()==sensorRaw.getTs()) return 0;
        else if (this.getTs()==sensorRaw.getTs()) return -1;
        else return 1;
    }

}

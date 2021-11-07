package com.murata.model;


import javax.persistence.Embeddable;

@Embeddable
public class Reading {

    private float value;
    private float scale;
    private String unit;

    public Reading() {}

    public Reading(float value, float scale, String unit) {
        this.value = value;
        this.scale = scale;
        this.unit = unit;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


    @Override
    public String toString() {
        return "Reading{" +
                "value=" + value +
                ", scale=" + scale +
                ", unit='" + unit + '\'' +
                '}';
    }

}

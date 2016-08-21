package com.hibernate.annotation.dto._05_inheritance._04_subclassTable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AttributeOverride(name = "vehicleName", column =
  @Column(name = "FOUR_WHEELER_NAME")
)
@Table (name="FOUR_WHEELER_23_SUBCLASS_TABLE")
public class FourWheeler23SubclassTable extends Vehicle23SubclassTable {
	
	@Id @GeneratedValue(strategy=GenerationType.TABLE)
    @Column(name = "ID")
    private int id;
	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
}

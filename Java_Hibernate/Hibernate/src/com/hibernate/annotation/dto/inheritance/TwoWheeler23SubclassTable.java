package com.hibernate.annotation.dto.inheritance;

import javax.persistence.AttributeOverride;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AttributeOverride(name = "vehicleName", column =
  @Column(name = "TWO_WHEELER_NAME")
)
@Table (name="TWO_WHEELER_23_SUBCLASS_TABLE")
public class TwoWheeler23SubclassTable extends Vehicle23SubclassTable {
	
	@Id @GeneratedValue(strategy=GenerationType.TABLE)
    @Column(name = "ID")
    private int id;
	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}
}

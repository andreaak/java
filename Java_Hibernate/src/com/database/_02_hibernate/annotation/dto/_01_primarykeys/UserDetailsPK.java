package com.database._02_hibernate.annotation.dto._01_primarykeys;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.database._02_hibernate.annotation.dto.UserDetailsBase;

@Entity 
@Table (name="USER_DETAILS_PK")
public class UserDetailsPK extends UserDetailsBase {

}

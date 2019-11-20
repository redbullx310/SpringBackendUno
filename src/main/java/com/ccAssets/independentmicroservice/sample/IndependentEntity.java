package com.ccAssets.independentmicroservice.sample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "INDEPENDENT_ENTITY")
public class IndependentEntity {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "PROPERTY_ONE")
	private String property1;
	
	@Column(name = "PROPERTY_TWO")
	private String property2;
	
	@Column(name = "PROPERTY_THREE")
	private String property3;

}

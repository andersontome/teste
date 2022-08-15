package com.facility.integrator.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProcessData implements Serializable {

	private static final long serialVersionUID = 776620290485943540L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idProcessData;

	@Column
	String changeType;

	@Column
	String versionNumber;
}

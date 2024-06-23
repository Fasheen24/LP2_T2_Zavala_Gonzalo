package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.*;


@Entity
@Table(name = "tb_area")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AreaEntitiy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "area_id",nullable = false, unique = true)
	private int areaid;
	@Column(name="nombre_area",nullable = false, length = 45)
	private String nomarea;
	


	
}

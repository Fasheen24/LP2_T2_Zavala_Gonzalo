package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_area")
public class AreaEntitiy {
	
	
	
	public AreaEntitiy() {
		super();
	}
	
	
	public AreaEntitiy(Integer areaid, String nomarea) {
		super();
		this.areaid = areaid;
		this.nomarea = nomarea;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "area_id",nullable = false, unique = true)
	private Integer areaid;
	@Column(name="nombre_area",nullable = false, length = 45)
	private String nomarea;
	
	
	public Integer getAreaid() {
		return areaid;
	}


	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}


	public String getNomarea() {
		return nomarea;
	}


	public void setNomarea(String nomarea) {
		this.nomarea = nomarea;
	}
	
	
	


	
}

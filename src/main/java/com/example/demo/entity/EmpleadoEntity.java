package com.example.demo.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="tb_empleado")
public class EmpleadoEntity {
	
	
	
	public EmpleadoEntity() {
		super();
	}


	public EmpleadoEntity(String dni, String nomemp, String apeemp, Date fechemp, String direc, String correo,
			AreaEntitiy areaEntity) {
		super();
		this.dni = dni;
		this.nomemp = nomemp;
		this.apeemp = apeemp;
		this.fechemp = fechemp;
		this.direc = direc;
		this.correo = correo;
		this.areaEntity = areaEntity;
	}


	 @Id
	    @Column(name = "dni_empleado", nullable = false, unique = true, length = 8)
	    private String dni;
	@Column(name="nombre_empleado",nullable = false, length = 45)
	private String nomemp;
	@Column(name="apellido_empleado",nullable = false, length = 45)
	private String apeemp;
	@Column(name="fecha_nacimiento",nullable = false, length = 45)
	@Temporal(TemporalType.DATE)
	private Date fechemp;
	@Column(name="direccion", nullable = false, length = 45)
	private String direc;
	@Column(name="correo", nullable = false, length = 45)
	private String correo;
	
	
	@ManyToOne(fetch  = FetchType.LAZY)
	@JoinColumn(name = "area_id", nullable = false)
	private AreaEntitiy areaEntity;


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNomemp() {
		return nomemp;
	}


	public void setNomemp(String nomemp) {
		this.nomemp = nomemp;
	}


	public String getApeemp() {
		return apeemp;
	}


	public void setApeemp(String apeemp) {
		this.apeemp = apeemp;
	}


	public Date getFechemp() {
		return fechemp;
	}


	public void setFechemp(Date fechemp) {
		this.fechemp = fechemp;
	}


	public String getDirec() {
		return direc;
	}


	public void setDirec(String direc) {
		this.direc = direc;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public AreaEntitiy getAreaEntity() {
		return areaEntity;
	}


	public void setAreaEntity(AreaEntitiy areaEntity) {
		this.areaEntity = areaEntity;
	}







}

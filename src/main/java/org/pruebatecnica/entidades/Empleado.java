package org.pruebatecnica.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_empleado")
	private Integer id;
	
	@Column(name = "nombres")
	private String nombres;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "sexo")
	private Boolean sexo;
	
	@Column(name = "edad")
	private Integer edad;
	
	@Column(name = "servicios_profecionales")
	private Boolean serviciosProfesionales;

	@Column(name = "salario")
	private Double salario;
	
	@ManyToOne
	@JoinColumn(name = "pk_puesto")
	private Puesto puesto;
	
	public Empleado() {
		super();
	}

	public Empleado(Integer id, String nombres, String apellidos, Boolean sexo, Integer edad, Boolean serviciosProfesionales, Double salario, Puesto puesto) {
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.edad = edad;
		this.serviciosProfesionales = serviciosProfesionales;
		this.salario = salario;
		this.puesto = puesto;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Boolean getSexo() {
		return sexo;
	}

	public void setSexo(Boolean sexo) {
		this.sexo = sexo;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Boolean getServiciosProfesionales() {
		return serviciosProfesionales;
	}

	public void setServiciosProfesionales(Boolean serviciosProfesionales) {
		this.serviciosProfesionales = serviciosProfesionales;
	}

	public Puesto getPuesto() {
		return puesto;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", sexo=" + sexo + ", edad="
				+ edad + ", serviciosProfesionales=" + serviciosProfesionales + ", salario=" + salario + ", puesto=" + puesto + "]";
	}
	
}

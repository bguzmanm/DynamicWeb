package model.entity;

import java.util.Date;

public class Estudiante {

	private int id;
	private String nombre;
	private String apellido;
	private String rut;

	private Date nacimiento;
	
	private double ingresos;

	public Estudiante() {
		super();
	}

	public Estudiante(int id, String nombre, String apellido, String rut, Date nacimiento, double ingresos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
		this.nacimiento = nacimiento;
		this.ingresos = ingresos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public Date getNacimiento() {
		return nacimiento;
	}


	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public double getIngresos() {
		return ingresos;
	}

	public void setIngresos(double ingresos) {
		this.ingresos = ingresos;
	}

}

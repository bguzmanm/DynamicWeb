package model.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entity.Estudiante;

public class EstudianteService {

	private List<Estudiante> estudiantes = new ArrayList<Estudiante>();

	
	public EstudianteService() {
		super();
		llenaEstudiantes();
	}


	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	
	
	private void llenaEstudiantes() {
		
		estudiantes.add(new Estudiante(1, "Natalia", "Ponce", "1-1", Date.valueOf("2001-06-27"), 3500000d));
		estudiantes.add(new Estudiante(2, "Damián", "Martínez", "2-2", Date.valueOf("1997-04-26"), 500000d));
		estudiantes.add(new Estudiante(3, "Amanda", "Díaz", "3-3", Date.valueOf("2010-03-21"), 400000d));
		
		
		
	}
	
}

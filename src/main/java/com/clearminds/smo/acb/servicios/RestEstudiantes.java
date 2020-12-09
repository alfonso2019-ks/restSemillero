package com.clearminds.smo.acb.servicios;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.clearminds.acb.dtos.Estudiante;
import com.clearminds.acb.excepciones.BDDException;
import com.clearminds.acb.servicios.ServicioEstudiante;

@Path("/estudiantes")
public class RestEstudiantes {
	
	@Path("/insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void ingresar(Estudiante estudiante) {
		ServicioEstudiante estudianteService = new ServicioEstudiante();
		try {
			estudianteService.insertarEstudiante(estudiante);
			System.out.println("Estudiante registrado");
		}catch (BDDException e) {
			e.printStackTrace();
		}
	}
	
	
	@Path("/actualizar")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizar(Estudiante estudiante) {
		ServicioEstudiante estudianteService = new ServicioEstudiante();
		try {
			if(estudiante != null) {
				estudianteService.actualizarEstudiante(estudiante);
				System.out.println("Estudiante actualizado");
			}else {
				System.out.println("Llega estudiante en null");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

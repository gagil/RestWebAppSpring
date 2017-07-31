package org.gagl.restwebapp.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.gagl.core.modelo.Persona;
import org.gagl.core.servicio.GeneralService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController implements Serializable {
	
	private static final long serialVersionUID = 197124382449394390L;

	static final Logger LOGGER = Logger.getLogger(PersonaController.class);
	
	@Autowired
	private GeneralService generalService;
	
	@RequestMapping(value= "/personas", method = RequestMethod.GET)
	public List<Persona> obtienePersonas(){
		List<Persona> lista=new ArrayList<Persona>();
		//Persona entidad=new Persona();
		
		//entidad.setNombre("juan");
		//entidad.setDireccion("guatemala");
		
		//lista.add(entidad);
		
		try {			
			lista=this.generalService.obtenerPersonas();
			LOGGER.info("Obtuve la lista de personas");			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error(e.getMessage());
		}
		return lista;
	}

}

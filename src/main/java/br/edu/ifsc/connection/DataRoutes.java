package br.edu.ifsc.connection;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsc.algoritmo.Routing;
import br.edu.ifsc.dataaccess.DataAccess;
import br.edu.ifsc.datastructure.Grafo;
import br.edu.ifsc.interfaces.IRouting;
import br.edu.ifsc.model.Front;
import br.edu.ifsc.model.FrontToBack;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST IFSCRounting")
public class DataRoutes {

	private IRouting route;
	private DataAccess acess;
	private Grafo grafo;

	public DataRoutes() {
		acess = new DataAccess();
		grafo = acess.pegarArquivo();
		route = new Routing();
	}

	//@CrossOrigin
	@ApiOperation(value = "Teste")
	@RequestMapping(value = "/exemplo", method = RequestMethod.GET)
	public FrontToBack entrada() {
		FrontToBack front = new FrontToBack();
		front.setDestino("Estufa");
		return front;
	}
	
	//@CrossOrigin
	@ApiOperation(value = "Caminho")
	@RequestMapping(value = "/caminho", method = RequestMethod.POST)
	public FrontToBack routing(@RequestBody @Valid String front) {
		FrontToBack frontBack = new FrontToBack();
		frontBack.setDestino(route.bestRoute(front + "_", grafo));
		return frontBack;
	}
}

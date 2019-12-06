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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class DataRoutes {

	private IRouting route;
	private DataAccess acess;
	private Grafo grafo;

	public DataRoutes() {
		acess = new DataAccess();
		grafo = acess.pegarArquivo();
		route = new Routing();
	}

	@CrossOrigin
	@RequestMapping(value = "/caminho", method = RequestMethod.POST)
	public ResponseEntity<String> routing(@RequestBody @Valid String destino) {
		String caminho = route.bestRoute(destino + "_", grafo);
		return new ResponseEntity<String>(caminho, HttpStatus.OK);
	}
}

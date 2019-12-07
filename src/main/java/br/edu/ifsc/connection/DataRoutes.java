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

	@CrossOrigin
	@ApiOperation(value = "Teste")
	@RequestMapping(value = "/exemplo", method = RequestMethod.GET)
	public ResponseEntity<String> entrada() {
		String local = "Estufa";
		return new ResponseEntity<>(local, HttpStatus.OK);
	}
	
    @CrossOrigin
    @RequestMapping(value = "/teste", method = RequestMethod.GET)
    public ResponseEntity<Integer> occupySlot() {
        int slot = 2;
        if (slot > 0)
            return new ResponseEntity<>(slot, HttpStatus.OK);
        return new ResponseEntity<>(slot, HttpStatus.UNAUTHORIZED);
    }

	@CrossOrigin
	@ApiOperation(value = "Caminho")
	@RequestMapping(value = "/caminho", method = RequestMethod.POST)
	public ResponseEntity<String> routing(@PathVariable String destino) {
		String caminho = route.bestRoute(destino + "_", grafo);
		return new ResponseEntity<>(caminho, HttpStatus.OK);
	}
}

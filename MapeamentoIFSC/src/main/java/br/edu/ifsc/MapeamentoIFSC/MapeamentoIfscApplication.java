package br.edu.ifsc.MapeamentoIFSC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifsc.algoritmo.Routing;
import br.edu.ifsc.dataaccess.DataAccess;
import br.edu.ifsc.datastructure.Grafo;
import br.edu.ifsc.interfaces.IRouting;

@SpringBootApplication
public class MapeamentoIfscApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapeamentoIfscApplication.class, args);

		DataAccess dt = new DataAccess();
		Grafo g1 = dt.pegarArquivo();
		IRouting route = new Routing();
		// TODO verificar colocar a direção dos nodos
		String caminho = route.bestRoute("Quadra_", g1);

		System.out.println(caminho.toString());

	}

}

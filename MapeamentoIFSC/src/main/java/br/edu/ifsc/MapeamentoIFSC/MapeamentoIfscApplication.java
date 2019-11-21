package br.edu.ifsc.MapeamentoIFSC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifsc.dataaccess.DataAccess;
import br.edu.ifsc.datastructure.Grafo;

@SpringBootApplication
public class MapeamentoIfscApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapeamentoIfscApplication.class, args);
		
		DataAccess dt = new DataAccess();
		Grafo g1 = dt.pegarArquivo();
		
	System.out.println(g1.toString());
		
	}

}

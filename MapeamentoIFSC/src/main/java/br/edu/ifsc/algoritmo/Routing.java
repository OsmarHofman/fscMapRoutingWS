package br.edu.ifsc.algoritmo;

import br.edu.ifsc.datastructure.Grafo;
import br.edu.ifsc.datastructure.Vertice;
import br.edu.ifsc.interfaces.IRouting;

public class Routing implements IRouting {

	@Override
	public String bestRoute(String dest,Grafo g) {
		Vertice inicial = g.pesquisaVertice("Saguão");
		Vertice destino = g.pesquisaVertice(dest);
		return new AprofundamentoIterativo().buscaAprofundamentoIterativo(g, destino, inicial);
	}

}

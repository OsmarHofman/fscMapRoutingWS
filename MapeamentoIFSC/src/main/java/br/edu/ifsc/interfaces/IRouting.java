package br.edu.ifsc.interfaces;

import br.edu.ifsc.datastructure.Grafo;

public interface IRouting {

	String bestRoute(String dest, Grafo g);
}

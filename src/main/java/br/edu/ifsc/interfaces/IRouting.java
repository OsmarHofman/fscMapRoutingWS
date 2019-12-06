package br.edu.ifsc.interfaces;

import br.edu.ifsc.datastructure.Grafo;

public interface IRouting {

	/**
	 * Encontra a melhor rota do Saguão até um determinado destino dentro do Câmpus
	 * 
	 * @param dest Destino para onde o usuário deseja ir
	 * @param g    Grafo que contém as conexões entre os locais
	 * @return Texto que representa quais direções o usuário deverá ir
	 */
	String bestRoute(String dest, Grafo g);
}

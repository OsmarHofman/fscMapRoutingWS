package br.edu.ifsc.datastructure;

import java.util.ArrayList;
import java.util.List;

public class Caminho {

	private List<Vertice> caminho;
	private String caminhoPercorrido;


	public Caminho() {

	}

	

	public Caminho(List<Vertice> caminho, String caminhoPercorrido) {
		super();
		this.caminho = caminho;
		this.caminhoPercorrido = caminhoPercorrido;
	}

	
	public List<Vertice> getCaminho() {
		return caminho;
	}


	public void setCaminho(List<Vertice> caminho) {
		this.caminho = caminho;
	}



	public String getCaminhoPercorrido() {
		return caminhoPercorrido;
	}



	public void setCaminhoPercorrido(String caminhoPercorrido) {
		this.caminhoPercorrido = caminhoPercorrido;
	}



	/**
	 * Converte o {@link Grafo}, para um {@link Caminho} a partir de um
	 * {@link String} que representa o {@link Vertice}
	 * 
	 * @param aGrafo           {@link Grafo} a ser convertido
	 * @param aVertices        {@link String} que representa os {@link Vertices}
	 * @param lDistanciaMinima {@link Double} que representa a distância total
	 *                         percorrida
	 * @return
	 */
	
	/*
	public static Caminho converter(Grafo aGrafo, String aVertices, Double lDistanciaMinima, int nosGerados,
			int nosExpandidos, long tempoProcessamento) {
		String[] lNomes = aVertices.split(" / ");
		Caminho lCaminho = new Caminho(lDistanciaMinima, nosGerados, nosExpandidos, tempoProcessamento);
		for (int indice = 0; indice < lNomes.length; indice++) {
			if ((indice + 1) != lNomes.length) {
				Vertice lVerticeOrigem = aGrafo.pesquisaVertice(lNomes[indice].trim());
				Vertice lVerticeDestino = aGrafo.pesquisaVertice(lNomes[indice + 1].trim());
				lCaminho.getCaminho().add(new DistanciaEntre2Paises(lVerticeOrigem.toString(),
						lVerticeDestino.toString(), lVerticeDestino.obterDistancia()));
			}
		}
		return lCaminho;
	}*/

	/**
	 * Converte o {@link Grafo}, para um {@link Caminho} a partir de um
	 * {@link Vertice} final
	 * 
	 * @param aGrafo           {@link Grafo} a ser convertido
	 * @param aFinal           {@link Vertice} de destino da busca
	 * @param lDistanciaMinima {@link Double} que representa a distância total a ser
	 *                         percorrida
	 * @return
	 */
	/*
	public static Caminho converter(Grafo aGrafo, Vertice aFinal, Double lDistanciaMinima, int nosGerados,
			int nosExpandidos, long tempoProcessamento) {
		String[] lNomes = aFinal.getCaminho().split("/");
		Caminho lCaminho = new Caminho(lDistanciaMinima, nosGerados, nosExpandidos, tempoProcessamento);
		for (int indice = 0; indice < lNomes.length; indice++) {
			if ((indice + 1) != lNomes.length) {
				Vertice lVerticeOrigem = aGrafo.pesquisaVertice(lNomes[indice].trim());
				Vertice lVerticeDestino = aGrafo.pesquisaVertice(lNomes[indice + 1].trim());
				lCaminho.getCaminho().add(new DistanciaEntre2Paises(lVerticeOrigem.toString(),
						lVerticeDestino.toString(), lVerticeDestino.obterDistancia()));
			}
		}
		return lCaminho;
	}*/



	@Override
	public String toString() {
		return "Caminho [caminho=" + caminho + ", caminhoPercorrido=" + caminhoPercorrido + "]";
	}
	

}

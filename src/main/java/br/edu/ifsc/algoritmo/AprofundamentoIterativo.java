package br.edu.ifsc.algoritmo;

import java.util.ArrayList;

import br.edu.ifsc.basestructure.Fila;
import br.edu.ifsc.datastructure.Arco;
import br.edu.ifsc.datastructure.Grafo;
import br.edu.ifsc.datastructure.Vertice;

public class AprofundamentoIterativo {
	// Variável de controle para caso o destino seja encontrado
	private boolean encontrou_caminho = false;

	private ArrayList<Arco> lista_filhos = new ArrayList<>();

	public String buscaAprofundamentoIterativo(Grafo g, Vertice inicial, Vertice destino) {
		// Lista de Vertices resultantes da busca
		encontrou_caminho = false;
		Vertice vertice_final = new Vertice();

		// Variável para controlar o limite da busca
		int limite = 0;

		// Caso o encontrou_caminho seja true,significa que foi encontrado o vertice
		// de destino,e retornará o vertice_final
		while (!encontrou_caminho) {
			vertice_final = buscaProfundidadeLimitada(g, inicial, destino, limite);
			// Limite é incrementado para caso o caminho não seja encontrado na iteração
			limite++;
		}

		return Vertice.ajustaCaminho(vertice_final);
	}

	/**
	 * Realiza a busca em profundidade de um certo grafo, a partir de um vertice
	 * inicial
	 * 
	 * @param g       Grafo com as origens, destinos e pesos
	 * @param inicial Vertice inicial (raiz) a começar a busca
	 * @return A lista com os vertices que podem ser alcançados
	 */

	private Vertice buscaProfundidadeLimitada(Grafo g, Vertice inicial, Vertice destino, int limite) {

		// Variável contadora para comparar com o limite
		int cont = 0;
		// Método utilizdo para reiniciar as informações do grafo (Vertices - distancia,
		// visitas e caminho), em todos o métodos e não ficar repetindo código.
		Grafo.reiniciarGrafo(g);

		// faz a primeira visita a partir do vertice escolhido como o inicial
		inicial.visitar();
		inicial.definirDistancia(0);
		inicial.setCaminho(null, 0);

		// cria e adiciona o vértice inicial a fila
		Fila fila = new Fila();
		fila.push(inicial);
		try {
			// o laço irá se repetir até não ter mais vértices a serem analisados
			while (!fila.estaVazia()) {

				// Recebe o vertice da iteração atual, presente no inicio da fila
				Vertice atual = fila.getInicio().getInfo();

				// retira um vértice da fila
				fila.pop();
				// Verifica se a busca está sendo feita até o limite
				if (cont <= limite) {

					// Verifica se o atual é igual ao destino
					if (atual.equals(destino)) {
						encontrou_caminho = true;
						return atual;
					} else {

						// Recebe todos os caminhos possíveis(arcos) do vértice da iteração atual
						lista_filhos = atual.obterArcos();

						// Para cada arco do vértice atual
						for (Arco arco : lista_filhos) {

							// Recebe o vértice de destino do arco (filho)
							Vertice filho = arco.getDestino();

							// entra no if se o vértice filho não foi visitado ainda
							if (filho.obterVisitado() == 0) {

								// marca que o vértice filho foi visitado
								filho.visitar();

								// reajusta a distância do vértice filho
								filho.definirDistancia(arco.getPeso());

								// diz que para chegar nesse vértice filho, é a partir de seu anterior (pai)

								filho.setCaminho(atual.getCaminho(), filho.obterDistancia());

								// insere o vértice filho a fila
								fila.push(filho);

								// Verifica se o filho é igual ao destino
								if (filho.equals(destino)) {
									encontrou_caminho = true;
									return filho;
								}
							}

							// visita o vértice atual (pai)
							atual.visitar();
						}
					}
				}
				// Incrementa o cont para ir para próximo nível da arvore
				cont++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return destino;
	}

}

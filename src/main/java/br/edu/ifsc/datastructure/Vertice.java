package br.edu.ifsc.datastructure;

import java.io.Serializable;
import java.util.ArrayList;

public class Vertice implements Serializable {

	private static final long serialVersionUID = 1L;

	// Lista de arcos que saem do vértice
	private final ArrayList<Arco> arcos = new ArrayList<>();

	// Rótulo do vértice: serve para identificação
	private final String rotulo;

//Os quatro próximos atributos são utilizados pelos algoritmos de grafos.

	// Quando o valor de visitado for 0 (zero) significa que o vértice ainda
	// não foi visitado pelo algoritmo. Em cada nova visita o método deve invocar
	// o método visitar() para incrementar este valor. O método zerarVisitas()
	// zera este valor novamente. O método obterVisitado() informa o valor atual.
	private int visitado = 0;

	// Vários algoritmos irão medir a distância de um vértice até outro. Este
	// atributo servirá como um "medidor auxiliar de distância", armazenando
	// temporariamente distâncias nas iterações dos algoritmos. Os métodos
	// definirDistancia(), zerarDistancia() e obterDistancia() devem ser usados.
	private int distancia = Integer.MAX_VALUE;

	// Algoritmos de caminhos podem precisar da informação de qual caminho foi
	// utilizado para se obter a distância informada. O caminho é uma String
	// Contendo os rótulos dos vértices utilizados para chegar até o vértice
	private String caminho = "";

	public Vertice(String rotulo) {
		this.rotulo = rotulo;
	}

	public Vertice() {
		this.rotulo = "";
	}

	/**
	 * Adiciona um {@link Arco} a esse vértice, dado um {@link Vertice} de destino e
	 * seu peso
	 * 
	 * @param destino {@link Vertice} de destino do {@link Arco}
	 * @param peso    valor em ponto flutuante do peso do {@link Arco}
	 */
	public void adicionarArco(Vertice destino, int peso) {
		this.arcos.add(new Arco(this, destino, peso));
	}

	/**
	 * Retorna todos os {@link Arco}s do {@link Vertice}
	 * 
	 * @return {@link ArrayList} de {@link Arco} do Vértice
	 */
	public ArrayList<Arco> obterArcos() {
		return this.arcos;
	}

	/**
	 * Simboliza que o {@link Vertice} já foi visitado
	 */
	public void visitar() {
		this.visitado++;
	}

	/**
	 * Retorna o valor relativo a quantas visitas foram realizadas a partir desse
	 * {@link Vertice}
	 * 
	 * @return número de vezes que foi visitado
	 */
	public int obterVisitado() {
		return this.visitado;
	}

	/**
	 * Limpa e zera o valor relacionado a se o {@link Vertice} foi visitado
	 */
	public void zerarVisitas() {
		this.visitado = 0;
	}

	/**
	 * Adiciona um valor infinito a distancia para "zerá-la"
	 */
	public void zerarDistancia() {
		this.distancia = Integer.MAX_VALUE;
	}

	/**
	 * Define o valor da distância do {@link Vertice}
	 * 
	 * @param distancia número que representa a distância do vértice da raiz
	 */
	public void definirDistancia(int distancia) {
		this.distancia = distancia;
	}

	/**
	 * Retorna o valor que representa a distância da raiz até este {@link Vertice}
	 * 
	 * @return distância total da raiz até este {@link Vertice}
	 */
	public int obterDistancia() {
		return this.distancia;
	}

	/**
	 * Retorna qual o caminho percorrido (pais, avós, bisavos,etc.) deste
	 * {@link Vertice}
	 * 
	 * @return {@link String} contendo todo o caminho para chegar a este
	 *         {@link Vertice}
	 */
	public String getCaminho() {
		if (caminho == null || caminho.equals("")) {
			return this.rotulo;
		}
		String nome[] = this.rotulo.split(" / ");
		return caminho + ", " + nome[0].trim();
	}

	/**
	 * Atribui o rótulo ao caminho deste vértice
	 * 
	 * @param caminho {@link String} com o caminho para chegar a este
	 *                {@link Vertice}
	 */
	public void setCaminho(String caminho, int distancia) {
		this.caminho = (caminho == null) ? null : caminho + distancia;
	}

	@Override
	public String toString() {
		return this.rotulo;
	}

	@Override
	public boolean equals(Object o) {
		return o.toString().equals(this.rotulo);
	}

	/**
	 * Retorna uma {@link String} que representa um caminho do Saguão até o
	 * {@link Vertice} destino informado.
	 * 
	 * @param vertice {@link Vertice} de destino
	 * @return {@link String} que indica qual o caminho que deve ser percorrido até
	 *         o destino
	 */
	public static String ajustaCaminho(Vertice vertice) {
		String caminhoFinal = "";
		String[] caminhos = vertice.getCaminho().split(",");
		for (int i = caminhos.length - 1; i > 0; i--) {
			caminhoFinal += "Do (a)";
			// Verifica se é o local inicial (Saguão), caso contrário formata o local para
			// visualização
			caminhoFinal += (i == caminhos.length - 1) ? caminhos[i].replace("_", "") : getLocal(caminhos[i]);
			String[] separaDirecao = caminhos[i - 1].trim().split("_");
			caminhoFinal += " dirija-se à " + getDirecao(separaDirecao[1]) + " até o (a)" + getLocal(separaDirecao[0])
					+ ";\n";
		}
		return caminhoFinal.trim();
	}

	/**
	 * A partir de um local do caminho de um {@link Vertice}, retorna o seu nome
	 * formatado para facilitar a visualização
	 * 
	 * @param caminhos {@link String} que representa o local a ser adicionado ao
	 *                 caminho final
	 * @return {@link String} formatada que representa um local a ser percorrido
	 *         pelo usuário
	 */
	private static String getLocal(String caminhos) {
		String[] caminhoIntermediario = caminhos.split("_");
		if (caminhoIntermediario[0].contains("Escada")) {
			String caminhoEscada = " Escada";
			String andar = caminhoIntermediario[0].split("-")[1];
			return (andar.equals("1")) ? caminhoEscada + "(Primeiro Andar)" : caminhoEscada + "(Térreo)";
		} else if (caminhoIntermediario[0].contains("Porta"))
			return " Porta";
		else
			return " " + caminhoIntermediario[0].trim();
	}

	/**
	 * A partir de um número representado por uma {@link String}, retorna qual a
	 * direção que deve ser seguida
	 * 
	 * @param caminho {@link String} que representa uma direção a ser seguida,
	 *                sendo:<br>
	 *                - 1 == frente;<br>
	 *                - 2 == direita;<br>
	 *                - 3 == esquerda.
	 * @return A direção a ser tomada pelo usuário
	 */
	private static String getDirecao(String caminho) {
		if (Integer.valueOf(caminho) == 1)
			return "frente";
		else if (Integer.valueOf(caminho) == 2)
			return "direita";
		else
			return "esquerda";
	}

}

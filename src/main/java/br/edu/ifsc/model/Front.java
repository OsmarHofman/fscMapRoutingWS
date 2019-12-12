package br.edu.ifsc.model;

public class Front {
	private FrontToBack front;

	/**
	 * Retorna a classe {@link FrontToBack},classe responsável para receber os dados
	 * do Front-end
	 * 
	 * @return {@link FrontToBack} contendo as informações de algoritmo,origem e
	 *         destino
	 */
	public FrontToBack getFront() {
		return front;
	}

	public void setFront(FrontToBack front) {
		this.front = front;
	}
}

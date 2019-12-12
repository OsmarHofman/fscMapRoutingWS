package br.edu.ifsc.model;

public class FrontToBack {
	
	private String destino;

	public FrontToBack() {

	}

	/**
	 * Retorna o país de destino da busca que deverá ser realizada
	 * 
	 * @return uma String com o rótulo do país de destino
	 */
	public String getDestino() {
		return destino;
	}
	
	

	public void setDestino(String destino) {
		this.destino = destino;
	}

	@Override
	public String toString() {
		return "FrontToBack [destino=" + destino + "]";
	}
}

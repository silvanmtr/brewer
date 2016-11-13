/**
 * 
 */
package br.com.brewer.repository.filter;

import br.com.brewer.model.Estado;

/**
 * @author Silvan de Jesus
 *
 */
public class CidadeFilter {

	private String nome;
	private Estado estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}

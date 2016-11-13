/**
 * 
 */
package br.com.brewer.model;

/**
 * @author Silvan de Jesus
 *
 */
public enum Origem {
	NACIONAL("Nacional"),
	INTERNACIONAL("Internacional");
	
	private String descricao;
	
	
	Origem(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}

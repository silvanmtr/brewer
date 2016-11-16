/**
 * 
 */
package br.com.brewer.service.event.venda;

import br.com.brewer.model.Venda;

/**
 * @author Silvan de Jesus
 *
 */
public class VendaEvent{

	private Venda venda;
	
	public VendaEvent(Venda venda) {
		this.venda = venda;
	}

	public Venda getVenda() {
		return venda;
	}
}

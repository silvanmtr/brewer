/**
 * 
 */
package br.com.brewer.service.event.venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.brewer.model.Cerveja;
import br.com.brewer.model.ItemVenda;
import br.com.brewer.repository.Cervejas;

/**
 * @author Silvan de Jesus
 *
 */

@Component
public class VendaListener {

	@Autowired
	private Cervejas cervejas;
	
	@EventListener
	public void vendaEmitida(VendaEvent vendaEvent){
		for(ItemVenda item : vendaEvent.getVenda().getItens()){
			Cerveja cerveja = cervejas.findOne(item.getCerveja().getCodigo());
			
			cerveja.setQuantidadeEstoque(cerveja.getQuantidadeEstoque() - item.getQuantidade());
			
			cervejas.save(cerveja);
		}
	}
}

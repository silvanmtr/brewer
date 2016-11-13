/**
 * 
 */
package br.com.brewer.repository.helper.cerveja;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.brewer.dto.VendaMes;
import br.com.brewer.dto.VendaOrigem;
import br.com.brewer.model.Venda;
import br.com.brewer.repository.filter.VendaFilter;

/**
 * @author Silvan de Jesus
 *
 */
public interface VendasQueries {
	public Page<Venda> filtrar(VendaFilter filtro, Pageable pageable);
	
	public Venda buscarComItens(Long codigo);
	
	public BigDecimal valorTotalNoAno();
	
	public BigDecimal valorTotalNoMes();
	
	public List<VendaOrigem> totalPorOrigem();
	
	public BigDecimal valorTicketMedioNoAno();
	
	public List<VendaMes> totalPorMes();
}

/**
 * 
 */
package br.com.brewer.repository.helper.cerveja;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.brewer.model.Cidade;
import br.com.brewer.repository.filter.CidadeFilter;


/**
 * @author Silvan de Jesus
 *
 */
public interface CidadesQueries {
	public Page<Cidade> filtrar(CidadeFilter filtro, Pageable pageable);
}

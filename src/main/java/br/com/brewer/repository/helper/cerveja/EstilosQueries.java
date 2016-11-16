/**
 * 
 */
package br.com.brewer.repository.helper.cerveja;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.brewer.model.Estilo;
import br.com.brewer.repository.filter.EstiloFilter;

/**
 * @author Silvan de Jesus
 *
 */
public interface EstilosQueries {
	public Page<Estilo> filtrar(EstiloFilter filtro, Pageable pageable);
}

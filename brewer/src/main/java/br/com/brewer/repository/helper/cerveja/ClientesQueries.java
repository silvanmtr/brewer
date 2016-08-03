/**
 * 
 */
package br.com.brewer.repository.helper.cerveja;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.brewer.model.Cliente;
import br.com.brewer.repository.filter.ClienteFilter;

/**
 * @author Silvan de Jesus
 *
 */
public interface ClientesQueries {
	public Page<Cliente> filtrar(ClienteFilter filtro, Pageable pageable);
}

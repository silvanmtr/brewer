/**
 * 
 */
package br.com.brewer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.brewer.model.Cerveja;
import br.com.brewer.repository.helper.cerveja.CervejasQueries;

/**
 * @author Silvan de Jesus
 *
 */

@Repository
public interface Cervejas extends JpaRepository<Cerveja, Long>, CervejasQueries {
	
	public Optional<Cerveja> findBySkuIgnoreCase(String sku);
}

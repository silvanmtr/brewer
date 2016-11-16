/**
 * 
 */
package br.com.brewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brewer.model.Venda;
import br.com.brewer.repository.helper.cerveja.VendasQueries;

/**
 * @author Silvan de Jesus
 *
 */
public interface Vendas extends JpaRepository<Venda, Long>, VendasQueries {

}

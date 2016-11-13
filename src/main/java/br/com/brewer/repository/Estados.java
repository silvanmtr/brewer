/**
 * 
 */
package br.com.brewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brewer.model.Estado;

/**
 * @author Silvan de Jesus
 *
 */
public interface Estados extends JpaRepository<Estado, Long> {

}

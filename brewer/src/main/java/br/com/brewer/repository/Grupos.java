/**
 * 
 */
package br.com.brewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.brewer.model.Grupo;

/**
 * @author Silvan de Jesus
 *
 */
@Repository
public interface Grupos extends JpaRepository<Grupo, Long>{
	
}

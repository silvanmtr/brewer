/**
 * 
 */
package br.com.brewer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brewer.model.Cliente;
import br.com.brewer.repository.helper.cerveja.ClientesQueries;

/**
 * @author Silvan de Jesus
 *
 */
public interface Clientes extends JpaRepository<Cliente, Long>, ClientesQueries{

	Optional<Cliente> findByCpfOuCnpj(String cpfOuCnpj);
}

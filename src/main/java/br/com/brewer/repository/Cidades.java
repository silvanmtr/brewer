/**
 * 
 */
package br.com.brewer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brewer.model.Cidade;
import br.com.brewer.model.Estado;
import br.com.brewer.repository.helper.cerveja.CidadesQueries;

/**
 * @author Silvan de Jesus
 *
 */
public interface Cidades extends JpaRepository<Cidade, Long>, CidadesQueries {
	public List<Cidade> findByEstadoCodigo(Long codigoEstado);

	public Optional<Cidade> findByNomeAndEstado(String nome, Estado estado);
}

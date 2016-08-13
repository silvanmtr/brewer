/**
 * 
 */
package br.com.brewer.repository.helper.cerveja;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.brewer.model.Usuario;
import br.com.brewer.repository.filter.UsuarioFilter;

/**
 * @author Silvan de Jesus
 *
 */
public interface UsuariosQueries {
	public Page<Usuario> filtrar(UsuarioFilter filtro, Pageable pageable);
	public Optional<Usuario> porEmailEAtivo(String email);
}

/**
 * 
 */
package br.com.brewer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.brewer.model.Estilo;
import br.com.brewer.repository.Estilos;
import br.com.brewer.service.exception.NomeEstiloJaCadastradoException;

/**
 * @author Silvan de Jesus
 *
 */
@Service
public class CadastroEstiloService {
	@Autowired
	private Estilos estilos;
	
	@Transactional
	public Estilo salvar(Estilo estilo){
		Optional<Estilo> estiloOptional = estilos.findByNomeIgnoreCase(estilo.getNome());
		
		if(estiloOptional.isPresent()){
			throw new NomeEstiloJaCadastradoException("Nome do estilo já cadastrado");
		}
		
		return estilos.saveAndFlush(estilo);
	}
}

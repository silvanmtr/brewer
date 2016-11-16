package br.com.brewer.service;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.brewer.model.Cerveja;
import br.com.brewer.repository.Cervejas;
import br.com.brewer.service.event.cerveja.CervejaSalvaEvent;
import br.com.brewer.service.exception.ImpossivelExcluirEntidadeException;
import br.com.brewer.storage.FotoStorage;

@Service
public class CadastroCervejaService {

	@Autowired
	private Cervejas cervejas;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private FotoStorage fotoStorage;
	
	@Transactional
	public void salvar(Cerveja cerveja){
		cervejas.save(cerveja);
		publisher.publishEvent(new CervejaSalvaEvent(cerveja));
	}
	
	@Transactional
	public void excluir(Cerveja cerveja){
		
		try {
			
			String foto = cerveja.getFoto();
			cervejas.delete(cerveja);
			cervejas.flush();
			//fotoStorage.excluir(foto);
		} catch (PersistenceException e) {
			throw new ImpossivelExcluirEntidadeException("Impossível apagar cerveja, já foi usada em alguma venda");			
		}
	}
}


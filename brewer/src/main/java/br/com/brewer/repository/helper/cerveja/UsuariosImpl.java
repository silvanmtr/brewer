/**
 * 
 */
package br.com.brewer.repository.helper.cerveja;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.brewer.model.Usuario;
import br.com.brewer.repository.filter.UsuarioFilter;
import br.com.brewer.repository.paginacao.PaginacaoUtil;

/**
 * @author Silvan de Jesus
 *
 */
public class UsuariosImpl implements UsuariosQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private PaginacaoUtil paginacaoUtil;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> filtrar(UsuarioFilter filtro, Pageable pageable) {

		Criteria criteria = manager.unwrap(Session.class).createCriteria(Usuario.class);
		
		paginacaoUtil.preparar(criteria, pageable);
		
		adicionarFiltro(filtro, criteria);

		return new PageImpl<>(criteria.list(), pageable, total(filtro));
	}

	private void adicionarFiltro(UsuarioFilter filtro, Criteria criteria) {
		if(filtro != null){
			
			
			if (!StringUtils.isEmpty(filtro.getNome())) {
				criteria.add(Restrictions.ilike("nome", filtro.getNome().replace("+", " "), MatchMode.ANYWHERE));
			}
			
		}
	}
	
	private Long total(UsuarioFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Usuario.class);
		adicionarFiltro(filtro, criteria);

		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	@Override
	public Optional<Usuario> porEmailEAtivo(String email) {
		return manager
				.createQuery("from Usuario where lower(email) = lower(:email) and ativo = true", Usuario.class)
				.setParameter("email", email).getResultList().stream().findFirst();
	}

	

}

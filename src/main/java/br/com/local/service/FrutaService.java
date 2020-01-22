package br.com.local.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.local.domain.entity.Fruta;

@ApplicationScoped
public class FrutaService {
	
	@Inject
    EntityManager em; 
	
	@Transactional
	public Fruta salvarFruta(Fruta novaFruta) {
		em.persist(novaFruta);
		em.flush();
		return novaFruta;
	}
	
	public Fruta buscarFrutaPorNome(final String nome) {
		return em.find(Fruta.class, nome);
	}
}

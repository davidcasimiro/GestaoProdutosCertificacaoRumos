package service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Produto;

/**
 * Session Bean implementation class ProdutoFacade
 */
@Stateless
@LocalBean
public class ProdutoFacade extends AbstractFacade<Produto> {
	@PersistenceContext(unitName = "GProdutos_PU")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}
	
    /**
     * Default constructor. 
     */	
    public ProdutoFacade() {
    	super(Produto.class);
    }

}
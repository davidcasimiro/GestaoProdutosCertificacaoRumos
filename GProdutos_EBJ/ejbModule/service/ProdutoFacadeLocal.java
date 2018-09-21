package service;

import java.util.List;

import javax.ejb.Local;

import entity.Produto;

@Local
public interface ProdutoFacadeLocal {

	void create(Produto entity);
	
	void edit(Produto entity);
	
	void remove(Produto entity);
	
	Produto find(Object codigo);
	
	List<Produto> findAll();
	
	int count();
	
}

package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(name="descricao")
	private String descricao;

	//bi-directional many-to-one association to Subcategoria
	@OneToMany(mappedBy="categoria")
	private List<Subcategoria> subcategorias;

	public Categoria() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Subcategoria> getSubcategorias() {
		return this.subcategorias;
	}

	public void setSubcategorias(List<Subcategoria> subcategorias) {
		this.subcategorias = subcategorias;
	}

	public Subcategoria addSubcategoria(Subcategoria subcategoria) {
		getSubcategorias().add(subcategoria);
		subcategoria.setCategoria(this);

		return subcategoria;
	}

	public Subcategoria removeSubcategoria(Subcategoria subcategoria) {
		getSubcategorias().remove(subcategoria);
		subcategoria.setCategoria(null);

		return subcategoria;
	}

}
package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the empregado database table.
 * 
 */
@Entity
@NamedQuery(name="Empregado.findAll", query="SELECT e FROM Empregado e")
public class Empregado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="nome")
	private String nome;

	@Column(name="tipo")
	private String tipo;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="empregado")
	@JoinColumn(name="numero")
	private List<Factura> facturas;

	public Empregado() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setEmpregado(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setEmpregado(null);

		return factura;
	}

}
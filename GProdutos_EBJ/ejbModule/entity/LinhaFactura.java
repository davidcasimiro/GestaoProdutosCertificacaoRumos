package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the LINHAFACTURA database table.
 * 
 */
@Entity
@NamedQuery(name="LinhaFactura.findAll", query="SELECT l FROM LinhaFactura l")
public class LinhaFactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LinhaFacturaPK id;

	@Column(name="PRECO_CALCULADO")
	private BigDecimal precoCalculado;

	private BigDecimal quantidade;

	private BigDecimal subtotal;

	//bi-directional many-to-one association to Factura
	@ManyToOne
	@JoinColumn(name="FACTURA_ID")
	private Factura factura;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name="PRODUTO_ID")
	private Produto produto;

	public LinhaFactura() {
	}

	public LinhaFacturaPK getId() {
		return this.id;
	}

	public void setId(LinhaFacturaPK id) {
		this.id = id;
	}

	public BigDecimal getPrecoCalculado() {
		return this.precoCalculado;
	}

	public void setPrecoCalculado(BigDecimal precoCalculado) {
		this.precoCalculado = precoCalculado;
	}

	public BigDecimal getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
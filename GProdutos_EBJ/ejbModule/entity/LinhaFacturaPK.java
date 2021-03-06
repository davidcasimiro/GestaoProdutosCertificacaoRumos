package entity;


import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LINHAFACTURA database table.
 * 
 */
@Embeddable
public class LinhaFacturaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="factura_id", insertable=false, updatable=false)
	private long facturaId;

	@Column(name="produto_id", insertable=false, updatable=false)
	private long produtoId;

	public LinhaFacturaPK() {
	}
	public long getFacturaId() {
		return this.facturaId;
	}
	public void setFacturaId(long facturaId) {
		this.facturaId = facturaId;
	}
	public long getProdutoId() {
		return this.produtoId;
	}
	public void setProdutoId(long produtoId) {
		this.produtoId = produtoId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LinhaFacturaPK)) {
			return false;
		}
		LinhaFacturaPK castOther = (LinhaFacturaPK)other;
		return 
			(this.facturaId == castOther.facturaId)
			&& (this.produtoId == castOther.produtoId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.facturaId ^ (this.facturaId >>> 32)));
		hash = hash * prime + ((int) (this.produtoId ^ (this.produtoId >>> 32)));
		
		return hash;
	}
}

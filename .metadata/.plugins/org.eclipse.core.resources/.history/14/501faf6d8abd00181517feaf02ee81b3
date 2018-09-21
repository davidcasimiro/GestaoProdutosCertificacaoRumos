package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the factura database table.
 * 
 */
@Embeddable
public class FacturaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int numero;

	@Column(name="empregado_id", insertable=false, updatable=false)
	private int empregadoId;

	public FacturaPK() {
	}
	public int getNumero() {
		return this.numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getEmpregadoId() {
		return this.empregadoId;
	}
	public void setEmpregadoId(int empregadoId) {
		this.empregadoId = empregadoId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FacturaPK)) {
			return false;
		}
		FacturaPK castOther = (FacturaPK)other;
		return 
			(this.numero == castOther.numero)
			&& (this.empregadoId == castOther.empregadoId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numero;
		hash = hash * prime + this.empregadoId;
		
		return hash;
	}
}
package br.com.qintess.projetoEventos.model;

import java.io.Serializable;
import java.util.Objects;

public class ItemVendaId implements Serializable{
	
	private long vendaId;
	
	private long ingressoId;

	public ItemVendaId() {
	}

	public ItemVendaId(long vendaId, long ingressoId) {
		this.vendaId = vendaId;
		this.ingressoId = ingressoId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(vendaId, ingressoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemVendaId other = (ItemVendaId) obj;
		return Objects.equals(vendaId, other.vendaId) &&
				Objects.equals(ingressoId, other.ingressoId);
	}

	public long getVendaId() {
		return vendaId;
	}

	public void setVendaId(long vendaId) {
		this.vendaId = vendaId;
	}

	public long getIngressoId() {
		return ingressoId;
	}

	public void setIngressoId(long ingressoId) {
		this.ingressoId = ingressoId;
	}
}

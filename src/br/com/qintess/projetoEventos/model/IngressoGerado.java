package br.com.qintess.projetoEventos.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ingresso_gerado")
public class IngressoGerado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private ItemVenda vendaItem;

	public IngressoGerado() {
	}

	@Override
	public String toString() {
		return "IngressoGerado [id=" + id + ", vendaItem=" + vendaItem + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ItemVenda getVendaItem() {
		return vendaItem;
	}

	public void setVendaItem(ItemVenda vendaItem) {
		this.vendaItem = vendaItem;
	}
}

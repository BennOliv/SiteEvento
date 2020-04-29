package br.com.qintess.projetoEventos.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="item_venda")
public class ItemVenda{

	@EmbeddedId
	private ItemVendaId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("vendaId")
	private Venda venda;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("ingressoId")
	private Ingresso ingresso;
	
	@Column(name="quantidade", nullable = false)
	private int quantidade;
	
	@Column(name="valor", nullable = false)
	private double valor;
	
	@OneToMany(mappedBy = "vendaItem",fetch = FetchType.EAGER)
	private List<IngressoGerado> ingressosGerados;

	public ItemVenda() {
	}

	@Override
	public String toString() {
		return "ItemVenda [id=" + id + ", quantidade=" + quantidade + ", valor=" + valor + "]";
	}

	public ItemVendaId getId() {
		return id;
	}

	public void setId(ItemVendaId id) {
		this.id = id;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Ingresso getIngresso() {
		return ingresso;
	}

	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<IngressoGerado> getIngressosGerados() {
		return ingressosGerados;
	}

	public void setIngressosGerados(List<IngressoGerado> ingressosGerados) {
		this.ingressosGerados = ingressosGerados;
	}
	
	public void addIngressoGerado(IngressoGerado ingressoGerado) {
		if(ingressosGerados == null) {
			ingressosGerados = new ArrayList<>();
		}
		ingressosGerados.add(ingressoGerado);
		ingressoGerado.setVendaItem(this);
	}
}

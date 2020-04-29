package br.com.qintess.projetoEventos.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ingresso")
public class Ingresso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="id_evento",nullable = false)
	private Evento evento;
	
	@Column(name = "tipo", length = 20, nullable = false)
	private String tipo;
	
	@Column(name="preco", scale = 2, nullable = false)
	private double preco;
	
	@Column(name="quantidade_disponivel", nullable = false)
	private int quantidadeDisponivel;

	@OneToMany(mappedBy = "ingresso",fetch = FetchType.LAZY)
	private List<ItemVenda> vendas;
	
	public Ingresso() {
	}

	@Override
	public String toString() {
		return "Ingresso [id=" + id + ", evento=" + evento + ", tipo=" + tipo + ", preco=" + preco
				+ ", quantidadeDisponivel=" + quantidadeDisponivel + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}

	public void setQuantidadeDisponivel(int quantidadeDisponivel) {
		this.quantidadeDisponivel = quantidadeDisponivel;
	}

	public List<ItemVenda> getVendas() {
		return vendas;
	}

	public void setVendas(List<ItemVenda> vendas) {
		this.vendas = vendas;
	}

	public void addItemVenda(ItemVenda itemVenda) {
		if(vendas == null) {
			vendas = new ArrayList<>();
		}
		vendas.add(itemVenda);
		itemVenda.setIngresso(this);
	}
}

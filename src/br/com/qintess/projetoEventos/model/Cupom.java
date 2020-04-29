package br.com.qintess.projetoEventos.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cupom")
public class Cupom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="percentual", nullable = true)
	private int percentual;
	
	@Column(name="desconto", nullable = true)
	private double desconto;
	
	@OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
				mappedBy = "cupom")
	private List<Venda> vendas;
	
	public Cupom() {
	}

	@Override
	public String toString() {
		return "Cupom [id=" + id + ( percentual == 0 ? (", desconto="+ desconto) : (", percentual=" + percentual)) + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPercentual() {
		return percentual;
	}

	public void setPercentual(int percentual) {
		this.percentual = percentual;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public void addVenda(Venda venda) {
		if(vendas == null){
			vendas = new ArrayList<>();
		}
		vendas.add(venda);
		venda.setCupom(this);
	}
}

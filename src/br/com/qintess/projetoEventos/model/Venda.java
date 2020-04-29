package br.com.qintess.projetoEventos.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="venda")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="id_usuario", nullable = false)
	private Usuario usuario;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="id_cupom", nullable = false)
	private Cupom cupom;
	
	@Column(name="data_hora_venda", nullable = false)
	private LocalDateTime dataHoraVenda;
	
	@Column(name="valor_subtotal", scale = 2, nullable = false)
	private double valorSubTotal;
	
	@Column(name="valor_desconto", scale = 2)
	private double valorDesconto;
	
	@Column(name="valor_total", scale = 2, nullable = false)
	private double valorTotal;
	
	@OneToMany(mappedBy = "venda",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<ItemVenda> itens;

	public Venda() {
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", usuario=" + usuario + ", cupom=" + cupom + ", dataHoraVenda=" + dataHoraVenda
				+ ", valorSubTotal=" + valorSubTotal + ", valorDesconto=" + valorDesconto + ", valorTotal=" + valorTotal
				+ "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cupom getCupom() {
		return cupom;
	}

	public void setCupom(Cupom cupom) {
		this.cupom = cupom;
	}

	public LocalDateTime getDataHoraVenda() {
		return dataHoraVenda;
	}

	public void setDataHoraVenda(LocalDateTime dataHoraVenda) {
		this.dataHoraVenda = dataHoraVenda;
	}

	public double getValorSubTotal() {
		return valorSubTotal;
	}

	public void setValorSubTotal(double valorSubTotal) {
		this.valorSubTotal = valorSubTotal;
	}

	public double getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}
	
	public void addItemVenda(ItemVenda item) {
		if(itens == null) {
			itens = new ArrayList<>();
		}
		itens.add(item);
		item.setVenda(this);
	}
	
}

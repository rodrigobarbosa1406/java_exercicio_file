package model.entities;

public class Pedido {
	private String nome;
	private Double valorUnitario;
	private Integer quantidade;
	
	public Pedido() {
	}
	
	public Pedido(String nome, Double valorUnitario, Integer quantidade) {
		this.nome = nome;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public Double valorTotal() {
		return valorUnitario * quantidade;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(nome);
		sb.append(",");
		sb.append(String.format("%.2f", valorTotal()));
		
		return sb.toString();
	}
}

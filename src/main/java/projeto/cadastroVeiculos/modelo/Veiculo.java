package projeto.cadastroVeiculos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

import projeto.cadastroVeiculos.modelo.Fabricante;
import projeto.cadastroVeiculos.modelo.Combustivel;

@Entity
@Table(name = "tb_veiculos")
public class Veiculo {
	
	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public int getAnoFabricacao() {
		return anoFabricacao;
	}


	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public String getChassi() {
		return chassi;
	}


	public Fabricante getFabricante() {
		return fabricante;
	}


	public void setChassi(String chassi) {
		this.chassi = chassi;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	protected Veiculo() {
		
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	



	@Id
	@NotEmpty
	private String placa;
	
	@ManyToOne
	private Fabricante fabricante; 
	
	private String modelo; 
	
	private int anoFabricacao;
	
	private double valor; 
	
	private String chassi; 

	private String status;
	
	@ManyToOne
	private Combustivel tipoCombustivel;
	
	private String descricao;

	public Combustivel getTipoCombustivel() {
		return tipoCombustivel;
	}


	public void setTipoCombustivel(Combustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}
	

	
}

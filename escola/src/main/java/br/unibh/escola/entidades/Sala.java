package br.unibh.escola.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "codigo"), name = "TB_SALA")
@NamedQueries({
@NamedQuery(name="Sala.findByCod", query = "select a from Sala a where a.codigo like :codigo")
})
public class Sala {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@NotNull
	@Column(nullable = false, columnDefinition = "CHAR(5)")
	@Pattern(regexp = "[A-Z]{2}\\d{3}", message = "Deve conter apenas letras Maiúsculas e números!")
	@Size(min = 5, max = 5)
	private String codigo;
	
	@NotNull
	@Min(5)
	@Max(100)
	private int capacidade;
	
	@NotNull
	@Column(nullable = false, name ="possui_quadro_branco")
	private boolean possuiQuadroBranco;
	
	@NotNull
	@Column(nullable = false, name = "possui_data_show")
	private boolean possuiDataShow;
	
	@NotNull
	@Column(nullable = false, name = "possui_computador")
	private boolean possuiComputador;
	
	@Size(max = 255)
	@Column(columnDefinition = "VARCHAR(255)")
	private String observacao;
	
	@NotNull	
	private int status;
	
	@Column(name = "data_termino_manutencao")
	@Temporal(TemporalType.DATE)
	private Date dataTerminoManutencao;
	
	@Transient
	private String possui;
	@Transient
	private int dia;
	@Transient
	private int mes;
	@Transient
	private int ano;
	
	// GETTERS E SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public boolean isPossuiQuadroBranco() {
		return possuiQuadroBranco;
	}

	public void setPossuiQuadroBranco(boolean possuiQuadroBranco) {
		this.possuiQuadroBranco = possuiQuadroBranco;
	}

	public boolean isPossuiDataShow() {
		return possuiDataShow;
	}

	public void setPossuiDataShow(boolean possuiDataShow) {
		this.possuiDataShow = possuiDataShow;
	}

	public boolean isPossuiComputador() {
		return possuiComputador;
	}

	public void setPossuiComputador(boolean possuiComputador) {
		this.possuiComputador = possuiComputador;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDataTerminoManutencao() {
		return dataTerminoManutencao;
	}

	public void setDataTerminoManutencao(Date dataTerminoManutencao) {
		this.dataTerminoManutencao = dataTerminoManutencao;
	}
	
	public String quadroToString(boolean possuiQuadroBranco) {
		if (isPossuiQuadroBranco()){
			possui = "sim";
		} else {
			possui = "nao";
		}
		return possui;
	}
	
	public String dataToString(boolean possuiDataShow) {
		if (isPossuiDataShow()){
			possui = "sim";
		} else {
			possui = "nao";
		}
		return possui;
	}
	
	public String pcToString(boolean possuiComputador) {
		if (isPossuiComputador()){
			possui = "sim";
		} else {
			possui = "nao";
		}
		return possui;
	}
	
	public String statusToString(int status) {
		if (getStatus() == 1){
			possui = "Ativo";
		} else if (getStatus() == 2){
			possui = "Em Manutencao";
		} else {
			possui = "Desativado";
		}
		return possui;
	}
	
	@SuppressWarnings("deprecation")
	public String terminoToString(Date dataTerminoManutencao) {
		if (getDataTerminoManutencao() == null){
			return null;
		}
		dia = getDataTerminoManutencao().getDate();
		mes = getDataTerminoManutencao().getMonth();
		ano = getDataTerminoManutencao().getYear() + 1900;
		return dia + "/" + mes + "/" + ano;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacidade;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((dataTerminoManutencao == null) ? 0 : dataTerminoManutencao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((possui == null) ? 0 : possui.hashCode());
		result = prime * result + (possuiComputador ? 1231 : 1237);
		result = prime * result + (possuiDataShow ? 1231 : 1237);
		result = prime * result + (possuiQuadroBranco ? 1231 : 1237);
		result = prime * result + status;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		if (capacidade != other.capacidade)
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dataTerminoManutencao == null) {
			if (other.dataTerminoManutencao != null)
				return false;
		} else if (!dataTerminoManutencao.equals(other.dataTerminoManutencao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (possui == null) {
			if (other.possui != null)
				return false;
		} else if (!possui.equals(other.possui))
			return false;
		if (possuiComputador != other.possuiComputador)
			return false;
		if (possuiDataShow != other.possuiDataShow)
			return false;
		if (possuiQuadroBranco != other.possuiQuadroBranco)
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
	
	
	
	

}

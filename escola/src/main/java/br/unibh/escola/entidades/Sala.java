package br.unibh.escola.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "codigo"), name = "TB_SALA")
public class Sala {
	
	@Id @GeneratedValue
	private Long id;
	
	@NotBlank
	@NotNull
	@Column(nullable = false, columnDefinition = "CHAR(5)")
	@Pattern(regexp = "[A-Z]{2}\\d{3}", message = "Deve conter apenas letras Maiúsculas e números!")
	@Size(min = 5, max = 5)
	private String codigo;
	
	@NotNull
	@Size(min = 5, max = 100)
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
	
	

}

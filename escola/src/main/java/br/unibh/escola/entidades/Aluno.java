package br.unibh.escola.entidades;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Classe concreta de Aluno
 * @author Guilherme Canton
 * @veersion 1.0
 */

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "matricula"), name = "TB_ALUNO")
@PrimaryKeyJoinColumn
@NamedQueries({
@NamedQuery(name="Aluno.findByName", query = "select a from Aluno a where a.nome like :nome")
})

public class Aluno extends Pessoa {
	// Variaveis de instancia
	
	@NotBlank
	@Column(unique=true, nullable=false)
	private String matricula;
	
	
	
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date data_aniversario;
	
	// Construtores
	
	/**
	 * Construtor padrao
	 */
	public Aluno(){}
	
	/**
	 * Construtor apenas com os atributos básicos de Aluno
	 * @param matricula
	 * @param dataAniversario
	 */
	public Aluno(String matricula, Date data_aniversario) {
		super();
		this.matricula = matricula;
		this.data_aniversario = data_aniversario;
	}

	public Aluno(Long id, String nome, String cpf, String matricula, Date data_aniversario) {
		super(id, nome, cpf);
		this.matricula = matricula;
		this.data_aniversario= data_aniversario;
	}
	
	// Getters and Setters
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", data_aniversario=" + data_aniversario + ", toString()="
				+ super.toString() + "]";
	}

	public Date getData_aniversario() {
		return data_aniversario;
	}

	public void setData_aniversario(Date data_aniversario) {
		this.data_aniversario = data_aniversario;
	}
		
}

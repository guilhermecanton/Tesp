package br.unibh.entidades;
import java.util.Date;

/**
 * Classe concreta de Aluno
 * @author Guilherme Canton
 * @veersion 1.0
 */
public class Aluno extends Pessoa {
	// Variaveis de instancia
	private String matricula;
	private Date data_aniversario;
	
	// Construtores
	
	/**
	 * Construtor padrão
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

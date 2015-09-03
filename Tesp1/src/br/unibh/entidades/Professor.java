package br.unibh.entidades;
import java.math.BigDecimal;

public class Professor extends Pessoa {
	// Variaveis de instância
	private BigDecimal salario;
	public static Double BONUS = 0.1D;
	
	// Getters and Setters 

	public BigDecimal getSalario() {
		return salario;
	}
	
	public static Double getBONUS() {
		return BONUS;
	}

	public static void setBONUS(Double bONUS) {
		BONUS = bONUS;
	}



	// Construtores
	/**
	 * Construtor
	 */
	public Professor(){}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Professor(BigDecimal salario) {
		super();
		this.salario = salario;
	}

	public Professor(Long id, String nome, String cpf, BigDecimal salario) {
		super(id, nome, cpf);
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Professor [salario=" + salario + ", getId()=" + getId() + ", getNome()=" + getNome() + ", getCpf()="
				+ getCpf() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}
	
	
		
}
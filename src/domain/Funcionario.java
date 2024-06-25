package domain;

import java.math.BigDecimal;

public class Funcionario extends Pessoa {

	private BigDecimal salario;
	private String funcao;

	public Funcionario() {

	}

	public Funcionario(String nome, String dataNascimento, BigDecimal salario, String funcao) {
		super(nome, dataNascimento);
		this.salario = salario;
		this.funcao = funcao;
	}

	@Override
	public String toString() {
		return super.toString() + ", salario = " + salario + ", funcao = " + funcao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

}
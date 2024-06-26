package domain;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

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
		
	    
		return super.toString() + ", salario = R$ " + formatarSalario(salario) + ", funcao = " + funcao;
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
	
	private String formatarSalario(BigDecimal salario) {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
	    symbols.setDecimalSeparator(','); //  ponto decimal
	    symbols.setGroupingSeparator('.'); // separador de milhar
	    DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);
	    return decimalFormat.format(salario);
	}

}

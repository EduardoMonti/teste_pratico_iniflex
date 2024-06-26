package main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import domain.Funcionario;
import util.Util;

public class Main {

	public static void main(String[] args) {

		
		List<Funcionario> funcionarios = new ArrayList<>();

		// 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela
		// acima.
		funcionarios.add(new Funcionario("Maria", "18/10/2000", new BigDecimal("2009.44"), "Operador"));
		funcionarios.add(new Funcionario("João", "12/05/1990", new BigDecimal("2284.38"), "Operador"));
		funcionarios.add(new Funcionario("Caio", "02/05/1961", new BigDecimal("9836.14"), "Coordenador"));
		funcionarios.add(new Funcionario("Miguel", "14/10/1988", new BigDecimal("19119.88"), "Diretor"));
		funcionarios.add(new Funcionario("Alice", "05/01/1995", new BigDecimal("2234.68"), "Recepcionista"));
		funcionarios.add(new Funcionario("Heitor", "19/11/1999", new BigDecimal("1582.72"), "Operador"));
		funcionarios.add(new Funcionario("Arthur", "31/03/1993", new BigDecimal("4071.84"), "Contador"));
		funcionarios.add(new Funcionario("Laura", "08/07/1994", new BigDecimal("3017.45"), "Gerente"));
		funcionarios.add(new Funcionario("Heloísa", "24/05/2003", new BigDecimal("1606.85"), "Eletricista"));
		funcionarios.add(new Funcionario("Helena", "02/09/1996", new BigDecimal("2799.93"), "Gerente"));

		// 3.2 – Remover o funcionário “João” da lista.
		String funcionarioARemover = "João";
		Util.removerFuncionario(funcionarios, funcionarioARemover);

		// 3.3 – Imprimir todos os funcionários com todas suas informações
		Util.imprimeFuncionario(funcionarios);

		// 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista
		// de funcionários com novo valor.
		Util.calcularAumentoDeSalario(funcionarios);

		// 3.5 – Agrupar os funcionários por função em um MAP / 3.6 – Imprimir os
		// funcionários, agrupados por função.
		Util.agruparFuncionario(funcionarios);
		
		//3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
			Util.funcionarioOutubroDezembro(funcionarios);
			
		// 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e
		// idade.
		Util.funcionarioMaisVelho(funcionarios);

		// 3.10 – Imprimir a lista de funcionários por ordem alfabética.
		Util.ordenaLista(funcionarios);

		// 3.11 – Imprimir o total dos salários dos funcionários.
		Util.somaSalarios(funcionarios);

		/*
		 * 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando
		 * que o salário mínimo é R$1212.00.
		 */
		Util.imprimeSalarioCadaFuncionario(funcionarios);

	}

}

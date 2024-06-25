package main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import domain.Funcionario;
import domain.Pessoa;

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
		Iterator<Funcionario> iterator = funcionarios.iterator();
		while (iterator.hasNext()) {
			Funcionario funcionario = iterator.next();
			if (funcionario.getNome().equals("João")) {
				iterator.remove();
			}
		}

		// 3.3 – Imprimir todos os funcionários com todas suas informações
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);
		}

		System.out.println("--------------------------");

		// 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista
		// de funcionários com novo valor.

		for (Funcionario funcionario : funcionarios) {
			BigDecimal salarioAtual = funcionario.getSalario();
			BigDecimal aumentoSalario = salarioAtual.multiply(new BigDecimal("0.10"));
			BigDecimal novoSalario = salarioAtual.add(aumentoSalario);
			funcionario.setSalario(novoSalario);
		}

		for (Funcionario funcionario : funcionarios) {
			System.out.println("Funcionarios com o salário atualizado: " + funcionario);
		}
		
		System.out.println("--------------------------");

		// 3.5 – Agrupar os funcionários por função em um MAP.
		Map<String, List<Funcionario>> funcionariosAgrupadosPorFuncao = new HashMap<>();

		for (Funcionario funcionario : funcionarios) {
			String funcao = funcionario.getFuncao();
			List<Funcionario> listaPorFuncao = funcionariosAgrupadosPorFuncao.getOrDefault(funcao, new ArrayList<>());
			listaPorFuncao.add(funcionario);
			funcionariosAgrupadosPorFuncao.put(funcao, listaPorFuncao);
		}

		// 3.6 – Imprimir os funcionários, agrupados por função.
		System.out.println("Funcionários, agrupados por função:");
		for (Map.Entry<String, List<Funcionario>> entry : funcionariosAgrupadosPorFuncao.entrySet()) {
			System.out.println("Função: " + entry.getKey());
			for (Funcionario funcionario : entry.getValue()) {
				System.out.println("- " + funcionario.getNome());
			}

		}
		System.out.println("--------------------------");

		// 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e
		// idade.
		Funcionario funcionarioMaisVelho = null;
		LocalDate dataAtual = LocalDate.now();
		int idadeFuncionarioMaisVelho = Integer.MIN_VALUE;

		for (Funcionario funcionario : funcionarios) {
			LocalDate dataNascimentoFuncionario = funcionario.getDataNascimento();
			int idadeFuncionario = Period.between(dataNascimentoFuncionario, dataAtual).getYears();

			if (idadeFuncionario > idadeFuncionarioMaisVelho) {
				idadeFuncionarioMaisVelho = idadeFuncionario;
				funcionarioMaisVelho = funcionario;
			}
		}

		if (funcionarioMaisVelho != null) {
			System.out.println("O funcionário mais velho é " + funcionarioMaisVelho.getNome() + " com "
					+ idadeFuncionarioMaisVelho + " anos de idade.");
		} else {
			System.out.println("Não há funcionários na lista.");
		}

		System.out.println("--------------------------");

		// 3.10 – Imprimir a lista de funcionários por ordem alfabética.
		funcionarios.sort(Comparator.comparing(Funcionario::getNome));

		System.out.println("Lista ordenada por ordem alfabética:");
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);
		}

		System.out.println("--------------------------");

		// 3.11 – Imprimir o total dos salários dos funcionários.
		BigDecimal totalSalario = BigDecimal.ZERO;

		for (Funcionario funcionario : funcionarios) {
			totalSalario = totalSalario.add(funcionario.getSalario());
		}

		System.out.println("Soma salário funcionários: " + totalSalario);

		System.out.println("--------------------------");

		/*
		 * 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando
		 * que o salário mínimo é R$1212.00.
		 */

		BigDecimal salarioMinimoAtual = new BigDecimal("1212.00");
		for (Funcionario funcionario : funcionarios) {
			BigDecimal salarioMinimoFuncionario = funcionario.getSalario().divide(salarioMinimoAtual, 2,
					RoundingMode.HALF_UP);
			System.out.println(funcionario.getNome() + " salários mínimos: " + salarioMinimoFuncionario);
		}

	}

}

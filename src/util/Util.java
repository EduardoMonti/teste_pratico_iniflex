package util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import domain.Funcionario;

public class Util {

	public static void removerFuncionario(List<Funcionario> funcionarios, String nomeFuncionario) {

		Iterator<Funcionario> iterator = funcionarios.iterator();
		while (iterator.hasNext()) {
			Funcionario funcionario = iterator.next();
			if (funcionario.getNome().toUpperCase().equals(nomeFuncionario.toUpperCase())) {
				iterator.remove();
			}
		}

	}

	public static void imprimeFuncionario(List<Funcionario> funcionarios) {
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);
		}

		System.out.println("--------------------------");
	}

	public static void calcularAumentoDeSalario(List<Funcionario> funcionarios) {
		for (Funcionario funcionario : funcionarios) {
			BigDecimal salarioAtual = funcionario.getSalario();
			BigDecimal aumentoSalario = salarioAtual.multiply(new BigDecimal("0.10"));
			BigDecimal novoSalario = salarioAtual.add(aumentoSalario);
			funcionario.setSalario(novoSalario);
		}

		for (Funcionario funcionario : funcionarios) {
			System.out.println("Funcionario com o salário atualizado: " + funcionario);
		}

		System.out.println("--------------------------");

	}

	public static void agruparFuncionario(List<Funcionario> funcionarios) {
		Map<String, List<Funcionario>> funcionariosAgrupadosPorFuncao = new HashMap<>();

		for (Funcionario funcionario : funcionarios) {
			String funcao = funcionario.getFuncao();
			List<Funcionario> listaPorFuncao = funcionariosAgrupadosPorFuncao.getOrDefault(funcao, new ArrayList<>());
			listaPorFuncao.add(funcionario);
			funcionariosAgrupadosPorFuncao.put(funcao, listaPorFuncao);
		}

		System.out.println("Funcionários, agrupados por função:");
		for (Map.Entry<String, List<Funcionario>> entry : funcionariosAgrupadosPorFuncao.entrySet()) {
			System.out.println("Função: " + entry.getKey());
			for (Funcionario funcionario : entry.getValue()) {
				System.out.println("- " + funcionario.getNome());
			}

		}
		System.out.println("--------------------------");
	}

	public static void funcionarioOutubroDezembro(List<Funcionario> funcionarios) {
		System.out.println("Funcionários que fazem aniversário nos meses 10 e 12:");
		for (Funcionario funcionario : funcionarios) {
			Month mes = funcionario.getDataNascimento().getMonth();
			if (mes == Month.OCTOBER || mes == Month.DECEMBER) {
				System.out.println(funcionario.getNome());
			}
		}
		System.out.println("--------------------------");
	}

	public static void funcionarioMaisVelho(List<Funcionario> funcionarios) {
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
	}

	public static void ordenaLista(List<Funcionario> funcionarios) {
		funcionarios.sort(Comparator.comparing(Funcionario::getNome));

		System.out.println("Lista ordenada por ordem alfabética:");
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);
		}

		System.out.println("--------------------------");
	}

	public static void somaSalarios(List<Funcionario> funcionarios) {
		BigDecimal totalSalario = BigDecimal.ZERO;

		for (Funcionario funcionario : funcionarios) {
			totalSalario = totalSalario.add(funcionario.getSalario());
		}

		System.out.println("Soma salário funcionários: " + totalSalario);

		System.out.println("--------------------------");
	}

	public static void imprimeSalarioCadaFuncionario(List<Funcionario> funcionarios) {
		BigDecimal salarioMinimoAtual = new BigDecimal("1212.00");
		for (Funcionario funcionario : funcionarios) {
			BigDecimal salarioMinimoFuncionario = funcionario.getSalario().divide(salarioMinimoAtual, 2,
					RoundingMode.HALF_UP);
			System.out.println(funcionario.getNome() + " salários mínimos: " + salarioMinimoFuncionario);
		}
	}

}

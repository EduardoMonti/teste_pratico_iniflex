package domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {

	private String nome;
	private LocalDate dataNascimento;
	private static final DateTimeFormatter DATA_FORMATADA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Pessoa() {

	}

	public Pessoa(String nome, String dataNascimento) {
		this.nome = nome;
		this.dataNascimento = LocalDate.parse(dataNascimento, DATA_FORMATADA);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "nome= " + nome + ", dataNascimento= " + dataNascimento.format(DATA_FORMATADA);
	}

}

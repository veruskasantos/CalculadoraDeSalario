package calculadora.model;

import java.io.IOException;

public class Funcionario {

	private String nome;
	private String email;
	private Double salarioBase;
	private Double salarioLiquido;
	private String cargo;
	
	public Funcionario(String nome, String email, Double salarioBase, String cargo) throws IOException {
		if(nome == null || email == null || salarioBase == null || cargo == null){
			throw new IOException("Existe pelo menos um valor de entrada nulo.");
		}
		
		if(nome.trim().isEmpty() || email.trim().isEmpty() || cargo.trim().isEmpty()){
			throw new IOException("Existe pelo menos um valor de entrada vazio.");
		}
		
		this.nome = nome;
		this.email = email;
		this.salarioBase = salarioBase;
		this.cargo = cargo;
		this.salarioLiquido = salarioBase;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salario) {
		this.salarioBase = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalarioLiquido() {
		return salarioLiquido;
	}
	
	@Override
	public String toString(){
		return "Funcionário: " + getNome() + ", Email: " + getEmail() + ", Salário: " + getSalarioBase()
				+ ", Cargo: " + getCargo();
	}

}

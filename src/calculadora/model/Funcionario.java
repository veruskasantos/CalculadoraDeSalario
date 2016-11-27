package calculadora.model;

import java.io.IOException;

public class Funcionario {

	public static final Double DESCONTO_20 = 0.2;
	public static final Double DESCONTO_10 = 0.1;
	public static final Double DESCONTO_25 = 0.25;
	public static final Double DESCONTO_15 = 0.15;
	
	private String nome;
	private String email;
	private Double salarioBase;
	private String cargo;
	
	public Funcionario(String nome, String email, Double salarioBase, String cargo) throws IOException {
		if(nome == null || email == null || salarioBase == null || cargo == null){
			throw new IOException("Existe pelo menos um valor de entrada nulo.");
		}
		
		if(nome.trim().isEmpty() || email.trim().isEmpty() || cargo.trim().isEmpty()){
			throw new IOException("Existe pelo menos um valor de entrada vazio.");
		}
		
		if(salarioBase < 0.0){
			throw new IOException("O sal�rio n�o pode ser negativo.");
		}
		
		this.nome = nome;
		this.email = email;
		this.salarioBase = salarioBase;
		this.cargo = cargo;
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

	public Double calculaSalarioLiquido(Double salarioBase){
		return salarioBase;
	}
	
	@Override
	public String toString(){
		return "Funcion�rio: " + getNome() + ", Email: " + getEmail() + ", Sal�rio: " + getSalarioBase()
				+ ", Cargo: " + getCargo();
	}

}

package calculadora.model;

import java.io.IOException;

public class Gerente extends Funcionario {

	public static final Double LIMIAR_SALARIO = 5.000;
	
	public Gerente(String nome, String email, Double salarioBase, String cargo) throws IOException {
		super(nome, email, salarioBase, cargo);
	}

	@Override
	public Double calculaSalarioLiquido(Double salarioBase){
		if(salarioBase >= LIMIAR_SALARIO){
			return salarioBase - DESCONTO_30*salarioBase;
		}
		return salarioBase - DESCONTO_20*salarioBase;
	}
	
}

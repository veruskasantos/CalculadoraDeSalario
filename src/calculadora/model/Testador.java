package calculadora.model;

import java.io.IOException;

public class Testador extends Funcionario {

	public static final Double LIMIAR_SALARIO = 2.000;
	
	public Testador(String nome, String email, Double salarioBase, String cargo)
			throws IOException {
		super(nome, email, salarioBase, cargo);
	}
	
	@Override
	public Double calculaSalarioLiquido(Double salarioBase){
		if(salarioBase >= LIMIAR_SALARIO){
			return salarioBase - DESCONTO_25*salarioBase;
		}
		return salarioBase - DESCONTO_15*salarioBase;
	}

}

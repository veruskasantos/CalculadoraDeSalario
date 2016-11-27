package calculadora.model;

import java.io.IOException;

public class Desenvolvedor extends Funcionario {

	public static final Double LIMIAR_SALARIO = 3.000;
	public static final Double DESCONTO_20 = 0.2;
	public static final Double DESCONTO_10 = 0.1;
	
	public Desenvolvedor(String nome, String email, Double salarioBase, String cargo) throws IOException {
		super(nome, email, salarioBase, cargo);
		calculaSalarioLiquido(salarioBase);
	}

	@Override
	public Double calculaSalarioLiquido(Double salarioBase){
		if(salarioBase >= LIMIAR_SALARIO){
			return salarioBase - DESCONTO_20*salarioBase;
		}
		return salarioBase - DESCONTO_10*salarioBase;
	}
	
}

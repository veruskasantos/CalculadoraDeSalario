package calculadora.test;

import java.io.IOException;

import org.junit.*;

import calculadora.model.Desenvolvedor;
import calculadora.model.Funcionario;

public class FuncionarioTest {

	private Funcionario funcionario;
	private String nome;
	private String email;
	private Double salarioBase;
	private String cargo;
	
	@Before
	public void inicializaConstrutor() {
		this.nome = "Teste";
		this.email = "teste@empresa.com";
		this.salarioBase = 0.0;
		this.cargo = "teste";
		
		try {
			this.funcionario = new Funcionario(nome, email, salarioBase, cargo);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void testaConstrutor() {
		Assert.assertEquals("Teste", funcionario.getNome());
		Assert.assertEquals("teste@empresa.com", funcionario.getEmail());
		Assert.assertEquals(0.0, funcionario.getSalarioBase(), 0.0);
		Assert.assertEquals("teste", funcionario.getCargo());
		Assert.assertEquals("Funcionário: Teste, Email: teste@empresa.com, Salário: 0.0, Cargo: teste", funcionario.toString());
	}
	
	@Test
	public void testaExcecoesConstrutor(){
		try{
			this.funcionario = new Funcionario(" ", " ", 0.0, " ");
			Assert.fail("Deveria haver falha de valor vazio");
		}catch(Exception e){
			Assert.assertEquals("Existe pelo menos um valor de entrada vazio.", e.getMessage());
		}
		
		try{
			this.funcionario = new Funcionario("Teste", "teste@empresa.com", 0.0, " ");
			Assert.fail("Deveria haver falha de valor vazio");
		}catch(Exception e){
			Assert.assertEquals("Existe pelo menos um valor de entrada vazio.", e.getMessage());
		}
		
		try{
			this.funcionario = new Funcionario(null, null, null, null);
			Assert.fail("Deveria haver falha de valor nulo");
		}catch(Exception e){
			Assert.assertEquals("Existe pelo menos um valor de entrada nulo.", e.getMessage());
		}
		
		try{
			this.funcionario = new Funcionario("Teste", "teste@empresa.com", null, "teste");
			Assert.fail("Deveria haver falha de valor nulo");
		}catch(Exception e){
			Assert.assertEquals("Existe pelo menos um valor de entrada nulo.", e.getMessage());
		}
		
		try{
			this.funcionario = new Funcionario(null, " ", 0.0, " ");
			Assert.fail("Deveria haver falha de valor nulo");
		}catch(Exception e){
			Assert.assertEquals("Existe pelo menos um valor de entrada nulo.", e.getMessage());
		}
		
		try{
			this.funcionario = new Funcionario(" ", null, null, null);
			Assert.fail("Deveria haver falha de valor nulo");
		}catch(Exception e){
			Assert.assertEquals("Existe pelo menos um valor de entrada nulo.", e.getMessage());
		}
		
		try{
			this.funcionario = new Funcionario("Teste", "teste@empresa.com", -1.0, "teste");
			Assert.fail("Deveria haver falha de salário negativo");
		}catch(Exception e){
			Assert.assertEquals("O salário não pode ser negativo.", e.getMessage());
		}
	}
	
	@Test
	public void testaSalarioLiquido(){
		Assert.assertEquals(0.0, funcionario.calculaSalarioLiquido(salarioBase), 0.0);
		
		try{
			salarioBase = 10.000;
			this.funcionario = new Funcionario("Teste", "teste@empresa.com", salarioBase, "teste");
			Assert.assertEquals(10.000, funcionario.calculaSalarioLiquido(salarioBase), 00.000);
		}catch(Exception e){
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void testaSalarioLiquidoDesenvolvedor(){
		
		//o funcionário terá desconto de 20% caso o salário seja maior ou igual que 3.000,00
		salarioBase = 3.000;
		try {
			funcionario = new Desenvolvedor(nome, email, salarioBase, cargo);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
		
		Assert.assertEquals(2.400, funcionario.calculaSalarioLiquido(salarioBase), 0.000);
		
		salarioBase = 3.001;
		try {
			funcionario = new Desenvolvedor(nome, email, salarioBase, cargo);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
		
		Assert.assertEquals(2.4008, funcionario.calculaSalarioLiquido(salarioBase), 0.000);
		
		//ou apenas 10% caso o salário seja menor que isso.
		salarioBase = 2.999;
		try {
			funcionario = new Desenvolvedor(nome, email, salarioBase, cargo);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
		
		Assert.assertEquals(2.6991, funcionario.calculaSalarioLiquido(salarioBase), 0.000);
		
		salarioBase = 0.0;
		try {
			funcionario = new Desenvolvedor(nome, email, salarioBase, cargo);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
		
		Assert.assertEquals(0.0, funcionario.calculaSalarioLiquido(salarioBase), 0.000);
	}
	
	@Test
	public void testaSalarioLiquidoDBA(){
		
		
	}
	
	@Test
	public void testaSalarioLiquidoTestador(){
		
		
	}
	
	@Test
	public void testaSalarioLiquidoGerente(){
		
		
	}
}

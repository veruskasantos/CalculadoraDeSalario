package calculadora.test;

import java.io.IOException;

import org.junit.*;

import calculadora.model.DBA;
import calculadora.model.Desenvolvedor;
import calculadora.model.Funcionario;
import calculadora.model.Gerente;
import calculadora.model.Testador;

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
		Assert.assertEquals("Funcion�rio: Teste, Email: teste@empresa.com, Sal�rio: 0.0, Cargo: teste", funcionario.toString());
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
			Assert.fail("Deveria haver falha de sal�rio negativo");
		}catch(Exception e){
			Assert.assertEquals("O sal�rio n�o pode ser negativo.", e.getMessage());
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
		
		//o funcion�rio ter� desconto de 20% caso o sal�rio seja maior ou igual que 3.000,00
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
		
		//ou apenas 10% caso o sal�rio seja menor que isso.
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
		//o funcion�rio ter� desconto de 25% caso o sal�rio seja maior ou igual que 2.000,00
		salarioBase = 2.000;
		try {
			funcionario = new DBA(nome, email, salarioBase, cargo);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}

		Assert.assertEquals(1.500, funcionario.calculaSalarioLiquido(salarioBase), 0.000);
		
		salarioBase = 2.001;
		try {
			funcionario = new DBA(nome, email, salarioBase, cargo);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}

		Assert.assertEquals(1.50075, funcionario.calculaSalarioLiquido(salarioBase), 0.000);
		
		//ou apenas 15% caso o sal�rio seja menor que isso.
		salarioBase = 1.999;
		try {
			funcionario = new DBA(nome, email, salarioBase, cargo);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}

		Assert.assertEquals(1.6991500000000002, funcionario.calculaSalarioLiquido(salarioBase), 0.000);

		salarioBase = 0.0;
		try {
			funcionario = new DBA(nome, email, salarioBase, cargo);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}

		Assert.assertEquals(0.0, funcionario.calculaSalarioLiquido(salarioBase), 0.0);

	}
	
	@Test
	public void testaSalarioLiquidoTestador(){
		//o funcion�rio ter� desconto de 25% caso o sal�rio seja maior ou igual que 2.000,00
		salarioBase = 2.000;
		try {
			funcionario = new Testador(nome, email, salarioBase, cargo);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}

		Assert.assertEquals(1.500, funcionario.calculaSalarioLiquido(salarioBase), 0.000);

		salarioBase = 2.001;
		try {
			funcionario = new Testador(nome, email, salarioBase, cargo);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}

		Assert.assertEquals(1.50075, funcionario.calculaSalarioLiquido(salarioBase), 0.000);
		
		//ou apenas 15% caso o sal�rio seja menor que isso.
		salarioBase = 1.999;
		try {
			funcionario = new Testador(nome, email, salarioBase, cargo);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}

		Assert.assertEquals(1.6991500000000002, funcionario.calculaSalarioLiquido(salarioBase), 0.000);

		salarioBase = 0.0;
		try {
			funcionario = new Testador(nome, email, salarioBase, cargo);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}

		Assert.assertEquals(0.0, funcionario.calculaSalarioLiquido(salarioBase), 0.0);
	}
	
	@Test
	public void testaSalarioLiquidoGerente(){
		//o funcion�rio ter� desconto de 30% caso o sal�rio seja maior ou igual que 5.000,00
		salarioBase = 5.000;
		try {
			funcionario = new Gerente(nome, email, salarioBase, cargo);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}

		Assert.assertEquals(3.500, funcionario.calculaSalarioLiquido(salarioBase), 0.000);

		salarioBase = 5.001;
		try {
			funcionario = new Gerente(nome, email, salarioBase, cargo);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}

		Assert.assertEquals(3.5007, funcionario.calculaSalarioLiquido(salarioBase), 0.000);
		
		//ou apenas 20% caso o sal�rio seja menor que isso.
		salarioBase = 4.999;
		try {
			funcionario = new Gerente(nome, email, salarioBase, cargo);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}

		Assert.assertEquals(3.9991999999999996, funcionario.calculaSalarioLiquido(salarioBase), 0.000);

		salarioBase = 0.0;
		try {
			funcionario = new Gerente(nome, email, salarioBase, cargo);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}

		Assert.assertEquals(0.0, funcionario.calculaSalarioLiquido(salarioBase), 0.0);
	}
}

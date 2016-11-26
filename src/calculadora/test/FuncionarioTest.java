package calculadora.test;

import java.io.IOException;
import org.junit.*;
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
	}
	
	@Test
	public void testaSalarioLiquido(){
		Assert.assertEquals(0.0, funcionario.getSalarioLiquido(), 0.0);
		
		try{
			this.funcionario = new Funcionario("Teste", "teste@empresa.com", 10.000, "teste");
			Assert.assertEquals(10.000, funcionario.getSalarioLiquido(), 0.0);
		}catch(Exception e){
			Assert.fail(e.getMessage());
		}
	}
}

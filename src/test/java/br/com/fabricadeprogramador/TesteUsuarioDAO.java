package br.com.fabricadeprogramador;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		//testeCadastrar();
		//testeAlterar();
		//testeExcluir();
		testeSalvar();
	}
	
	public static void testeCadastrar() {
		//criando o usuario
		Usuario usuario = new Usuario();
		usuario.setNome("Jãozão");
		usuario.setLogin("jzao");
		usuario.setSenha("123");
		
		//Cadastrando usuario no banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usuario);
		
		System.out.println("Cadastrado com sucesso!");
	}

	public static void testeAlterar() {
		//criando o usuario
		Usuario usuario = new Usuario();
		usuario.setId(4);
		usuario.setNome("Jãozão Da Silva");
		usuario.setLogin("JoãoZão");
		usuario.setSenha("12345678");
		
		//Cadastrando usuario no banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usuario);
		
		System.out.println("Alterado com sucesso!");
	}
	
	public static void testeExcluir() {
		//criando o usuario
		Usuario usuario = new Usuario();
		usuario.setId(4);
		
		//Excluir usuario no banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usuario);
		
		System.out.println("Excluido com sucesso!");
	}
	
	public static void testeSalvar() {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNome("Maria de Nazaré");
		usuario.setLogin("MariaNa");
		usuario.setSenha("123");
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		usuarioDao.salvar(usuario);
		
		System.out.println("Usuário Salvo");
	}
}

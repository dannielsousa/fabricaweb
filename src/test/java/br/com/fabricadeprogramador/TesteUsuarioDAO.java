package br.com.fabricadeprogramador;

import java.util.List;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		//testeCadastrar();
		//testeAlterar();
		//testeExcluir();
		//testeSalvar();
		//testeBuscarPorId();
		//testeBuscarTodos();
		
		testeAutenticar();
		
	}
	
	private static void testeAutenticar() {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Usuario usu = new Usuario();
		usu.setLogin("jao");
		usu.setSenha("123");
		
		Usuario usuRetorno = usuarioDAO.autenticar(usu);
		
		System.out.println(usuRetorno);
	}

	private static void testeBuscarTodos() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> usuarioList = usuarioDAO.bustarTodos();
		
		for (Usuario u: usuarioList) {
			System.out.println(u);
		}
	}
	
	private static void testeBuscarPorId() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorId(1);
		System.out.println(usuario);
	}

	public static void testeCadastrar() {
		//criando o usuario
		Usuario usuario = new Usuario();
		usuario.setNome("MIMI");
		usuario.setLogin("mi");
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

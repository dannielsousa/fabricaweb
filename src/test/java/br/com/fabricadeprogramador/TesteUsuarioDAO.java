package br.com.fabricadeprogramador;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		
		//criando o usuario
		Usuario usuario = new Usuario();
		usuario.setNome("Jãozão");
		usuario.setLogin("jzao");
		usuario.setSenha("123");
		
		//Cadastrando usuario no banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usuario);
	}

}

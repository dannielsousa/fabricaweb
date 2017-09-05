package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

public class UsuarioDAO {

	private Connection con = ConexaoFactory.getConnection();

	public void cadastrar(Usuario usu) {
		String sql = "insert into usuario (nome, login, senha) values (?, ?, ?)";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			// executando sql no banco
			preparador.execute();
			// fechando o objeto preparador
			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Usuario usu) {

		String sql = "update usuario set nome=?, login=?, senha=? where id=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.setInt(4, usu.getId());
			// executando sql no banco
			preparador.execute();
			// fechando o objeto preparador
			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(Usuario usu) {
		String sql = "delete from usuario where id=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setInt(1, usu.getId());
			// executando sql no banco
			preparador.execute();
			// fechando o objeto preparador
			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void salvar(Usuario usu) {
		if ((usu.getId() != null) && (usu.getId() > 0)) {
			alterar(usu);
		} else {
			cadastrar(usu);
		}
	}

	/**
	 * Busca de um registro no banco de dados pelo número do id do usuário
	 * 
	 * @param id
	 *            - É um inteiro que representa o número do id do usuário a ser
	 *            buscado
	 * @return objeto usuário quando o encontra ou null quando não encontra
	 */
	public Usuario buscarPorId(Integer id) {

		String sql = "Select * from usuario where id=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setInt(1, id);
			ResultSet resultado = preparador.executeQuery();
			// posicionando o cursor do primeiro registro
			if (resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));

				return usuario;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Realiza a busca de varios registros da tabela usuário
	 * 
	 * @return List de objetos dos usuários contendo 0 elementos quando não tiver
	 *         registros ou n elementos quanto encontrar.
	 */
	public List<Usuario> bustarTodos() {

		String sql = "select * from usuario";
		List<Usuario> usuarioList = new ArrayList<Usuario>();

		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));

				usuarioList.add(usuario);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarioList;
	}

	public Usuario autenticar(Usuario usuConsulta) {
		
		String sql = "select * from usuario where login = ? and senha = ?";
		Usuario usuario = new Usuario();
		
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			
			preparador.setString(1, usuConsulta.getLogin());
			preparador.setString(2, usuConsulta.getSenha());
			
			ResultSet resultado  = preparador.executeQuery();
			
			if (resultado.next()) {
				
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setSenha(resultado.getString("senha"));
				usuario.setLogin(resultado.getString("login"));
				
				return usuario;
						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}

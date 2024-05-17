package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDao {
	
	public void cadastra(usuario usuario) {
	
	Connection con = Conexao.obterConexao();
	
	String sql = "INSERT INTO usuario(nome,login,senha) VALUES(?,?,?)";
	
	try {
		PreparedStatement preparador = con.prepareStatement(sql);
		preparador.setString(1,  usuario.getNome());
		preparador.setString(2,  usuario.getLogin());
		preparador.setString(3,  usuario.getSenha());
		
		preparador.execute();
		
		System.out.println("Usuario Cadastrado com Sucesso");
	} catch (SQLException e) {
		e.printStackTrace();
		
	}
	
	
	}
}

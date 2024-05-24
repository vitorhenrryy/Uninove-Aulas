package teste;

import modelo.UsuarioDao;
import modelo.usuario;

public class TesteCadastrausuario {

	public static void main(String[] args) {
		
	usuario usuario = new usuario("Beatriz","Vieira","1453");
	
	UsuarioDao usuarioDao = new UsuarioDao();
	usuarioDao.cadastra(usuario);
	}

}

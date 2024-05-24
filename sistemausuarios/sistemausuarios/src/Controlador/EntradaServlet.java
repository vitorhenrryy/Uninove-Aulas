package Controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.UsuarioDao;
import modelo.usuario;

@WebServlet("/entrada")
public class EntradaServlet  extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("txtnome");
		String login = request.getParameter("txtlogin");
		String senha = request.getParameter("txtsenha");
		
		
		usuario usuario = new usuario(nome,login,senha);
		
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.cadastra(usuario);
		
		response.sendRedirect("http://localhost:8080/sistemausuarios/cadastro.html");
		
	}

}

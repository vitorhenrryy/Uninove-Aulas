package controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlunoServlet
 */
@WebServlet("/AlunoServlet")
public class AlunoServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlunoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub

	String nome = request.getParameter("nome");
	String acao = request.getParameter("acao");
	
	if (acao.equals("inserir")) {
		
		try {
			Class.forName("org.sqlite.JDBC");
			
			String diretorio = System.getProperty("wtp.deploy").toString().split(".metadata")[0];
			String dataBase = diretorio + "\\uninove.db";
			
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + dataBase);

			Statement stm = conn.createStatement();
			// wstm.executeUpdate("DROP TABLE IF EXISTS aluno");
			stm.executeUpdate(
					"CREATE TABLE IF NOT EXISTS 'aluno'('ra' INTEGER, 'nome' TEXT, 'curso' TEXT, 'senha' TEXT, PRIMARY KEY('ra' AUTOINCREMENT))");
			
			String sql = "insert into aluno(nome) values(?)";
			
			PreparedStatement stm2 = conn.prepareStatement(sql);				
			stm2.setString(1, nome);
			stm2.executeUpdate();
			
			conn.close();
			
			response.getWriter().append("Registro salvo com sucesso!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().append("Não foi possível salvar!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().append("Não foi possível salvar!");
			}
		}
	}
}

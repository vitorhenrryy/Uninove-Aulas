package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.AlunoBean;

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
		
		try {
		
			String acao = request.getParameter("acao");
			
			String ra_texto = request.getParameter("ra");
			
			int ra = 0;
			if (!ra_texto.equals("")) {
				ra = Integer.valueOf(ra_texto);
			}
			
			String nome  = request.getParameter("nome");
			String curso = request.getParameter("curso");
			String senha = request.getParameter("senha");
			
			Class.forName("org.sqlite.JDBC");
			String diretorio = System.getProperty("wtp.deploy").toString().split(".metadata")[0];
			String dataBase = diretorio + "\\uninove.db";
			Connection conn = DriverManager.getConnection("jdbc:sqlite:"+dataBase);
			
			response.setCharacterEncoding("UTF8");
			
			if (acao.equals("inserir")){
				String sql = "insert into aluno(nome,curso,senha) values(?,?,?)";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1, nome);
				pstm.setString(2, curso);
				pstm.setString(3, senha);
				if (pstm.executeUpdate()>0) {
					String msg = "Dados inseridos com sucesso!";
					response.getWriter().append(msg);
				}else{
					String msg = "Não foi possível inserir!";
					response.getWriter().append(msg);
				}
			}else if (acao.equals("alterar")){
				String sql = "update aluno set nome=?,curso=?,senha=? where ra=?";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1, nome);
				pstm.setString(2, curso);
				pstm.setString(3, senha);
				pstm.setInt(4, ra);
				if (pstm.executeUpdate()>0) {
					String msg = "Dados alterados com sucesso!";
					response.getWriter().append(msg);
				}else{
					String msg = "Não foi possível alterar!";
					response.getWriter().append(msg);
				}
			}else if (acao.equals("excluir")){
				String sql = "delete from aluno where ra=?";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setInt(1, ra);			
				
				if (pstm.executeUpdate()>0) {
					String msg = "Dados excluídos com sucesso!";
					response.getWriter().append(msg);
				}else{
					String msg = "Não foi possível excluir!";
					response.getWriter().append(msg);
				}
				
			}else if (acao.equals("buscar")) {
				String sql = "select * from aluno";
				PreparedStatement pstm = conn.prepareStatement(sql);
				ResultSet rs = pstm.executeQuery();
				List<AlunoBean> listAluno = new ArrayList<AlunoBean>();
				while(rs.next()) {
					AlunoBean al = new AlunoBean();
					al.setRa(rs.getInt("ra"));
					al.setNome(rs.getString("nome"));
					al.setCurso(rs.getString("curso"));
					listAluno.add(al);
				}
				Gson j = new Gson();
				String strJson = j.toJson(listAluno);				
				response.getWriter().append(strJson);
			}
			
			conn.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
*      response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
// TODO Auto-generated method stub
 
String acao = request.getParameter("acao");
 
try {
Class.forName("org.sqlite.JDBC");

String diretorio = System.getProperty("wtp.deploy").toString().split(".metadata")[0];
String dataBase = diretorio + "\\uninove.db";

Connection conn;

conn = DriverManager.getConnection("jdbc:sqlite:" + dataBase);

Statement stm = conn.createStatement();
// wstm.executeUpdate("DROP TABLE IF EXISTS aluno");
stm.executeUpdate(
"CREATE TABLE IF NOT EXISTS 'aluno'('ra' INTEGER, 'nome' TEXT, 'curso' TEXT, 'senha' TEXT, PRIMARY KEY('ra' AUTOINCREMENT))");

if (acao.equals("buscar")) {

PreparedStatement pstm = conn.prepareStatement("select * from aluno");
ResultSet rs = pstm.executeQuery();
List<AlunoBean> listAluno = new ArrayList<AlunoBean>();
while (rs.next()) {
AlunoBean aluno = new AlunoBean();
aluno.setRa(rs.getInt("ra"));
aluno.setNome(rs.getString("nome"));
aluno.setCurso(rs.getString("curso"));
listAluno.add(aluno);
}
pstm.close();

Gson gson = new Gson();
response.getWriter().append(gson.toJson(listAluno));

}

} catch (ClassNotFoundException | SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

}
 
/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
*      response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
// TODO Auto-generated method stub
doGet(request, response);
}
 
}
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

public static Connection obterConexao() {

Connection con = null;

// jdbc: -> Envia as intruções de conexão para o Banco
// mysql -> Banco de Dados que utilizaremos;
// :// -> Caminho para o banco de dados;
// localhost -> O banco está na MINHA máquina;
// /usuarios -> Base de dados que queremos acessar;
// "root" -> Usuário que estamos utilizando no bd;
// "admin" -> Senha do usuário do root.

try {
con = DriverManager.getConnection("jdbc:mysql://localhost/usuarios","root","admin");
System.out.println("\nConexão com Banco de Dados bem sucedida!!");
}

catch (SQLException e) {
System.err.println("\nERRO ao conectar com Banco de Dados!!");
e.printStackTrace();
}

// Se return != null: permissão para falar com banco de dados concedida!
return con;
}
}
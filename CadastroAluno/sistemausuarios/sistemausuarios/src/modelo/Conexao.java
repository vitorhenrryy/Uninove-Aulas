package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

public static Connection obterConexao() {

Connection con = null;

// jdbc: -> Envia as intru��es de conex�o para o Banco
// mysql -> Banco de Dados que utilizaremos;
// :// -> Caminho para o banco de dados;
// localhost -> O banco est� na MINHA m�quina;
// /usuarios -> Base de dados que queremos acessar;
// "root" -> Usu�rio que estamos utilizando no bd;
// "admin" -> Senha do usu�rio do root.

try {
con = DriverManager.getConnection("jdbc:mysql://localhost/usuarios","root","admin");
System.out.println("\nConex�o com Banco de Dados bem sucedida!!");
}

catch (SQLException e) {
System.err.println("\nERRO ao conectar com Banco de Dados!!");
e.printStackTrace();
}

// Se return != null: permiss�o para falar com banco de dados concedida!
return con;
}
}
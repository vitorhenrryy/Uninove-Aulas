package modelo;

public class usuario {
	
	
	
	public usuario(int codigo, String nome, String login, String senha) {
		this.codigo = codigo;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}


	public usuario() {}
	
	
	public usuario(String nome, String login, String senha) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}
	private int codigo;
	private String nome;
	private String login;
	private String senha;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}

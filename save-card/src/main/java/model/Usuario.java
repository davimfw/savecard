package model;

public class Usuario {
	private int codigo;
	private String username;
    private String email;
	private String senha;
	
	public Usuario() {
		this.codigo = -1;
		this.username = "";
        this.email = "";
		this.senha = "";
	}
	
	public Usuario(int codigo, String username, String email, String senha) {
		this.codigo = codigo;
		this.username = username;
		this.senha = senha;
		this.email = email;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getUsename() {
		return username;
	}

	public void setUsename(String username) {
		this.username = username;
	}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", username=" + username + ", email=" + email + ", senha=" + senha + "]";
	}	
}


package br.com.joelma.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;


@Entity(name = "tbusuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;// compactaçao de dados


	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message= "precisa inserir Nome")
	private String nome;

	@CPF
	private String CPF;

	@Email
	private String email;

	
	@Length(min =8, max = 20,message = "Insira um numero valido")
	private Long telefone;

	@NotEmpty(message= "precisa inserir Login")
	private String login;

	@NotEmpty(message= "precisa inserir Senha")
	private String senha;

	// construtor vazio
	public Usuario() {
		super();

	}

//construtor com todos os parametros
	public Usuario(Long id, String nome, String cPF, String email, Long telefone, String login, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		CPF = cPF;
		this.email = email;
		this.telefone = telefone;
		this.login = login;
		this.senha = senha;
	}

	// getter e setter sem serial e sem id
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
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

	// hashCode and equals do id
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

}

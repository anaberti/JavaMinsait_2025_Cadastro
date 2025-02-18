package br.anaberti.cadastro.model;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_contatos")
public class Contatos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long contact_id;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id", referencedColumnName = "pessoa_id")
	private Pessoas pessoa;		
	
	@Column(nullable = false)//0 Telefone, 1 Celular, 2 Email, 3 Rede Social, 4 Outro
	private Integer contact_type;
	
	@Column
	private String contactNickname;
	
	@Column(nullable = false)
	private String contact;

	public Contatos () {}


	public Contatos(Long contact_id, Pessoas pessoa_id, 
			Integer contact_type, String contactNickname, 
			String contact, Pessoas pessoa) {
		this.contact_id = contact_id;
		this.pessoa = pessoa;
		this.contact_type = contact_type;
		this.contactNickname = contactNickname;
		this.contact = contact;
	}


	public Long getContact_id() {
		return contact_id;
	}


	public void setContact_id(Long contact_id) {
		this.contact_id = contact_id;
	}


	public Pessoas getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoas pessoa) {
		this.pessoa = pessoa;
		
	}

	public Integer getcontact_type() {
		return contact_type;
	}
	
	public void setContact_type(Integer contact_type) {
		this.contact_type = contact_type;
	}

	//O Apelido do contato serve para informar o nome da rede social ou de onde é o telefone ou email, por exemplo "Telefone de casa" ou "Instagram pessoal". 
	public void setContactNickname(String contactNickname) {
		this.contactNickname = contactNickname;
	}
	
	public String getContactNickname() {
		return contactNickname;
	}

	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	@Override
	public String toString() {
		return "Contatos [contact_id: " + contact_id + 
				", pessoa: " + pessoa + 
				contact_type + 	" " + contactNickname + ": " + contact + "]";
	}



}

package br.anaberti.cadastro.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pessoas" )
public class Pessoas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
	private Long pessoa_id;
	
	@Column(nullable = false)
	private String first_name;
	
	@Column
	private String middle_name;
	
	@Column(nullable=false)
	private String last_name;
	
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@Column
	private String pronoum;
	
	@Column
	private String profession;
	
	@Column
	private Date birthdate;
	
	@Column(nullable = false)
	private String address; // preencher com nome do logradouro
	
	@Column(nullable = false)
	private String number; //preencher com número no logradouro
	
	@Column
	private String additional_address_data; //preencher com complementos do endereço
	
	@Column
	private String city; //preencher com a Cidade
	
	@Column
	private String uf; //preencher com a sigla do Estado
	
	@Column
	private String postal_code; //preencher com o CEP
	
	@Column
	private String country; //preencher com o nome do país por extenso
	
	
	public Pessoas() {}
	
	
	public Pessoas(Long pessoa_id, String first_name, String middle_name, String last_name, String cpf, String pronoum,
			String profession, Date birthdate, String address, String number, String additional_address_data,
			String city, String uf, String postal_code, String country) {

		this.pessoa_id = pessoa_id;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.cpf = cpf;
		this.pronoum = pronoum;
		this.profession = profession;
		this.birthdate = birthdate;
		this.address = address;
		this.number = number;
		this.additional_address_data = additional_address_data;
		this.city = city;
		this.uf = uf;
		this.postal_code = postal_code;
		this.country = country;
	}


	public Long getPessoa_id() {
		return pessoa_id;
	}


	public void setPessoa_id(Long pessoa_id) {
		this.pessoa_id = pessoa_id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getMiddle_name() {
		return middle_name;
	}


	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getPronoum() {
		return pronoum;
	}


	public void setPronoum(String pronoum) {
		this.pronoum = pronoum;
	}


	public String getProfession() {
		return profession;
	}


	public void setProfession(String profession) {
		this.profession = profession;
	}


	public Date getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getAdditional_address_data() {
		return additional_address_data;
	}


	public void setAdditional_address_data(String additional_address_data) {
		this.additional_address_data = additional_address_data;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}


	public String getPostal_code() {
		return postal_code;
	}


	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	@Override
	public String toString() {
		return 	"Pessoas [pessoa_id:" + pessoa_id + 
				", Nome: " + first_name + middle_name + last_name + 
				", CPF: " + cpf + 
				", Pronome: " + pronoum + 
				", Profissão: " + profession + 
				", Data de Nascimento: " + birthdate + 
				", Endereço: " + address + ", número: " + number +
				", complemento: " + additional_address_data + 
				", Cidade: " + city + 
				", UF: " + uf + 
				", CEP: " + postal_code + 
				", País: " + country + "]";
	}

	
}
package br.anaberti.cadastro.dto;

public class ContatoDTO {
	private Long pessoa_id;
	private String first_name;
	private String middle_name;
	private String last_name;
	private String address;
	private String number;
	private String additional_address_data;
	private String city;
	private String uf;
	private String postal_code;
	
	public ContatoDTO(Long pessoa_id, String first_name, String middle_name, String last_name, String address, String number,
			String additional_address_data, String city, String uf, String postal_code) {
		this.pessoa_id = pessoa_id;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.address = address;
		this.number = number;
		this.additional_address_data = additional_address_data;
		this.city = city;
		this.uf = uf;
		this.postal_code = postal_code;
	}
	
	public ContatoDTO() {}

	public Long getPessoa_id() {
		return pessoa_id;
	}

	public void setId(Long pessoa_id) {
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

	@Override
	public String toString() {
		return 		"[ID:" + pessoa_id + ", " + 
					"Nome: " + first_name + " " + middle_name + " " + last_name + ", " + 
					"Mala Direta: " + address + ", " + number + ", " + additional_address_data +
					" - CEP:" + postal_code +
					" - Cidade" + city + "/" + uf + "]";
	}

	
}

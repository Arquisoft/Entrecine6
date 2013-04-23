package es.uniovi.asw.entrecine.central.system.model;

import java.util.List;

public class User {
	
	private Long id;
	
	private String name;
	
	private String surname;
	
	private String userName;
	
	private String email;
	
	private String password;
	
	private String creditCard;
	
	private List<Movie> recomendations;

	public User(Long id, String name, String surname, String userName,
			String email, String password, String creditCard,
			List<Movie> recomendations) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.creditCard = creditCard;
		this.recomendations = recomendations;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public List<Movie> getRecomendations() {
		return recomendations;
	}

	public void setRecomendations(List<Movie> recomendations) {
		this.recomendations = recomendations;
	}
	
	

}

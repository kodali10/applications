package com.kodali.beans;

import javax.validation.constraints.Size;

public class Offer {
	@Size(min = 5, max = 25, message = "Enter name between 5 to 25 charecters")
	private String name;
	private String email;
	@Size(min = 15, max = 250, message = "Enter text between 5 to 250 charecters")
	private String text;

	public Offer() {

	}

	public Offer(String name, String email, String text) {
		super();
		this.name = name;
		this.email = email;
		this.text = text;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Offer [name=" + name + ", email=" + email + ", text=" + text + "]";
	}

}

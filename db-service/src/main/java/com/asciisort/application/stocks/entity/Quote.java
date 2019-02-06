package com.asciisort.application.stocks.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * @author Sangwan K.
 */

@Entity
@Table(name="quotes", catalog="test")
public class Quote {
	public Quote() {

	}

	public Quote(String userName, String quote) {
		this.quote = quote;
		this.userName = userName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;

	@Column(name="user_name")
	private String userName;

	@Column(name="quote")
	private String quote;

}

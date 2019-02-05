package com.asciisort.application.stocks.entity;

import java.util.List;

/*
 * @author Sangwan K.
 */

public class Quotes {
	public Quotes(String userName, List<String> quotes) {
		this.quotes = quotes;
		this.userName = userName;
	}

	public Quotes() {

	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<String> getQuotes() {
		return quotes;
	}
	public void setQuotes(List<String> quotes) {
		this.quotes = quotes;
	}
	private String userName;
	private List<String> quotes;
}

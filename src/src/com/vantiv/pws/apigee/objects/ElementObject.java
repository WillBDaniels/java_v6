/* Copyright (C) 2014 Vantiv. All Rights Reserved.*/
package com.vantiv.pws.apigee.objects;

public class ElementObject {

	private Credentials credentials;
	private Merchant merchant;
	private Terminal terminal;
	private Transaction transaction;
	private Address address;
	private Card card;

	public ElementObject(Credentials credentials, Merchant merchant,
			Terminal terminal, Transaction transaction,
			Address address, Card card) {

		this.credentials = credentials;

		this.merchant = merchant;
		this.terminal = terminal;
		this.transaction = transaction;
		this.address = address;
		this.card = card;
	}


}

package com.example.BankingApplication.dto;


public class Accountdto {
	
	private Long id;
	private String acountHolderName;
	
	private double balance;

	
	public Accountdto() {
		super();
	}

	public Accountdto(Long id, String acountHolderName, double balance) {
		super();
		this.id = id;
		this.acountHolderName = acountHolderName;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAcountHolderName() {
		return acountHolderName;
	}

	public void setAcountHolderName(String acountHolderName) {
		this.acountHolderName = acountHolderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
}

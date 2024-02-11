package com.example.BankingApplication.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="ACCOUNT")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="AccountHolderName")
	private String AccntHolderName;
	
	@Column(name="Balance")
	private double balance;
	
	
	
	public Account() {
		super();
	}

	public Account(Long id, String accntHolderName, double balance) {
		super();
		this.id = id;
		AccntHolderName = accntHolderName;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccntHolderName() {
		return AccntHolderName;
	}

	public void setAccntHolderName(String accntHolderName) {
		AccntHolderName = accntHolderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}

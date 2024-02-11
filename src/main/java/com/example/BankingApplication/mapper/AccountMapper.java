package com.example.BankingApplication.mapper;


import com.example.BankingApplication.Entity.Account;
import com.example.BankingApplication.dto.Accountdto;

public class AccountMapper {
	
	public static  Account mapToAccount(Accountdto accountdto) {
		Account account= new Account(
				accountdto.getId(),
				accountdto.getAcountHolderName(),
				accountdto.getBalance()
				);
	return account;
	}

	public static Accountdto mapToAccountdto(Account account) {
		Accountdto ancountdto= new Accountdto(
				account.getId(),
				account.getAccntHolderName(),
				account.getBalance());
		return ancountdto;
	}
}

package com.example.BankingApplication.Service;

import java.util.List;

import com.example.BankingApplication.dto.Accountdto;

public interface AccountService {

	Accountdto create(Accountdto accountdto);

	Accountdto getById(Long id);

	Accountdto deposit(Long id, double amt);

	Accountdto withdraw(Long id, double amt);

	List<Accountdto> getAll();

	String delete(Long id);

}

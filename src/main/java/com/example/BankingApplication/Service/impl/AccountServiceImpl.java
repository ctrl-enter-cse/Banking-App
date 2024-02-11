package com.example.BankingApplication.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankingApplication.Entity.Account;
import com.example.BankingApplication.Repository.AccountRepository;
import com.example.BankingApplication.Service.AccountService;
import com.example.BankingApplication.dto.Accountdto;
import com.example.BankingApplication.mapper.AccountMapper;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Accountdto create(Accountdto accountdto) {
		try {

			Account account = AccountMapper.mapToAccount(accountdto);
			Account saverdAccount = accountRepository.save(account);
			return AccountMapper.mapToAccountdto(saverdAccount);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Accountdto getById(Long id) {

		try {
			Account account = accountRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("account do not Exist"));

			return AccountMapper.mapToAccountdto(account);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Accountdto deposit(Long id, double amt) {
		try {
			Account accnt = accountRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("account do not Exist"));
			;
			accnt.setBalance(accnt.getBalance() + amt);
			Account saved = accountRepository.save(accnt);
			return AccountMapper.mapToAccountdto(saved);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Accountdto withdraw(Long id, double amt) {
		try {
			Account accnt = accountRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("account do not Exist"));
			if (accnt.getBalance() < amt) {
				throw new RuntimeException(" not sufficent balance");
			}
			accnt.setBalance(accnt.getBalance() - amt);
			Account saved = accountRepository.save(accnt);
			return AccountMapper.mapToAccountdto(saved);
		} catch (Exception e) {
			throw e;

		}
	}

	@Override
	public List<Accountdto> getAll() {
		try {
			List<Account> accntList = accountRepository.findAll();
			List<Accountdto> accdtoList = new ArrayList<>();
			for (Account ac : accntList) {
				Accountdto Acndto = AccountMapper.mapToAccountdto(ac);
				accdtoList.add(Acndto);
			}
			return accdtoList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String delete(Long id) {
		try {
			accountRepository.deleteById(id);
			return "deleted id" + id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

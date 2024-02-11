package com.example.BankingApplication.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.BankingApplication.Service.AccountService;
import com.example.BankingApplication.dto.Accountdto;

@Controller
//@RequestMapping("/home")
public class AccountController {

	@Autowired
	private AccountService acounAccountService;

	@PostMapping("/create")
	public ResponseEntity<Object> create(@RequestBody Accountdto accountdto) {
		try {
			return new ResponseEntity<Object>(acounAccountService.create(accountdto), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/getbyid", method = RequestMethod.GET)
	public ResponseEntity<Object> getByid(@RequestParam Long id) {
		try {
			Accountdto accnt = acounAccountService.getById(id);
			return ResponseEntity.ok(accnt);
//			return new ResponseEntity<Object>(acounAccountService.getById(id), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/getByidpath/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getByidpath(@PathVariable Long id) {
		try {
			Accountdto accnt = acounAccountService.getById(id);
			return ResponseEntity.ok(accnt);
//			return new ResponseEntity<Object>(acounAccountService.getById(id), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/deposit", method = RequestMethod.POST)
	public ResponseEntity<Object> deposit(@RequestParam Long id, @RequestParam double amt) {
		try {
			Accountdto accnt = acounAccountService.deposit(id, amt);
			return ResponseEntity.ok(accnt);
//			return new ResponseEntity<Object>(acounAccountService.getById(id), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "{id}/deposit", method = RequestMethod.POST)
	public ResponseEntity<Object> depositV1(@PathVariable Long id, @RequestBody Map<String, Double> request) {
		try {
			Accountdto accnt = acounAccountService.deposit(id, request.get("amount"));
			return ResponseEntity.ok(accnt);
//			return new ResponseEntity<Object>(acounAccountService.getById(id), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "{id}/withdraw", method = RequestMethod.POST)
	public ResponseEntity<Object> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
		try {
			Accountdto accnt = acounAccountService.withdraw(id, request.get("amount"));
			return ResponseEntity.ok(accnt);
//			return new ResponseEntity<Object>(acounAccountService.getById(id), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Accountdto>> getAll() {
		try {
			List<Accountdto> accnt = acounAccountService.getAll();
			return ResponseEntity.ok(accnt);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam Long id) {
		try {
			return ResponseEntity.ok(acounAccountService.delete(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

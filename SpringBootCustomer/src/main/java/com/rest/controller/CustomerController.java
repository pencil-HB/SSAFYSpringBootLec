package com.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.service.CustomerService;
import com.rest.vo.Customer;
//@RestController: @Controller + @ResponseBody(java -> json)
@CrossOrigin("*")
@RestController
public class CustomerController {
	@Autowired
	CustomerService service;
	
	/*
	// http://localhost:8080/rest/customers	
	@GetMapping("customers")
	public List<Customer> selectAll() throws Exception {
		List<Customer> list = service.selectAll();
		System.out.println(list.size());
		return list;//data
	}
	*/
	//ResponseEntity:작업한 결과 데이터와 함께 http 상태코드를 제어할 수 있는 객체
	@GetMapping("customers")
	public ResponseEntity<List<Customer>>selectAll() throws Exception {
		List<Customer> list = service.selectAll();
		
		ResponseEntity<List<Customer>> re = 
				new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
		
		//new ResponseEntity<String>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
		
		return re;//data
	}

	// http://localhost:8080/rest/customers/123
	@GetMapping("customers/{num}")
	public Customer selectOne(@PathVariable("num") String num) throws Exception {
		Customer c = service.selectOne(num);
		return c;
	}

	@DeleteMapping("customers/{num}")
	public Map<String, String> delete(@PathVariable("num") String num) throws Exception {
		int c = service.delete(num);

		Map<String, String> map = new HashMap<>();
		if (c >= 1)
			map.put("msg", "삭제성공");
		return map;
	}

	@PostMapping("customers")
	public ResponseEntity<String> insert(@RequestBody Customer c) throws Exception {//json ->java object
		System.out.println("insert");
		System.out.println(c);
		service.insert(c);
		
		return new ResponseEntity<String>("insert success!!!", HttpStatus.OK);
	}

	@PutMapping("customers")
	public Map<String, String> update(@RequestBody Customer c) throws Exception {// json ->java object
		service.update(c);
		Map<String, String> map = new HashMap<>();
		map.put("msg", "수정성공");
		return map;
	}

	// Get:: http://localhost:8080/rest/customers/{condition}/{value}
	//public List<Customer> findByAddress(@PathVariable String condition,@PathVariable String value )
	// Get:: http://localhost:8080/rest/customers/address/seoul
	@GetMapping("customers/{condition}/{address}")
	public List<Customer> findByAddress(@PathVariable("condition") String condition, @PathVariable("address") String address) throws Exception {
		System.out.println("condition:"+condition);
		List<Customer> list;
		
		if(condition.equals("address")) {
			list = service.findByAddress(address);
		} else if(condition.equals("name")) {
			list = service.findByName(address);
		} else {
			list = new ArrayList<>();
		}
		
		return list;
	}

}








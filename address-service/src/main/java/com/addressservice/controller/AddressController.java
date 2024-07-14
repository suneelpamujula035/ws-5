package com.addressservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address-app/api")
public class AddressController {

	@GetMapping("/getAddress")
	public ResponseEntity<String> getAddress() {
		System.err.println("Finding Employee address from address app");
		return new ResponseEntity<String>("ABC Street, Vindur, Gudur, Nellore , Andhra Pradesh, India, 524101",
				HttpStatus.OK);
	}

}

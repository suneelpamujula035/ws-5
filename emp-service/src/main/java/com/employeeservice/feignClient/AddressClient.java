package com.employeeservice.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name = "address-service", url = "http://localhost:8081/address-app/api")
@FeignClient(name = "ADDRESS-SERVICE", path = "/address-app/api")
public interface AddressClient {

	@GetMapping("/getAddress")
	public ResponseEntity<String> getAddress();
}

package com.guimaraes.resource.payment;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guimaraes.resource.ConstantVersion;

@RestController
@RequestMapping("/" + ConstantVersion.VERSION + "/payment")
public class PaymentController {

	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> createNewPayment(@RequestBody String paymentRequest) {
		return new ResponseEntity<>("", HttpStatus.CREATED);
	}

}

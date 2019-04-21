package com.guimaraes.resource.payment;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.guimaraes.resource.ConstantVersion;

@RestController
@RequestMapping("/" + ConstantVersion.VERSION + "/payment")
public class PaymentController {

	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> createNewPayment(@RequestBody String paymentRequest) {
		System.out.println("Dado para pagamento recebido: -> " + paymentRequest);
		consumeAuditAPI(paymentRequest);
		return new ResponseEntity<>("", HttpStatus.CREATED);
	}

	private ResponseEntity<String> consumeAuditAPI(String paymentList) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8084/v1/audit";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(paymentList, headers);
		ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

		System.out.println(response.getStatusCodeValue());

		return new ResponseEntity<String>(HttpStatus.OK);

	}

}

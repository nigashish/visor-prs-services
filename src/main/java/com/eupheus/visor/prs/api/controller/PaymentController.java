package com.eupheus.visor.prs.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.accelerate.visor.model.Payments;
import com.eupheus.visor.prs.api.service.PaymentService;

@RestController
@RequestMapping("/prs")
public class PaymentController {
	@Autowired
	PaymentService paymentService;

	@PostMapping("/dopayment")
	public Payments dopayment(@RequestBody Payments payments) {
		Payments savePayment = paymentService.savePayment(payments);
		return savePayment;
	}
	@GetMapping("/{orderId}")
  public Payments findByPaymentHistoryByOrderId(@PathVariable Long orderId)
  {
	  return paymentService.findByPaymentHistoryByOrderId(orderId);
  }
	
}

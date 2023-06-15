package com.eupheus.visor.prs.api.service;


import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accelerate.visor.school.model.Payments;
import com.eupheus.visor.prs.api.repository.PaymentRepository;



@Service
public class PaymentService {
	private @Autowired PaymentRepository paymentRepository;

	public Payments savePayment(Payments payments) {
		payments.setPaymentStatus(paymentProcessing());
		payments.setTrantactionId(UUID.randomUUID().toString());
		return paymentRepository.save(payments);
	}
	public String paymentProcessing()
	{
		//api should be thirdparty gateway (paypal,paytm,..)
		return new Random().nextBoolean()?"Success":"false";
	}
	public Payments findByPaymentHistoryByOrderId(Long orderId) {
		return paymentRepository.findByOrderId(orderId);
	}

}

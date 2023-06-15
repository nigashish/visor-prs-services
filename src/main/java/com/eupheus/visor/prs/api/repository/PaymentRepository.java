package com.eupheus.visor.prs.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accelerate.visor.school.model.Payments;


@Repository
public interface PaymentRepository extends JpaRepository<Payments, Long>{

	Payments findByOrderId(Long orderId);

}

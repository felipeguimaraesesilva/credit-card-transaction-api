package com.guimaraes.resource.payment.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PaymentList implements Serializable {

	private static final long serialVersionUID = -5803123191392555375L;
	List<PaymentDTO> list;

}

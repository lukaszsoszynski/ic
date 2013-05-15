package com.impaq.ic.cdi.app.service.billing;

import com.impaq.ic.cdi.app.dao.BilinglDAO;

public class BillingBean implements BillingService {

	private final BilinglDAO billDAO;

	public BillingBean(BilinglDAO billDAO) {
		this.billDAO = billDAO;
	}

	@Override
	public String getBill(String name) {
		return billDAO.getById(7);
	}

}

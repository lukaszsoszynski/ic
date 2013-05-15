package com.impaq.ic.cdi.app.dao.orcl;

import com.impaq.ic.cdi.app.annotation.ds.Bill;
import com.impaq.ic.cdi.app.dao.BilinglDAO;
import com.impaq.ic.cdi.app.ds.DataSource;

public class BilingOrclDAO implements BilinglDAO {

	private final DataSource orclBillDatasource;

	public BilingOrclDAO(@Bill DataSource orclBillDatasource) {
		this.orclBillDatasource = orclBillDatasource;
	}

	@Override
	public String getById(long id) {
		return "Bill " + id + " from " + getConnectionName();
	}

	private String getConnectionName() {
		return orclBillDatasource.getConnection().getName();
	}

}

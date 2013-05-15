package com.impaq.ic.cdi.search.player;

import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Named;

/**
 * Class implements Annotation (!!), end enable searching by annotation
 * parameters
 * 
 * @author lsos
 * 
 */
class NameAnnotationLiteral extends AnnotationLiteral<Named>
		implements Named {

	private static final long serialVersionUID = -8732505201004462477L;

	private String value;

	public NameAnnotationLiteral(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return value;
	}

}
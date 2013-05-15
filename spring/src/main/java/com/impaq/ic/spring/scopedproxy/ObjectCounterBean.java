package com.impaq.ic.spring.scopedproxy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link ObjectCounterService}
 * 
 * @author Lukasz
 * 
 */
@Service
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ObjectCounterBean implements ObjectCounterService {

	private final Map<Class<?>, Long> map = new HashMap<Class<?>, Long>();

	public ObjectCounterBean() {
		System.out.println("Object ObjectCounterBean created");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized long addObject(Object object) {
		if (object == null) {
			throw new IllegalArgumentException("Object must not be null");
		}
		Class<?> key = object.getClass();
		return addObject(key);
	}

	/**
	 * {@inheritDoc}
	 */
	public long addObject(Class<?> key) {
		Long currentCount = map.get(key);
		if (currentCount == null) {
			currentCount = 1L;
		} else {
			++currentCount;
		}
		map.put(key, currentCount);
		return currentCount;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized long getObjectCount(Class<?> clazz) {
		if (clazz == null) {
			throw new IllegalArgumentException("Clazz must not be null");
		}
		Long count = map.get(clazz);
		if (count == null) {
			return 0;
		}
		return count;
	}

}

package com.impaq.ic.spring.methodinjections;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * Implementation of {@link ObjectCounterService}
 * 
 * @author Lukasz
 * 
 */
@Service
public class ObjectCounterBean implements ObjectCounterService {

	private final Map<Class<?>, Long> map = new HashMap<Class<?>, Long>();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized long addObject(Object object) {
		if (object == null) {
			throw new IllegalArgumentException("Object must not be null");
		}
		Class<? extends Object> key = object.getClass();
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

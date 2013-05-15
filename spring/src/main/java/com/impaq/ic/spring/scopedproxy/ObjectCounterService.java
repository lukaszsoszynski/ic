package com.impaq.ic.spring.scopedproxy;

/**
 * Count object
 * 
 * @author Lukasz
 * 
 */
public interface ObjectCounterService {

	/**
	 * @param object
	 *            must not be <code>null</code>
	 */
	long addObject(Object object);

	/**
	 * Add object of given class
	 * 
	 * @param clazz
	 *            object class
	 * @return object count
	 */
	long addObject(Class<?> clazz);

	/**
	 * Get count of object with given class
	 * 
	 * @param clazz
	 *            object class must not be <code>null</code>
	 * @return count of object.
	 */
	long getObjectCount(Class<?> clazz);

}

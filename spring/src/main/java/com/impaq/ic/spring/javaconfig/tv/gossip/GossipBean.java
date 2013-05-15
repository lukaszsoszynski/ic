/**
 * 
 */
package com.impaq.ic.spring.javaconfig.tv.gossip;

/**
 * @author Lukasz
 * 
 */
public class GossipBean implements GossipServis {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impaq.ic.spring.javaconfig.GossipServis#getGossip()
	 */
	@Override
	public String getGossip() {
		return "g";
	}

}

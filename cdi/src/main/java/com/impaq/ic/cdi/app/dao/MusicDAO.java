package com.impaq.ic.cdi.app.dao;

public interface MusicDAO extends GenericDAO {

	String getMusicByTrackName(String name);
}

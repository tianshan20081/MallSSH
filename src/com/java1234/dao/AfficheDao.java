package com.java1234.dao;

import java.util.List;

import com.java1234.model.Affiche;
import com.java1234.model.PageBean;

public interface AfficheDao {

	public List<Affiche> allAffiche();
	public Affiche selectOneAffiche(int id);
	public List<Affiche> afficheSelect(PageBean pageBean);
	public int afficheCount();
	public void saveAffiche(Affiche a);
	public void deleteAffiche(int id);
	public void updateAffiche(Affiche affiche);
}

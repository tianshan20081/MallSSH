package com.java1234.service;

import java.util.List;

import com.java1234.model.Affiche;
import com.java1234.model.PageBean;

public interface AfficheService {

	public List<Affiche> allAffiche();
	public Affiche selectOneAffiche(int id);
	public List<Affiche> afficheSelect(PageBean PageBean);
	public int afficheCount();
	public void addAffiche(Affiche a);
	public void deleteAffiche(int id);
	public void updateAffiche(Affiche affiche);
}

package com.linkedin.learning.otrareunionmas.dao;

import java.time.LocalDate;
import java.util.List;

import com.linkedin.learning.otrareunionmas.dominio.Reunion;

import jakarta.persistence.Query;

public class ReunionDao extends AbstractDao<Reunion> {

	public ReunionDao() {
		setClazz(Reunion.class);
	}
	
	public Reunion proximaReunion() {
		String qlString = "FROM "+Reunion.class.getName()+" WHERE fecha > now() order by fecha ";
		Query query = getEntityManager().createQuery(qlString).setMaxResults(1);
		return (Reunion)query.getSingleResult();
	}
	
	public List<Reunion> reunionesManyana() {
		String qlString = "FROM "+Reunion.class.getName()+" WHERE fecha between ?1 and ?2";
		Query query = getEntityManager().createQuery(qlString);
		LocalDate manyana = LocalDate.now().plusDays(1);
		query.setParameter(1,manyana.atStartOfDay());
		query.setParameter(2, manyana.plusDays(1).atStartOfDay());
		return query.getResultList();
	}

}

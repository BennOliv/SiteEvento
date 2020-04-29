package br.com.qintess.projetoEventos.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Repository
@EnableTransactionManagement
public class Dao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	//c
	@Transactional
	public <T> void salva(T t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(t);
	}
	
	//r
	@Transactional
	public <T> List<T> buscaTodos(Class<T> clazz){
		
		Session session = this.sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(clazz);
        query.from(clazz);
        return session.createQuery(query).getResultList();
	}
	@Transactional
	public <T> T buscaPorId(Class<T> clazz, long id){
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(clazz, id);
	}
	
	//u
	@Transactional
	public <T> void atualiza(T t) {
		Session session = this.sessionFactory.getCurrentSession();
		
		session.merge(t);
	}
	
	//d
	@Transactional
	public <T> void deleta(T t) {
		
		Session session = this.sessionFactory.getCurrentSession();
			
			session.remove(t);
			
			t = null;
	}
	
}


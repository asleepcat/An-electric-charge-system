package org.bme.etms.base;

import java.util.List;

import org.bme.base.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class BaseBll {

	public boolean add(Object o) {
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();
			session.save(o);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if (session != null)
				session.getTransaction().rollback();
			return false;
		} finally {
			HibernateUtil.close(session);
		}
	}

	public boolean delete(Object o) {
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();
			session.delete(o);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if (session != null)
				session.getTransaction().rollback();
			return false;
		} finally {
			HibernateUtil.close(session);
		}
	}

	public List load(String hql) {
		Session session = null;
		List list = null;
		try {
			session = HibernateUtil.openSession();
			list = session.createQuery(hql).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			if (session != null)
				session.getTransaction().rollback();
		} finally {
			HibernateUtil.close(session);
		}
		return list;
	}

	public boolean update(Object o) {
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();
			session.update(o);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if (session != null)
				session.getTransaction().rollback();
			return false;
		} finally {
			HibernateUtil.close(session);
		}
	}
	
	public boolean update(String hql) {
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			query.executeUpdate();
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if (session != null)
				session.getTransaction().rollback();
			return false;
		} finally {
			HibernateUtil.close(session);
		}
	}
}

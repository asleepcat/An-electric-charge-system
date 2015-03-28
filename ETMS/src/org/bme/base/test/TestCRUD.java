package org.bme.base.test;

import java.util.Date;

import org.bme.base.model.GetData;
import org.bme.base.model.UserInfo;
import org.bme.base.util.HibernateUtil;
//import org.bme.zhangxiyu.model.User;
import org.hibernate.Session;
import org.junit.Test;
//import java.util.List;

public class TestCRUD {
//	private static final SimpleDateFormat sdf = new SimpleDateFormat(
//			"yyyy-MM-dd");

	@Test
	public void testAdd() {
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();
//			UserInfo u=new UserInfo();
//			u.setYhxm("刘德华");
//			u.setYhsfz("320621156822524X");
//			u.setYhdz("香港九龙湾");
//			u.setYhdh("15895887553");
//			u.setYhqq("5421154548");
//			u.setPowertypeID("1");
//			u.setYhcz("889548572");
//			u.setYhemail("liudehua@Yahoo.com");
//			u.setYhkhyh("建设银行");
//			u.setYhyhzh("5885486888888");
//			u.setYhye("500");
			GetData g=new GetData();
			g.setCbrq(new Date());
			g.setYhid(2);
			g.setCbdl(520.13);
			g.setSfqy("是");
			session.save(g);
//			LoginInfo loginInfo = new LoginInfo();
//			loginInfo.setUsername("lishi");
//			loginInfo.setPassword("123456");
//			session.save(u);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (session != null)
				session.getTransaction().rollback();
		} finally {
			HibernateUtil.close(session);
		}
//		LoginBLL loginBLL = new LoginBLL();
//		LoginInfo loginInfo = new LoginInfo();
//		loginInfo = loginBLL.getLoginInfo("lishi", "123456");
//		System.out.println(loginInfo.getUsername());
//		System.out.println(loginInfo.getPassword());
	}

//	@Test
//	public void testLoad() {
//		Session session = null;
//		try {
//			session = HibernateUtil.openSession();
////			User u = (User) session.load(User.class, 4);
////			System.out.println(u);
//		} catch (Exception e) {
//			e.printStackTrace();
//			if (session != null)
//				session.getTransaction().rollback();
//		} finally {
//			HibernateUtil.close(session);
//		}
//	}
//
//	@Test
//	public void testUpdate() {
//		Session session = null;
//		try {
//			session = HibernateUtil.openSession();
//			session.beginTransaction();
////			User u = (User) session.load(User.class, 5);
////			u.setNickname("李小四");
////			session.update(u);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			if (session != null)
//				session.getTransaction().rollback();
//		} finally {
//			HibernateUtil.close(session);
//		}
//	}
//
//	@Test
//	public void testDelete() {
//		Session session = null;
//		try {
//			session = HibernateUtil.openSession();
//			session.beginTransaction();
////			User u = new User();
////			u.setId(6);
////			session.delete(u);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			if (session != null)
//				session.getTransaction().rollback();
//		} finally {
//			HibernateUtil.close(session);
//		}
//	}
//
//	@Test
//	public void testList() {
//		Session session = null;
//		try {
//			session = HibernateUtil.openSession();
////			List<User> users = session.createQuery("from User").list();
////			for (User u : users) {
////				System.out.println(u);
////			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			if (session != null)
//				session.getTransaction().rollback();
//		} finally {
//			HibernateUtil.close(session);
//		}
//	}
//
//	@Test
//	public void testPager() {
//		Session session = null;
//		try {
//			session = HibernateUtil.openSession();
////			List<User> users = session.createQuery("from User")
////					.setFirstResult(0).setMaxResults(2).list();
////			for (User u : users) {
////				System.out.println(u);
////			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			if (session != null)
//				session.getTransaction().rollback();
//		} finally {
//			HibernateUtil.close(session);
//		}
//	}
}

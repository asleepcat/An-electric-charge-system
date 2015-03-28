package org.bme.etms.login.bll;

import java.util.List;

import org.bme.base.model.LoginInfo;
import org.bme.base.util.HibernateUtil;
import org.hibernate.Session;

@SuppressWarnings("unchecked")
public class LoginBLL {

	public String getLoginInfo(String username, String password) {
		Session session = null;
		try {
			session = HibernateUtil.openSession();

			List<LoginInfo> loginInfo = session.createQuery(
					"from LoginInfo where username = '" + username + "'")
					.list();
			for (LoginInfo u : loginInfo) {
				if (u.getPassword().equals(password))
					return "1";
				else
					return "0";
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (session != null)
				session.getTransaction().rollback();
		} finally {
			HibernateUtil.close(session);
		}
		return "0";
	}
}

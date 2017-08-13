package com.cetc.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class test {

	public static void main(String[] args) {
		Configuration conf = new Configuration();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(conf.getProperties()).build();
		SessionFactory sf=conf.buildSessionFactory(serviceRegistry);
		Session sess=sf.openSession();
		Transaction tx=sess.beginTransaction();
		Ip ip = new Ip();
		ip.setIp("192.168.1.1");
		ip.setUsername("wang过去");
		ip.setDecription("使用可谓 ");
		sess.save(ip);
		tx.commit();
		sess.close();
		sf.close();
	}

}

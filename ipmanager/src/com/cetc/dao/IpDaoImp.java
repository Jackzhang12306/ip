package com.cetc.dao;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.cetc.bean.Ip;
import com.cetc.bean.User;
import com.cetc.util.PageHibernateDaoSupport;

@Repository
public class IpDaoImp extends PageHibernateDaoSupport<Ip> implements IpDao {

    public IpDaoImp() {
        super();
        setClass(Ip.class);
    }

    public List<Ip> findByUser(User user) {
          return  (List<Ip>) getHibernateTemplate().find("from Ip where blog = ? ", user);
    }
}



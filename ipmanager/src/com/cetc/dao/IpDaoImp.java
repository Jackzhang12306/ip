

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.cetc.bean.Ip;
import com.cetc.util.PageHibernateDaoSupport;

@Repository
public class IpDaoImp extends PageHibernateDaoSupport<Ip> implements IpDao {

    public IpDaoImp() {
        super();
        setClass(Ip.class);
    }

    public List<Ip> findByName(String name) {
        String hql = "from Ip where true=true";
        List<Object> values = new ArrayList<Object>();
        if (!name.equals("") && name != null) {
            hql += " and name like ?";
            values.add("%" + name + "%");
        }
          return findByPage(hql, values,1,1);
    }
}



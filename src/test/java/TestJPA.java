import cn.dy.jpa.entity.Customer;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * author:dingyi
 * time:2019/8/14 0014 15:15
 */

public class TestJPA {
    @Test
    public void firstTest(){
        //        1  创键一个EntityManagerFactory  对象    使用完关闭
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myjpa");
        //        2  使用工厂对象EntityManagerFactory  就是一个连接
        EntityManager entityManager = factory.createEntityManager();
        //        3  开启事物
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //        4  创键  Customer  对象
        Customer customer = new Customer();

        customer.setCust_name("小狐狸丿");
        customer.setCustLevel("svip");
        customer.setCustSource("wifi");
        customer.setCustPhone("1234567890");
        customer.setCustAddress("结婚的股份");
        customer.setCustIndustry("你猜");

        //        5 使用Entitymanager 对象  的persist 方法向数据库添加数据
        entityManager.persist(customer);
        //        6  事物提交
        transaction.commit();
        //        7  关闭连接
        entityManager.close();
        factory.close();
    }
}

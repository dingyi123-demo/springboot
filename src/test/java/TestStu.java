
import cn.dy.jpa.entity.Stu;
import org.junit.Test;

import javax.persistence.*;


/**
 * author:dingyi
 * time:2019/8/14 0014 16:05
 */
public class TestStu {
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

        Stu stu = new Stu();
        stu.setName("jack");
        stu.setAge(123);
        stu.setSex("男");

        //        5 使用Entitymanager 对象  的persist 方法向数据库添加数据
        entityManager.persist(stu);
        //        6  事物提交
        transaction.commit();
        //        7  关闭连接
        entityManager.close();
        factory.close();
    }
}

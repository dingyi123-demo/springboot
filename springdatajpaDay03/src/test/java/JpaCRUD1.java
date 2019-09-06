import cn.dy.jpa.dao.StuDao;
import cn.dy.jpa.entity.Stu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * author:dingyi
 * time:2019/8/16 0016 14:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JpaCRUD1 {
    @Autowired
    private StuDao customerDao;
    //增
    @Test
    public void addCustomer(){
  //        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        StuDao customerDao = ac.getBean(StuDao.class);
        for (int i=0;i<30;i++) {
            Stu customer = new Stu();
            customer.setName("桥本有菜");
            customer.setAge("22");
            customer.setSex("女");

            customerDao.save(customer);
        }
    }
    //删
    @Test
    public void deleteCustomer(){
        customerDao.delete(33L);

    }
    //改
    @Test
    public void updateCuseromer(){
        Stu customer = customerDao.findOne(3L);
       customer.setName("安琪拉");
       customer.setAge("13");
       customerDao.save(customer);
    }
    //查
    //根据ID查询
    @Test
    public void findById(){
        Stu one = customerDao.findOne(1L);
        System.out.println(one);
    }
}

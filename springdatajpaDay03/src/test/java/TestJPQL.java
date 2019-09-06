import cn.dy.jpa.dao.StuDao;
import cn.dy.jpa.entity.Stu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author:dingyi
 * time:2019/8/19 0019 10:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestJPQL {
    @Autowired
    StuDao customerDao;
    @Test
    public void testGetAllCustomer(){
        List<Stu> list = customerDao.getAllCustomer();
        for (Stu customer:list){
            System.out.println(customer);
        }
       }

       @Test
    public void testGetCustomerByPage(){
           List<Stu> page = customerDao.getAllCustomerByPage(new PageRequest(0, 5));
           for(Stu customer:page){
               System.out.println(customer);
           }

       }
       @Test
       public void testCustomerById(){
           Stu customerById = customerDao.getCustomerById(3L);
           System.out.println(customerById);

       }

    @Test
    public void testGetCustList(){
        List<Stu> custList = customerDao.getCustList("%桥%", "%女%");
        for (Stu customer:custList){
            System.out.println(customer);
        }

    }
    @Test
    @Transactional
    @Commit
    public void testUpdateSource(){
        customerDao.updateSource("铃原爱蜜莉",7L);
    }
    //原生语句
    @Test
    public void testGetCustomerListNavite(){
        List<Stu> list = customerDao.getCustomerListNavite("%菜%");
        for (Stu customer:list){
            System.out.println(customer);
        }
    }

}

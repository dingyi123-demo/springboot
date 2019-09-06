import cn.dy.pojo.Customer;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

/**
 * author:dingyi
 * time:2019/8/15 0015 15:04
 */
public class test {
    private EntityManagerFactory entityManagerFactory;
    @Before  //表示在任意使用 @Test 注解标注的 public void 方法执行之前执行
    public void init(){
        entityManagerFactory = Persistence.createEntityManagerFactory("myjpa");

    }
    //增
    @Test
    public void addCustomer(){
       //1.创建EntityManager  对象
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //2.开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //3.创建Customer(顾客)对象
        for (int i=0;i<20;i++){
            Customer customer = new Customer();
            customer.setCustAddress("广寒宫");
            customer.setCustIndustry("种植");//产业
            customer.setCustLevel("熟练");//水平
            customer.setCustName("小白兔");
            customer.setCustPhone("1245467");
            customer.setCustSource("南天门");//来源
            entityManager.persist(customer);

        }
        //4.提交事务
        transaction.commit();
        //5.关闭连接
        entityManager.close();
    }
//删
@Test
    public void delCustomer(){
    //   1  获得EntityManager对象
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    //2.开启事务
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
    //3.先从数据库中 查询一个 Customer 对象
    Customer customer = entityManager.find(Customer.class, 20L);
    //4.使用entityManager 对象 remove方法删除  参数就是Customer对象
    entityManager.remove(customer);
    //5.提交事务
    transaction.commit();
    //6.关闭连接
    entityManager.close();

}
//改
@Test
    public void updateCustomer(){
        //1.获得EntityManager 对象
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    //2.开启事务
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
    //3.根据id查询一个Customer对象
    Customer customer = entityManager.find(Customer.class, 2L);
    //4.修改对象的属性
    customer.setCustSource("龙宫");
    customer.setCustPhone("123456");
    customer.setCustName("小嫦娥");
    customer.setCustLevel("牢笼");
    customer.setCustIndustry("show");
    customer.setCustAddress("三生树");
    //5.保存
    entityManager.merge(customer);
    //6.提交事务
    transaction.commit();
    //7.关闭连接
    entityManager.close();

}
//查
    //1.根据ID查询-1

    /**
     * getReference:延迟加载
     * 该方法获取的是一个动态代理对象，是比较常用得
     */
    @Test
    public void findById(){
        //1.创建entityManager对象
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    //2.查询
    Customer customer = entityManager.getReference(Customer.class, 2L);
    System.out.println(customer);
    //3.关闭连接
    entityManager.close();

}
  // 根据ID查询-2

    /**
     * find:立即加载
     * 该方法获取的是对象本身
     */
    @Test
    public void findById2(){
        //1.创建entityManager对象
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //2.查询
        Customer customer = entityManager.find(Customer.class, 20L);
        System.out.println(customer);
        //3.关闭连接
        entityManager.close();

    }
//查询所有
    @Test
    public void findAll(){
        //1.创建entityManager对象
        EntityManager entityManager = entityManagerFactory.createEntityManager();
         // 使用EntryManager 创建一个Query对象  基于jpql 创建
        // 参数  就是jpql 语句
        Query query = entityManager.createQuery("from Customer");
        //  使用query对象 执行查询
        List<Customer> resultList = query.getResultList();
        //打印结果
             for (Customer customer:resultList){
                 System.out.println(customer);
             }
        //3.关闭连接
        entityManager.close();
    }
    //查询分页
    @Test
    public void  findAllPage(){
        //1.创建entityManager对象
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // 创建query对象
        Query query = entityManager.createQuery("from Customer");
        //设置分页信息
        query.setFirstResult(0);
        query.setMaxResults(5);
        //执行查询
        List<Customer> resultList = query.getResultList();
        for (Customer customer:resultList){
            System.out.println(customer);
        }
        entityManager.close();
    }
//jpal按id查
    @Test
    public void findJpal(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("from Customer where custId=?");
        //设置参数
        query.setParameter(1,2L);//1：表示的是有几个问号
        //执行查询
        Customer customer= (Customer) query.getSingleResult();
        System.out.println(customer);
        entityManager.close();
    }
//模糊查询
    @Test
    public void findJpalByName(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("from Customer where custName like ? and custAddress like ?");
        query.setParameter(1,"%小%");
        query.setParameter(2,"%广%");
        //执行查询
        List<Customer> resultList = query.getResultList();
            for (Customer customer:resultList){
                System.out.println(customer);
            }
            entityManager.close();
    }
    //排序查询
    @Test
    public void findAllByOrder(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("from Customer order by custId desc ");//asc升序
        List<Customer> resultList = query.getResultList();
        for (Customer customer:resultList){
            System.out.println(customer);
        }
        entityManager.close();
    }
    //聚合函数
    @Test
    public void findAllCount(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select count(*) from Customer");
        // Query query = entityManager.createQuery("select sum(custId) from Customer");//升序 asc
        Object count = query.getSingleResult();
        System.out.println(count);
        entityManager.close();
    }
}

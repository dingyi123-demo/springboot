import cn.dy.jpa.dao.StuDao;
import cn.dy.jpa.entity.Stu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * author:dingyi
 * time:2019/8/19 0019 17:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDataJpaVoid {
    @Autowired
    StuDao stuDao;
    @Test
    public void testFindByStuId(){
        Stu byStuId = stuDao.findByStuId(1L);
        System.out.println(byStuId);
    }

@Test
    public void testFindByNameLikeAndSexLike(){
    List<Stu> list = stuDao.findByNameLikeAndSexLike("%桥%", "%女%");
    for (Stu stu:list){
        System.out.println(stu);
    }
}
@Test
    public void testfindByNameByPage(){
    Page<Stu> page = stuDao.findByNameLike("%菜%", new PageRequest(0, 5));
    System.out.println(page.getTotalElements());
    System.out.println(page.getTotalPages());
    List<Stu> list = page.getContent();
    for (Stu stu:list){
        System.out.println(stu);
    }
}
    // 测试 使用Specification方式进行查询
    //单个
    @Test
    public void testFindBySpeciFication(){
        Stu stuId = stuDao.findOne(new Specification<Stu>() {
            @Override
            public Predicate toPredicate(Root<Stu> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //  参数1  字段名称

                // 参数2    字段的值
                Predicate predicate = cb.equal(root.get("stuId"), 1L);

                return predicate;
            }
        });
        System.out.println(stuId);
    }
    //排序
    @Test
    public void testFindByStuIdDesc(){
        List<Stu> list = stuDao.findAll(new Specification<Stu>() {
            @Override
            public Predicate toPredicate(Root<Stu> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                // 创建 根据模糊查询的条件
                Predicate name = cb.like(root.get("name"), "%菜%");

                 return name;
            }
        }, new Sort(Sort.Direction.DESC, "stuId"));

            for (Stu stu :list){
            System.out.println(stu);
        }
    }
//条件查
    @Test
    public void testFindByNameSex(){
        stuDao.findAll(new Specification<Stu>() {
            @Override
            public Predicate toPredicate(Root<Stu> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                // 创建 根据模糊查询的条件
                Predicate name = cb.like(root.get("name"), "%本%");
                Predicate sex = cb.like(root.get("sex"), "%女%");
                // 组合两个条件
                Predicate and = cb.and(name, sex);

                return and;
            }
        }).forEach(System.out::println);//forEach(stu -> System.out.println(stu));
    }
    //分页查
    @Test
    public void testFindByNmaeSexWithPage(){
        Page<Stu> page = stuDao.findAll(new Specification<Stu>() {
            @Override
            public Predicate toPredicate(Root<Stu> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                // 创建 根据模糊查询的条件
                Predicate name = cb.like(root.get("name"), "%菜%");
                Predicate sex = cb.like(root.get("sex"), "%女%");
                // 组合两个条件
                Predicate and = cb.and(name, sex);
                return and;
            }
        }, new PageRequest(0, 5));
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
        List<Stu> list = page.getContent();
        for (Stu stu :list){
            System.out.println(stu);
        }
    }
}

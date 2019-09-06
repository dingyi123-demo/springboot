import cn.dy.jpa.dao.StuDao;
import cn.dy.jpa.dao.TeaDao;
import cn.dy.jpa.entity.Stu;
import cn.dy.jpa.entity.Tea;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * author:dingyi
 * time:2019/8/20 0020 19:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class testOneToMany {
    @Autowired
        TeaDao teaDao;
    @Autowired
        StuDao stuDao;
    /**
     * 保存一个教师，一个学生
     *
     */
    @Test
    @Transactional //配置事务
    @Commit
    @Rollback(false) //不自动回滚
    public void testAdd(){
        //创建一个教师，创建一个学生
        Tea tea = new Tea();
        tea.setTeaName("吉泽明步");
        tea.setTeaAge("34");
        tea.setTeaSex("女");
        tea.setTeaJob("教师");

        Stu stu1 = new Stu();
        stu1.setStuName("张敏");
        stu1.setStuSex("女");
        stu1.setStuAge("32");
        Stu stu2 = new Stu();
        stu2.setStuName("思思");
        stu2.setStuSex("女");
        stu2.setStuAge("33");

        tea.getStus().add(stu1);
        tea.getStus().add(stu2);
        stu1.setTea(tea);
        stu2.setTea(tea);

        teaDao.save(tea);
        stuDao.save(stu1);
        stuDao.save(stu2);


    }
}

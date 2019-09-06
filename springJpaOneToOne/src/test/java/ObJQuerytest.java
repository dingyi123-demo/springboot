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

import java.util.Set;

/**
 * author:dingyi
 * time:2019/8/21 0021 16:24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class ObJQuerytest {
    @Autowired
    TeaDao teaDao;
    @Autowired
    StuDao stuDao;

    /**
     * could not initialize proxy - no Session  报错原因：  @Transactional
     */
    @Test
    @Transactional
    @Commit
    @Rollback(false)
    public void testQuery(){
        //查询id为1的教师
        Tea teaDaoOne = teaDao.getOne(1L);
        //对象导航查询，此教师下的所有学生
        Set<Stu> stus = teaDaoOne.getStus();
        for (Stu stu:stus){
            System.out.println(stu);
        }
    }
}

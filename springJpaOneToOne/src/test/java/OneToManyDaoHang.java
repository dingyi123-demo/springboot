import cn.dy.jpa.dao.StuDao;
import cn.dy.jpa.dao.TeaDao;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * author:dingyi
 * time:2019/8/21 0021 16:25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class OneToManyDaoHang {
    @Autowired
    TeaDao teaDao;
    @Autowired
    StuDao stuDao;
}

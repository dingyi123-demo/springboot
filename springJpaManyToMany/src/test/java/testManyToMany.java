import cn.dy.jpa.dao.SysRoleDao;
import cn.dy.jpa.dao.SysUserDao;
import cn.dy.jpa.entity.SysRole;
import cn.dy.jpa.entity.SysUser;
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
 * time:2019/8/21 0021 11:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class testManyToMany {
    @Autowired
    SysUserDao userDao;
    @Autowired
    SysRoleDao roleDao;
    @Test
    @Transactional
    @Commit
    public void addUserAndRole(){
        // 1创建用户
        SysUser sysUser = new SysUser();
         sysUser.setUsername("admin");
          sysUser.setPassword("123456");
        // 2创建  角色
         SysRole sysRole = new SysRole();
        sysRole.setRolename("管理员");
        sysRole.setMemo("权限");
        // 3 配置用户和角色之间的关系
        sysUser.getRoles().add(sysRole);
        sysRole.getUsers().add(sysUser);
        //4  把用户角色写入数据可
        userDao.save(sysUser);
        //roleDao.save(sysRole); //无需再写
    }

    @Test
    @Transactional
    @Commit
    public void addUserAndRole1(){
        // 1创建用户
        SysUser user = new SysUser();
        user.setUsername("林志玲");
        user.setPassword("123456");
        SysUser user1 = new SysUser();
        user1.setUsername("杨幂");
        user1.setPassword("123456");
        // 2创建  角色
        SysRole role = new SysRole();
        role.setRolename("演员");
        SysRole rol = new SysRole();
        rol.setRolename("女主脚");
        // 3 配置用户和角色之间的关系
        user.getRoles().add(role);
        user.getRoles().add(rol);

        user1.getRoles().add(rol);
        user1.getRoles().add(role);

          role.getUsers().add(user);
          role.getUsers().add(user1);
          rol.getUsers().add(user);

          rol.getUsers().add(user1);
        //4  把用户角色写入数据可
        userDao.save(user);
        userDao.save(user1);
    }
    /**
     * 删除操作
     * 	在多对多的删除时，双向级联删除根本不能配置
     * 禁用
     *	如果配了的话，如果数据之间有相互引用关系，可能会清空所有数据
     */
    @Test
    @Transactional
    @Commit
    @Rollback(false)
    public void removeUserAndRole(){

        userDao.delete(1L);
        userDao.delete(2L);

    }
}

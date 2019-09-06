package cn.dy.jpa.dao;

import cn.dy.jpa.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * author:dingyi
 * time:2019/8/21 0021 10:03
 */
public interface SysUserDao extends JpaRepository<SysUser,Long>, JpaSpecificationExecutor<SysUser> {
}

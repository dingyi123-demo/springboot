package cn.dy.jpa.dao;

import cn.dy.jpa.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * author:dingyi
 * time:2019/8/21 0021 10:04
 */
public interface SysRoleDao extends JpaRepository<SysRole,Long>, JpaSpecificationExecutor<SysRole> {
}

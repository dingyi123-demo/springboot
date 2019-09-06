package cn.dy.jpa.dao;

import cn.dy.jpa.entity.Stu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;



/**
 * author:dingyi
 * time:2019/8/20 0020 18:48
 */
public interface StuDao extends JpaRepository<Stu,Long>, JpaSpecificationExecutor<Stu> {
}

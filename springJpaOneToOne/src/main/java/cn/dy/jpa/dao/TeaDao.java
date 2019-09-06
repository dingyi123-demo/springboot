package cn.dy.jpa.dao;

/**
 * author:dingyi
 * time:2019/8/20 0020 18:43
 */

import cn.dy.jpa.entity.Tea;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;





public interface TeaDao extends JpaRepository<Tea,Long>, JpaSpecificationExecutor<Tea> {

}

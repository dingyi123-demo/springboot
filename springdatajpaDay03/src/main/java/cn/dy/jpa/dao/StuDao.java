package cn.dy.jpa.dao;

import cn.dy.jpa.entity.Stu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

/**
 * author:dingyi
 * time:2019/8/16 0016 14:50
 */
public interface StuDao extends JpaRepository<Stu,Long>,JpaSpecificationExecutor<Stu>{

    @Query("from Stu")
   List<Stu> getAllCustomer();
    //分页查询
    @Query("from Stu ")
   List<Stu> getAllCustomerByPage(Pageable pageable);
    // 条件查询
    @Query("from Stu where stuId=?1")
    Stu getCustomerById(Long id);
    // 模糊查询
    @Query("from Stu where name like ?1 and sex like ?2")
    List<Stu> getCustList(String name, String sex);
    // 更新

    @Query("update Stu set name=?1 where stuId=?2")
    @Modifying
//    @Transactional
    public void updateSource(String name,Long stuId);

    //原生语句条件查询操作
    @Query(value = "SELECT * FROM cust_stu where name like ?1",nativeQuery = true)
    List<Stu> getCustomerListNavite(String name);

    //方法命名规则查询
   Stu findByStuId(long id);


    List<Stu> findByNameLikeAndSexLike(String name,String sex);
    // 分页
    Page<Stu> findByNameLike(String Name, Pageable pageable);

}



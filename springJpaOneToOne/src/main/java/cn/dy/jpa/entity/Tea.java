package cn.dy.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * author:dingyi
 * time:2019/8/20 0020 14:57
 */
// 声明该类是jpa的实体类
@Entity
@Table(name = "cust_tea")
public class Tea implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="tea_id")
    private long teaId;
    @Column(name="tea_name")
    private String teaName;
    @Column(name="tea_sex")
    private String teaSex;
    @Column(name="tea_age")
    private String teaAge;
    @Column(name="tea_Job")
    private String teaJob;
    // 配置教师与学生之间的关系 （一对多关系）
    /**
     * 使用注解的形式配置多表关系
     *       1.声明关系
     *              @OneToMany; 配置一对多关系
     *       2.配置外键（中间表）
     *       @JoinColumn:配置外键
     *            name 外键字段名称
     *            referencedColumnName：参照的主表字段名称
     *  在教师实体类上（一的一方）添加了外键配置，所以对于学生而言，也具备了维护外键的作用
     */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JoinColumn(name = "teaid",referencedColumnName = "tea_id")
    private Set<Stu> Stus=new HashSet<>();

    public long getTeaId() {
        return teaId;
    }

    public void setTeaId(long teaId) {
        this.teaId = teaId;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getTeaSex() {
        return teaSex;
    }

    public void setTeaSex(String teaSex) {
        this.teaSex = teaSex;
    }

    public String getTeaAge() {
        return teaAge;
    }

    public void setTeaAge(String teaAge) {
        this.teaAge = teaAge;
    }

    public String getTeaJob() {
        return teaJob;
    }

    public void setTeaJob(String teaJob) {
        this.teaJob = teaJob;
    }

    public Set<Stu> getStus() {
        return Stus;
    }

    public void setStus(Set<Stu> stus) {
        Stus = stus;
    }

    @Override
    public String toString() {
        return "Tea{" +
                "teaId=" + teaId +
                ", teaName='" + teaName + '\'' +
                ", teaSex='" + teaSex + '\'' +
                ", teaAge='" + teaAge + '\'' +
                ", teaJob='" + teaJob + '\'' +
                '}';
    }
}

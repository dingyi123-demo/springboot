package cn.dy.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * author:dingyi
 * time:2019/8/20 0020 17:32
 */
@Entity
@Table(name = "cust_stu")
public class Stu implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "stu_id")
    private Long stuId;
    @Column(name = "stu_name")
    private String stuName;
    @Column(name = "stu_sex")
    private String stuSex;
    @Column(name = "stu_age")
    private String stuAge;

    /**
     * 配置学生到教师的多对一关系
     *     使用注解的形式配置多对一关系
     *        1.配置表关系
     *             @ManyToOne: 配置多对一关系
     *        2.配置外键（中间表）
     *        配置外键的过程，配置到了多的一方，就会再多的一方维护外键
     */
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "stuid",referencedColumnName = "tea_id")

    private  Tea tea;
    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuAge() {
        return stuAge;
    }

    public void setStuAge(String stuAge) {
        this.stuAge = stuAge;
    }



    public Tea getTea() {
        return tea;
    }

    public void setTea(Tea tea) {
        this.tea = tea;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", stuAge='" + stuAge + '\'' +

                '}';
    }
}

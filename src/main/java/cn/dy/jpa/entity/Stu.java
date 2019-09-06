package cn.dy.jpa.entity;

import javax.persistence.*;

/**
 * author:dingyi
 * time:2019/8/14 0014 16:00
 */
@Entity
@Table(name="cust_stu")
public class Stu {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private Long Id;
   @Column (name="name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @Column(name = "sex")
    private String sex;

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

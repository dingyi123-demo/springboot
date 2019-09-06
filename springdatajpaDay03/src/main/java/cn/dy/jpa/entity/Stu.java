package cn.dy.jpa.entity;


import javax.persistence.*;


/**
 * author:dingyi
 * time:2019/8/16 0016 14:41
 */
@Entity
@Table(name = "cust_stu")
public class Stu {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "stuId")
    private Long stuId;
    @Column(name = "age")
    private String age;
    @Column(name = "name")
    private String name;
    @Column(name = "sex")
    private String sex;

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "stuId=" + stuId +
                ", age='" + age + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}

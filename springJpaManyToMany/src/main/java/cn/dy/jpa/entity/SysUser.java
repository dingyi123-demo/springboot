package cn.dy.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * author:dingyi
 * time:2019/8/21 0021 10:02
 */
@Entity
@Table(name = "sys_user")
public class SysUser implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="user_id")
    private long userId;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    /**
     * 配置用户到角色的多对多关系
     *      配置多对多的映射关系
     *          1.声明表关系的配置
     *              @ManyToMany(targetEntity = SysRole.class,cascade = CascadeType.ALL)  //多对多
     *                  targetEntity：代表对方的实体类字节码
     *          2.配置中间表（包含两个外键）
     *                @JoinTable
     *                  name : 中间表的名称
     *                  joinColumns：配置当前对象在中间表的外键
     *                      @JoinColumn的数组
     *                          name：外键名
     *                          referencedColumnName：参照的主表的主键名
     *                  inverseJoinColumns：配置对方对象在中间表的外键
     */
    @ManyToMany(targetEntity = SysRole.class,cascade = CascadeType.ALL)
    @JoinTable(name = "sys_user_role",
            //   joinColumns 当前表在中间表中的外键           参照当前表的主键字段
            joinColumns = {@JoinColumn(name = "userid", referencedColumnName = "user_id")},

            //    inverseJoinColumns 对方对象在中间表 的外键                     参照当前表的主键字段
            inverseJoinColumns = {@JoinColumn( name = "roleid", referencedColumnName = "role_id")}

    )
    private Set<SysRole> roles = new HashSet<>();

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SysRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +

                '}';
    }
}

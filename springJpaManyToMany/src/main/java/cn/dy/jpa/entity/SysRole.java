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
@Table(name = "sys_role")
public class SysRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private long roleId;
    @Column(name="role_name")
    private String rolename;
    @Column(name="memo")
    private String memo;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)//放弃维护权
    private Set<SysUser> users = new HashSet<>();

    @Override
    public String toString() {
        return "SysRole{" +
                "roleId=" + roleId +
                ", rolename='" + rolename + '\'' +
                ", memo='" + memo + '\'' +

                '}';
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Set<SysUser> getUsers() {
        return users;
    }

    public void setUsers(Set<SysUser> users) {
        this.users = users;
    }
}

package com.myslyv4uk.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.common.base.Objects;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "role_id", unique = true, nullable = false)
    private Integer roleId;

    @Column(name = "role", length = 10)
    private String role;

    @OneToMany
    @JoinColumn(name = "role")
    private List<User> user;

    public Role() {
        super();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(roleId, role);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Role) {
            Role that = (Role) object;
            return Objects.equal(this.roleId, that.roleId) && Objects.equal(this.role, that.role);
        }
        return false;
    }
}

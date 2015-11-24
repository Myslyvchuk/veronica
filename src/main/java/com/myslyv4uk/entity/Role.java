package com.myslyv4uk.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.google.common.base.Objects;

@Entity
@Table(name = "ROLES")
public class Role {

    @Id
    @SequenceGenerator(name = "role_id_seq", sequenceName = "role_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_seq")
    @Column(name = "role_id", unique = true, nullable = false)
    private Integer roleId;

    @Column(name = "role", length = 10)
    private String role;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<User> users;

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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(roleId, role, users);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Role) {
            Role that = (Role) object;
            return Objects.equal(this.roleId, that.roleId) && Objects.equal(this.role, that.role)
                    && Objects.equal(this.users, that.users);
        }
        return false;
    }
}

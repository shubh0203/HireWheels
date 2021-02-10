package com.upgrad.hirewheels.entities;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="role_id",length = 10)
    private int roleId;

    @Column(name = "role_name",length = 50,nullable = false,unique = true)
    private String roleName;

    @OneToMany (mappedBy = "role", fetch = FetchType.EAGER, cascade =  {CascadeType.ALL})
    private Set<User> users;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    @Override
    public String toString(){
     return "role{"+
             "roleId="+roleId+'\'' +
             "roleName="+roleName+'\'' +
             "}";
    }
}

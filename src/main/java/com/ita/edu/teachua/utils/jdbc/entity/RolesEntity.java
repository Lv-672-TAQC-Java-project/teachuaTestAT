package com.ita.edu.teachua.utils.jdbc.entity;

import java.util.ArrayList;
import java.util.List;

public class RolesEntity {

    public static final String SELECT_ALL = "SELECT * FROM roles ORDER BY id;";

    private Integer id;
    private String name;

    public RolesEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public RolesEntity() {
        this.id = 0;
        this.name = null;
    }

    public static RolesEntity getRole(List<String> row) {
        RolesEntity role = new RolesEntity();
        role.setId(Integer.parseInt(row.get(0)));
        role.setName(row.get(1));

        return role;
    }

    public static List<RolesEntity> getRoles(List<List<String>> rows) {
        List<RolesEntity> roles = new ArrayList<>();
        for (List<String> row : rows) {
            roles.add(getRole(row));
        }
        return roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RolesEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

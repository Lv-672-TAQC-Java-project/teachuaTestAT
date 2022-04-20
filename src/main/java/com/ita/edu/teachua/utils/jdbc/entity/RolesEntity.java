package com.ita.edu.teachua.utils.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class RolesEntity {

    public static final String SELECT_ALL = "SELECT * FROM roles ORDER BY id;";

    private Integer id;
    private String name;

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

    @Override
    public String toString() {
        return "RolesEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

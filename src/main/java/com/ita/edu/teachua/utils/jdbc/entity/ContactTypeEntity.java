package com.ita.edu.teachua.utils.jdbc.entity;

import java.util.ArrayList;
import java.util.List;

public class ContactTypeEntity {
    public static final String SELECT_ALL = "SELECT * FROM contact_type ORDER BY id;";

    private Long id;
    private String name;
    private String urlLogo;

    public ContactTypeEntity(Long id, String urlLogo, String name) {
        this.id = id;
        this.urlLogo = urlLogo;
        this.name = name;
    }

    public ContactTypeEntity() {
        this.id = 0L;
        this.urlLogo = null;
        this.name = null;
    }

    public static ContactTypeEntity getContactType(List<String> row) {
        ContactTypeEntity contactType = new ContactTypeEntity();
        contactType.setId(Long.parseLong(row.get(0)));
        contactType.setName(row.get(1));
        contactType.setUrlLogo(row.get(2));

        return contactType;
    }

    public static List<ContactTypeEntity> getContactTypes(List<List<String>> rows) {
        List<ContactTypeEntity> contactTypes = new ArrayList<>();
        for (List<String> row : rows) {
            contactTypes.add(getContactType(row));
        }
        return contactTypes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ContactTypeEntity{" +
                "id=" + id +
                ", urlLogo=" + urlLogo +
                ", name='" + name + '\'' +
                '}';
    }
}

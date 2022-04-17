package com.ita.edu.teachua.utils.jdbc.entity;

import java.util.ArrayList;
import java.util.List;

public class ArchiveEntity {

    public static final String SELECT_ALL = "SELECT * FROM archive ORDER BY id;";

    private Long id;
    private String className;
    private String data;

    public ArchiveEntity(Long id, String className, String data) {
        this.id = id;
        this.className = className;
        this.data = data;
    }

    public ArchiveEntity() {
        this.id = 0L;
        this.className = null;
        this.data = null;
    }

    public static ArchiveEntity getArchive(List<String> row) {
        ArchiveEntity archive = new ArchiveEntity();
        archive.setId(Long.parseLong(row.get(0)));
        archive.setClassName(row.get(1));
        archive.setData(row.get(2));

        return archive;
    }

    public static List<ArchiveEntity> getArchives(List<List<String>> rows) {
        List<ArchiveEntity> archives = new ArrayList<>();
        for (List<String> row : rows) {
            archives.add(getArchive(row));
        }
        return archives;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ArchiveEntity{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}

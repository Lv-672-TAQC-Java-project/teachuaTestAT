package com.ita.edu.teachua.utils.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class ArchiveEntity {

    public static final String SELECT_ALL = "SELECT * FROM archive ORDER BY id;";

    private Long id;
    private String className;
    private String data;

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

    @Override
    public String toString() {
        return "ArchiveEntity{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}

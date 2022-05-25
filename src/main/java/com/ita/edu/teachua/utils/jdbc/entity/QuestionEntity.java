package com.ita.edu.teachua.utils.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class QuestionEntity {

    public static final String SELECT_ALL = "SELECT * FROM question ORDER BY id;";

    private Long id;
    private String text;
    private String title;

    public QuestionEntity() {
        this.id = 0L;
        this.text = null;
        this.title = null;
    }

    public static QuestionEntity getQuestion(List<String> row) {
        QuestionEntity question = new QuestionEntity();
        question.setId(Long.parseLong(row.get(0)));
        question.setText(row.get(1));
        question.setTitle(row.get(2));

        return question;
    }

    public static List<QuestionEntity> getQuestions(List<List<String>> rows) {
        List<QuestionEntity> questions = new ArrayList<>();
        for (List<String> row : rows) {
            questions.add(getQuestion(row));
        }
        return questions;
    }

    @Override
    public String toString() {
        return "QuestionEntity{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

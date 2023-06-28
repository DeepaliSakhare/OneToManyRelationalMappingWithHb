package com.mahagan.onetomanyrelationalmapping.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int qid;
    private String queName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "q_id")
    @OrderColumn (name = "type")
    private List<Answers> answers;

    public int getId() {
        return qid;
    }

    public void setId(int qid) {
        this.qid = qid;
    }

    public String getQueName() {
        return queName;
    }

    public void setQueName(String queName) {
        this.queName = queName;
    }

    public List<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }
}

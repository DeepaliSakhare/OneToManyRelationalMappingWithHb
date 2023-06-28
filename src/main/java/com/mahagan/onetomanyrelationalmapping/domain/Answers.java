package com.mahagan.onetomanyrelationalmapping.domain;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name="answers")
public class Answers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String ansName;
    private  String postedBy;
    private  String createdBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnsName() {
        return ansName;
    }

    public void setAnsName(String ansName) {
        this.ansName = ansName;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}

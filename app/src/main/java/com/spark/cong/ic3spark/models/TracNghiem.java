package com.spark.cong.ic3spark.models;

public class TracNghiem {
    private int id;
    private String question;
    private String ans_a;
    private String ans_b;
    private String ans_c;
    private String ans_d;
    private String result;
    private String image;
    private String hadAns="";

    public String getHadAns() {
        return hadAns;
    }

    public void setHadAns(String hadAns) {
        this.hadAns = hadAns;
    }

    public TracNghiem(int id, String question, String ans_a, String ans_b, String ans_c, String ans_d, String result, String image,String hadAns) {
        this.id = id;
        this.question = question;
        this.ans_a = ans_a;
        this.ans_b = ans_b;
        this.ans_c = ans_c;
        this.ans_d = ans_d;
        this.result = result;
        this.image = image;
        this.hadAns= hadAns;
    }

    public TracNghiem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns_a() {
        return ans_a;
    }

    public void setAns_a(String ans_a) {
        this.ans_a = ans_a;
    }

    public String getAns_b() {
        return ans_b;
    }

    public void setAns_b(String ans_b) {
        this.ans_b = ans_b;
    }

    public String getAns_c() {
        return ans_c;
    }

    public void setAns_c(String ans_c) {
        this.ans_c = ans_c;
    }

    public String getAns_d() {
        return ans_d;
    }

    public void setAns_d(String ans_d) {
        this.ans_d = ans_d;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

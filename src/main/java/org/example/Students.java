package org.example;

public class Students {

  private String name;
  private int score;

  public Students(String name, int score) {
    this.name = name;
    this.score = score;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public String toString(){
    return "名前：" + name + ",　点数：" + score;
  }
}


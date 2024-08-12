package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    List<Students> studentsList = new ArrayList<>();

    while (true) {

      System.out.println("\n1.学生を追加");
      System.out.println("2.学生を削除");
      System.out.println("3.点数を更新");
      System.out.println("4.平均点を計算");
      System.out.println("5.全学生の情報を表示");
      System.out.println("6.終了");
      System.out.println("実行したい番号を入力してください：");

      char number = scanner.next().charAt(0);

      switch (number) {

        case '1' -> { //学生の追加
          System.out.println("追加したい学生の名前を入力してください：");
          scanner.nextLine();//改行文字を消費する
          String inputName = scanner.nextLine();

          System.out.println("点数を入力してください：");

          while (!scanner.hasNextInt()) {
            System.out.println("有効な点数を入力してください：");
            scanner.next(); //無効な入力をスキップ
          }
          int inputScore = scanner.nextInt();
          scanner.nextLine();

          studentsList.add(new Students(inputName, inputScore));
          System.out.println(inputName + "が追加されました");
        }

        case '2' -> { //学生の削除
          System.out.println("削除したい学生の名前を入力してください：");
          scanner.nextLine(); //改行文字を消費する
          String deleteName = scanner.nextLine();

          boolean removed = studentsList.removeIf
              (student -> student.getName().equals(deleteName));

          if (removed) {
            System.out.println(deleteName + "が削除されました");
          } else {
            System.out.println(deleteName + "という学生は見つかりませんでした");
          }
        }

        case '3' -> { //点数の変更
          System.out.println("点数を変更したい学生の名前を入力してください：");
          scanner.nextLine(); //改行文字を消費する
          String changeScoreName = scanner.nextLine();

          //一致する学生を探す
          for (Students student : studentsList) {
            if (student.getName().equals(changeScoreName)) {
              System.out.println("新しい点数を入力してください：");

              while (!scanner.hasNextInt()) {
                System.out.println("有効な点数を入力してください：");
                scanner.next(); //無効な入力をスキップ
              }
              int newScore = scanner.nextInt();
              scanner.nextLine(); //改行文字を消費する

              //点数の変更
              student.setScore(newScore);
              System.out.println(changeScoreName + "の点数が" + newScore + "に変更されました。");

              break;

            } else {
              System.out.println(changeScoreName + "という学生は見つかりませんでした。");
            }
          }
        }

        case '4' -> {
          if (studentsList.isEmpty()) {
            System.out.println("学生リストが空です。");
          } else {
            int totalScore = 0;
            for (Students student : studentsList) {
              totalScore += student.getScore();
            }
            double averageScore = (double) totalScore / studentsList.size();
            System.out.println("平均点： " + averageScore + "点");
          }
        }
        case '5' -> {
          scanner.nextLine(); //改行文字を消費する
          System.out.println("全学生の情報を表示します。");
          for (Students students : studentsList) {
            System.out.println(students);
          }
        }
        case '6' -> System.out.println("プログラムを終了します。");

      }

      if (number == '6') {
        break;
      }
    }
  }
}
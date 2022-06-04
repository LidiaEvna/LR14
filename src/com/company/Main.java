package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите x ");
        int x = scanner.nextInt();
        Formula po = new Formula(x);
        po.displayFormula();
        System.out.print("Введите слово ");
        String word = scanner.next();

        if (word.equals("save")) {
            try (ObjectOutputStream fww = new ObjectOutputStream(new FileOutputStream("D://LOK.txt"))) {
                fww.writeObject(po);
                fww.writeInt(x);
                System.out.println("Окей");

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("Ошибка");
        }
        System.out.print("Введите слово 2 ");

        String word2 = scanner.next();
        if (word2.equals("upload")) {
            try (ObjectInputStream pt = new ObjectInputStream(new FileInputStream("D://LOK.txt"))) {
                Formula form = (Formula) pt.readObject();
                System.out.println(form.x);
                System.out.println("Ok2");
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        else {
            System.out.println("Ошибка2");
        }
    }
}
class Formula implements Serializable {
    float x;
    public Formula(float x) {
        this.x =x;
    }
    public void displayFormula() {
        double vector =x - (Math.sin(x));
        System.out.println(vector);
    }
}
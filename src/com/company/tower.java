package com.company;

import java.util.Scanner;

public class tower {
    static final int SQUARE_CHOICE = 1;
    static final int TRIANGLE_CHOICE = 2;
    static final int EXIT_CHOISE = 3;

    static final int TRIANGLE_MAX_HEIGHT = 2;
    static final int SZ_DIFF = 5;

    int height;
    int width;
    Scanner in;

    public void getUserInput() {
        System.out.println("Enter height:");
        this.height = this.in.nextInt();
        System.out.println("Enter width:");
        this.width = this.in.nextInt();
    }


    public void printValue(int value, int width) {
        int x = (width - value) / 2;
        for (int i = 0; i < x; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < value; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public void printTriangle() {
        int sum = (this.width - 2) / 2;
        int x = (this.height - 2) / sum;
        int s = (this.height - 2) % sum;
        int value = 1;
        int y = this.width / 2;

        for (int i = 0; i < y; i++) {
            System.out.print(" ");
        }
        System.out.println("*");
        for (int i = 0; i < s; i++) {
            printValue(value + 2, this.width);
        }
        for (int i = 0; i < sum; i++) {
            value += 2;
            for (int j = 0; j < x; j++) {
                printValue(value, this.width);
            }
        }
    }

    public int perimeterArea() {
        return 2 * (this.height + this.width);
    }

    public void trianglePerimeter() {
        double t1 = 0.5 * this.width;
        double t2 = (t1 * t1) + (this.height * this.height);
        t2 /= t2;
        t2 += t2 + this.width;
        System.out.println("Triangle perimeter : " + t2);
    }

    public void processAll() {
        int userInput;
        in = new Scanner(System.in);

        do {
            System.out.println("Enter your choice: 1 for square, 2 for triangle and 3 for the exit");
            userInput = in.nextInt();

            if (userInput == SQUARE_CHOICE) {

                getUserInput();

                if (Math.abs(height - width) > SZ_DIFF) {
                    System.out.println("square area : " + height * width);
                } else {
                    int perimeter = perimeterArea();
                    System.out.println("square perimeter : " + perimeter);
                }

            } else if (userInput == TRIANGLE_CHOICE) {

                getUserInput();

                System.out.println("please enter your choice \n 1 - חישוב היקף המשולש \n 2 - הדפסת המשולש");
                int choice = in.nextInt();
                if (choice == 1)
                    trianglePerimeter();
                else {
                    if (width % 2 == 0 || width > height * 2)
                        System.out.println("לא ניתן להדפיס את המשולש");
                    else printTriangle();
                }
            }
        } while (userInput != EXIT_CHOISE);
    }
}

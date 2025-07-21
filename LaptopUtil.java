package com.qsp.lms.util;

import java.util.Scanner;
import com.qsp.lms.model.Laptop;

public class LaptopUtil {
    static Scanner sc = new Scanner(System.in);

    public static Laptop createLaptop() {
        Laptop l = new Laptop();
        System.out.print("Enter Laptop ID: ");
        l.setId(sc.nextInt());
        sc.nextLine();  // consume leftover newline

        System.out.print("Enter Laptop Brand: ");
        l.setBrand(sc.nextLine());

        System.out.print("Enter Laptop Price: ");
        l.setPrice(sc.nextDouble());
        sc.nextLine(); // consume leftover newline

        System.out.print("Enter Laptop Model: ");
        l.setModel(sc.nextLine());

        return l;
    }
}

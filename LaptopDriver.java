package com.qsp.lms;

import java.util.Scanner;
import com.qsp.lms.dao.LaptopDao;
import com.qsp.lms.model.Laptop;
import com.qsp.lms.util.LaptopUtil;

public class LaptopDriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("\n====== Laptop Management Menu ======");
                System.out.println("1. Add Laptop");
                System.out.println("2. Find Laptop by ID");
                System.out.println("3. Delete Laptop by ID");
                System.out.println("4. View All Laptops");
                System.out.println("5. Update price for Laptops");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        LaptopDao.saveLaptop(LaptopUtil.createLaptop());
                        System.out.println("Laptop saved successfully!");
                        break;
                    case 2:
                        System.out.print("Enter ID to search: ");
                        int id = sc.nextInt();
                        Laptop found = LaptopDao.getLaptopById(id);
                        System.out.println(found != null ? found : "Laptop not found.");
                        break;
                    case 3:
                        System.out.print("Enter ID to delete: ");
                        int delId = sc.nextInt();
                        boolean deleted = LaptopDao.deleteById(delId);
                        System.out.println(deleted ? "Laptop deleted." : "Laptop not found.");
                        break;
                    case 4:
                        LaptopDao.findAll();
                        break;
                    case 5:
                    	System.out.print("Enter ID : ");
                    	int n=sc.nextInt();
                    	System.out.print("Enter Update price : ");
                    	double p=sc.nextDouble();
                        LaptopDao.updateLaptopPrice(n,p);
                        System.out.print("Data update in Database... ");
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}

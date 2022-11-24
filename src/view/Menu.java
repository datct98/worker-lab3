package view;

import entity.Worker;
import handle.WorkerHandle;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    WorkerHandle handle = new WorkerHandle();

    public void displayMenu(Scanner sc, ArrayList<Worker> workers){

        String choose;
        while (true){
            System.out.println("========= Worker Management==========");
            System.out.println("1. Add worker");
            System.out.println("2. Up salary");
            System.out.println("3. Down salary");
            System.out.println("4. Display salary");
            System.out.println("5. Exit");
            System.out.println("Please choose: ");
            choose = sc.nextLine();
            if(Integer.parseInt(choose)>1 && Integer.parseInt(choose)<5 && workers.size()<1){
                System.out.println("You need to add worker first! Please try again");
                continue;
            }
            if(handle.checkValidNumber(choose) && Integer.parseInt(choose)<=5){
                break;
            }
        }

        switch (choose){
            case "1":
                handle.addWorker(sc, workers);
                break;
            case "2":
                handle.upSalary(sc, workers);
                break;
            case "3":
                // Down salary mn làm tương tự nhé
                break;
            case "4":
                handle.displaySalary(workers);
                break;
            case "5":
                System.out.println("Thank you!");
                System.exit(0);
        }
    }
}

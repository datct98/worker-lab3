package handle;

import entity.Worker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class WorkerHandle {
    public void addWorker(Scanner sc, ArrayList<Worker> workers){
        System.out.println("Mời b nhập tên: ");
        String name = sc.nextLine();
        String salaryInput;
        do {
            System.out.println("Mời b nhập Lương: ");
            salaryInput =sc.nextLine();
        } while (!checkValidSalary(salaryInput));
        double salary = Double.parseDouble(salaryInput);
        workers.add(new Worker(name, salary));
        System.out.println("Add worker successfully!");
    }

    public void upSalary(Scanner sc, ArrayList<Worker> workers){
        boolean flag = false;
        int id =0;
        while (true){
            System.out.println("Nhập id muốn tăng lương: ");
            // Cho người dùng nhập dưới dạng String
            String numberInput = sc.nextLine();
            //Sau đó mình check xem String người dùng nhập vào có thể parse thành number hay k
            if(checkValidNumber(numberInput)){
                id = Integer.parseInt(numberInput);
                break;
            }
        }

        for (Worker worker : workers){
            if(worker.getId() == id){
                String salaryInput;

                do {
                    System.out.println("Mời b nhập số lương mới: ");
                    salaryInput = sc.nextLine();
                } while (!checkValidSalary(salaryInput));

                double salary = Double.parseDouble(salaryInput);
                worker.setSalary(salary);
                flag= true;
                System.out.println("Update successfully");
                break;
            }
        }
        if(!flag) System.out.println("Id k tồn tại");
    }

    public void displaySalary(ArrayList<Worker> workers){
        System.out.printf("%-3s %-10s %-3s %-10s ","Code","Name","Salary","Date");
        System.out.println();
        for (Worker worker: workers) {
            System.out.printf("%-3s %-13s %-3s %-9s ", worker.getId(),
                    worker.getName(), worker.getSalary(), LocalDate.now());
            System.out.println();
        }
    }

    public boolean checkValidNumber(String num){
        try {
            int numInt = Integer.parseInt(num);
            if(numInt<0) {
                System.out.println("Input wrong, Pls try again");
                return false;
            }
            return numInt > 0;
        } catch (Exception e){
            System.out.println("Invalid number");
            return false;
        }
    }

    public boolean checkValidSalary(String num){
        try {
            double numDouble = Double.parseDouble(num);
            if(numDouble<0){
                System.out.println("Salary need to be an integer");
                return false;
            }
            return numDouble > 0;
        } catch (Exception e){
            System.out.println("Invalid salary");
            return false;
        }
    }
}

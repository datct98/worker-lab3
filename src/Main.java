import entity.Worker;
import view.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Worker>workers = new ArrayList<>();
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);

        System.out.println();
        //Hiển thị menu cho ng dùng chọn
        while (true){
            menu.displayMenu(sc, workers);
        }


    }
}

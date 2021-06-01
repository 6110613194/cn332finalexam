/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn332finalproject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pong
 */
public class CN332finalproject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isrun = true;
        int countu = 0;
        String state = "";
        User u;
        System.out.println("Registor : ...");
        System.out.print("What is your name?: ");
        String in_name = sc.nextLine();
        System.out.print("Email Address : ");
        String in_email = sc.nextLine();
        System.out.print("Password : ");
        String in_password = sc.nextLine();
        System.out.println("Your name is " + in_name + "\n"
                + "Your email address is " + in_email);
        u = new User(in_name, in_email, in_password);

        while (isrun) {
            System.out.println("print'quit'=quit program");
            System.out.println("What service do you want?\n"
                    + "1.ฺBook room(1)\n"
                    + "2.Pay room(2)\n"
                    + "3.Check status payment");
            String inputprogram = sc.nextLine();
            if (inputprogram.compareTo("quit") == 0) {
                isrun = false;
            }
            if (Integer.parseInt(inputprogram) == 1) {
                Bookroom br = new Bookroom();
                System.out.println("All room in hotel");
                int i = 1;
                for (Room r : br.getListroom()) {
                    System.out.println(i + "." + "Room type :" + r.getRoomtype() + " Cost :" + r.getCost() + "(" + i + ")");
                    i += 1;
                }
                System.out.println("What room you chose?");
                String inputchooseroom = sc.nextLine();
                int cr = Integer.parseInt(inputchooseroom);
                if (cr < 0 || cr > br.getListroom().size()){System.out.println("Unknow room");break;}
                for (Room r : br.getListroom()) {
                    if (r.getId() == cr) {
                        u.addBookroom(r);
                        break;
                    }
                }
            } else if (Integer.parseInt(inputprogram) == 2) {
                if (u.getBookroom() == null) {
                    System.out.println("Don't have bookroom in this user");
                } else {
                    System.out.println("Choose your room to pay");
                    int i = 1;
                    for (Room r : u.getBookroom()) {
                        System.out.println(i + "." + "Room :" + r.getRoomtype() + " Cost :" + r.getCost() + "(" + i + ")");
                        i += 1;
                    }
                    String yr = sc.nextLine();
                    int iyr = Integer.parseInt(yr);
                    Room rfp = null;
                    i = 1;
                    for (Room r : u.getBookroom()) {
                        if (i == iyr) {
                            rfp = r;
                        }
                        i += 1;
                    }
                    if (rfp == null){System.out.println("Don't have this payment");break;}
                    System.out.println("What kind of payment\n"
                            + "1.cash(1)\n"
                            + "2.credit(2)");
                    String p = sc.nextLine();
                    int pm = Integer.parseInt(p);
                    if (pm == 1) {
                        rfp.paycash();
                    } else if (pm == 2) {
                        rfp.paycredit();
                    } else {
                        System.out.println("Unknow this payment");
                    }
                }
            } else if (Integer.parseInt(inputprogram) == 3) {
                if (u.getBookroom() == null) {
                    System.out.println("Don't have bookroom in this user");
                } else {
                    int i = 1;
                    for(Room r : u.getBookroom()){
                        System.out.println(i+"."+"Room:"+r.getRoomtype()+" Cost:"+r.getCost()+"Payment:"+r.isIspay());
                    }
                    i = 1;
                }
            } else {
                System.out.println("Unknow command");
            }
            System.out.println("");
        }
    }

}

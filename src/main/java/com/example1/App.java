package com.example1;

import com.example1.info.Customer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        List<Customer> customerList = new ArrayList<>();
        int choice;
        Scanner s= new Scanner(System.in);
        do {
            System.out.println("1. Insert");
            System.out.println("2. Display one");
            System.out.println("3. Display all");
            System.out.println("4. Delete ");
            System.out.println("5. Update");
            System.out.println("6. Exit");
            System.out.println("Enter your choice");

            choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Customer information:");
                    System.out.println("Id:");
                    int tId = s.nextInt();
                    System.out.println("Name:");
                    String tName = s.next();
                    System.out.println("City");
                    String tCity= s.next();
                    Customer c = new Customer(tId,tName,tCity);
                    customerList.add(c);
                    break;
                case 2:
                    System.out.println("Enter customer id : ");
                    int searchbyid = s.nextInt();
                    Iterator<Customer> iterator1 = customerList.iterator();
                    while (iterator1.hasNext()){
                        Customer customer = iterator1.next();
                        if(customer.getId()==searchbyid){
                           // customerList.remove(customer);
                           System.out.println(customer);
                        }

                    }
                    //System.out.println("Record deleted");
                break;
                case 3:
                    System.out.println("Customer List");
                    Iterator<Customer> iterator = customerList.iterator();
                    while (iterator.hasNext()) {
                        Customer customer = iterator.next();
                        System.out.println(customer);
                    }
                break;
                case 4:
                    System.out.println("Enter customer id : ");
                    int searchid = s.nextInt();
                    Iterator<Customer> iterator2 = customerList.iterator();
                    while (iterator2.hasNext()){
                        Customer customer = iterator2.next();
                        if(customer.getId()==searchid){
                            customerList.remove(customer);
                            // System.out.println(customer);
                        }

                    }
                    //System.out.println("Record deleted");
                    break;
                case 5:
                    System.out.println("Enter customer id : ");
                    int searchforid = s.nextInt();
                    Iterator<Customer> iterator3 = customerList.iterator();

                    while (iterator3.hasNext()){
                        Customer customer = iterator3.next();
                        if(customer.getId()==searchforid){
                            //customerList.remove(customer);
                            // System.out.println(customer);
                            System.out.println("Enter name to be update");
                            String tsName = s.next();
                            customer.setName(tsName);
                            System.out.println("Enter city to be update");
                            String tsCity = s.next();
                            customer.setCity(tsCity);
                            System.out.println("Record Updated");
                        }
                       // System.out.println("ID Not Found");

                    }

                    break;
                case 6:
                    break;
                default:
                    System.out.println("Please enter correct choice");
                    break;
            }

        } while (choice != 6);
    }
}

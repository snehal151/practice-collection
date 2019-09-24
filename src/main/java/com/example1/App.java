package com.example1;

import com.example1.info.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
// it is main class..........
public class App {
    private static Logger logger = LoggerFactory.getLogger(App.class);
    
    public static void main(String[] args) {
        List<Customer> customerList = new ArrayList<>();
        int choice;
        Scanner s= new Scanner(System.in);
        do {
            logger.info("1. Insert");
            logger.info("2. Display one");
            logger.info("3. Display all");
            logger.info("4. Delete ");
            logger.info("5. Update");
            logger.info("6. Exit");
            logger.info("Enter your choice");

            choice = s.nextInt();

            switch (choice) {
                case 1:
                    Customer customer1 = getNewCustomer(s);
                    customerList.add(customer1);
                    break;
                case 2:
                    logger.info("Enter customer id : ");
                    int idToSearch = s.nextInt();

                    if(isExist(idToSearch,customerList)==true) {
                    printCustomer(idToSearch, customerList);
                } else {
                        logger.error("Provided id {} not found!", idToSearch);
                    }
                break;
                case 3:
                    printCustomerList(customerList);
                break;
                case 4:
                    logger.info("Enter customer id : ");
                    idToSearch = s.nextInt();

                    if (isExist(idToSearch , customerList) == true) {
                        removeCustomer(idToSearch, customerList);
                    } else {
                        logger.error("Provided id {} not found!", idToSearch);
                    }
                 break;
                case 5:
                    logger.info("Enter customer id : ");
                    idToSearch = s.nextInt();
                    if (isExist(idToSearch , customerList) == true) {
                        updateCustomer(idToSearch, customerList,s);
                    } else {
                        logger.error("Provided id {} not found!", idToSearch);
                    }
                 break;
                case 6:
                    break;
                default:
                    logger.info("Please enter correct choice");
                    break;
            }

        } while (choice != 6);
    }

    private static void updateCustomer(int idToSearch, List<Customer> customerList,Scanner s) {
        Iterator<Customer> iterator3 = customerList.iterator();

        while (iterator3.hasNext()){
            Customer customer = iterator3.next();
            if(customer.getId()==idToSearch){
                logger.info("Enter name to be update");
                String tsName = s.next();
                customer.setName(tsName);
                logger.info("Enter city to be update");
                String tsCity = s.next();
                customer.setCity(tsCity);
                logger.info("Record Updated");
            }
        }
    }
    private static void removeCustomer(int idToSearch, List<Customer> customerList) {
        Iterator<Customer> iterator2 = customerList.iterator();
        while (iterator2.hasNext()){
            Customer customer = iterator2.next();
            if(customer.getId()==idToSearch){
                customerList.remove(customer);
            }
        }
    }
    private static void printCustomerList(List<Customer> customerList) {
        logger.info("Customer List");
        Iterator<Customer> iterator = customerList.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            logger.info(customer.toString());
        }
    }
    private static void printCustomer(int idToSearch, List<Customer> customerList) {
        Iterator<Customer> iterator1 = customerList.iterator();
        while (iterator1.hasNext()){
            Customer customer = iterator1.next();
            if(customer.getId()==idToSearch){
                // customerList.remove(customer);
                logger.info(customer.toString());
            }
        }
    }
    private static boolean isExist(int idToSearch , List<Customer> customerList){
        Iterator<Customer> iterator1 = customerList.iterator();
        while (iterator1.hasNext()){
            Customer customer = iterator1.next();
            if(customer.getId()==idToSearch){
                return true;
            }
        }
        return false;
    }
    private static Customer getNewCustomer(Scanner s) {
        logger.info("Enter Customer information:");
        logger.info("Id:");
        int tId = s.nextInt();
        logger.info("Name:");
        String tName = s.next();
        logger.info("City");
        String tCity= s.next();
        return new Customer(tId,tName,tCity);
    }
}

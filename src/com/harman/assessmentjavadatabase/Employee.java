package com.harman.assessmentjavadatabase;

import java.sql.*;
import java.util.Scanner;

public class Employee {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int option;
        while (true) {

            System.out.println("select an option: ");
            System.out.println("1.add an employee: ");
            System.out.println("2.view all employee: ");
            System.out.println("3.exit");
            option=in.nextInt();
            switch (option){
                case 1:
                    try {
                        Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb?autoReconnect=true&useSSL=false","root","");
                        String  empcode,name,phone,email,designation,salary,companyname,address;
                        System.out.println("enter the code: ");
                        empcode=in.next();
                        System.out.println("enter the name: ");
                        name=in.next();
                        System.out.println("enter the phone: ");
                        phone=in.next();
                        System.out.println("enter the email: ");
                        email=in.next();
                        System.out.println("enter the designation: ");
                        designation=in.next();
                        System.out.println("enter the salary: ");
                        salary=in.next();
                        System.out.println("enter the company name: ");
                        companyname=in.next();
                        System.out.println("enter the address: ");
                        address=in.next();
                        Statement stmt=c.createStatement();
                        stmt.executeUpdate("INSERT INTO `employee`( `empcode`, `name`, `phone`, `email`, `designation`, `salary`, `companyname`, `address`)"+ "VALUES('"+empcode+"','"+name+"',"+phone+",'"+email+"','"+designation+"',"+salary+",'"+companyname+"','"+address+"') ");
                        System.out.println("inserted successfully");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }break;
                case 2:
                    System.out.println("view all employees");
                    try {
                        Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb?autoReconnect=true&useSSL=false","root","");
                        Statement stmt=c.createStatement();
                        ResultSet rs=stmt.executeQuery("SELECT `id`, `empcode`, `name`, `phone`, `email`, `designation`, `salary`, `companyname`, `address` FROM `employee` WHERE 1");
                        while (rs.next()){
                            System.out.println("empcode= "+rs.getInt("empcode"));
                            System.out.println("name= "+rs.getString("name"));
                            System.out.println("phone= "+rs.getBigDecimal("phone"));
                            System.out.println("email= "+rs.getString("email"));
                            System.out.println("designation= "+rs.getString("designation"));
                            System.out.println("salary= "+rs.getInt("salary"));
                            System.out.println("companyname= "+rs.getString("companyname"));
                            System.out.println("address= "+rs.getString("address"));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invaild option");
            }
        }
    }
}

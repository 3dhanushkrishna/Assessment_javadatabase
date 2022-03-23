package com.harman.assessmentjavadatabase;

import java.sql.*;
import java.util.Scanner;

public class Phone {
    public static void main(String[] args)  {
        Scanner in =new Scanner(System.in);
        int option;
        while(true){
            System.out.println("select an option: ");
            System.out.println("1.add a smartphone: ");
            System.out.println("2.view all smartphone: ");
            System.out.println("3.search phones based on brands: ");
            System.out.println("4.edit the smartphone using imei no: ");
            System.out.println("5.delete the smartphone using imei no: ");
            System.out.println("6.exit");
            option= in.nextInt();
            switch (option){
                case 1:
                    try {
                        Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ smartphonedb?autoReconnect=true&useSSL=false","root","");
                        String imei,brand,model,price;
                        System.out.println("enter the imei no: ");
                        imei=in.next();
                        System.out.println("enter the brand: ");
                        brand=in.next();
                        System.out.println("enter the model: ");
                        model=in.next();
                        System.out.println("enter the price: ");
                        price=in.next();
                        Statement stmt=c.createStatement();
                        stmt.executeUpdate("INSERT INTO `phone`( `imei`, `brand`, `model`, `price`)"+" VALUES('"+imei+"','"+brand+"','"+model+"',"+price+")");
                        System.out.println("inserted successfully");

                    }catch (Exception e){
                        System.out.println(e);
                    }break;
                case 2:
                    System.out.println("view all smartphone:");
                     try {
                         Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ smartphonedb?autoReconnect=true&useSSL=false","root","");
                         Statement stmt=c.createStatement();
                         ResultSet rs=stmt.executeQuery("SELECT `id`, `imei`, `brand`, `model`, `price` FROM `phone` WHERE 1");
                         while (rs.next()){
                             System.out.println("imei= "+rs.getString("imei"));
                             System.out.println("brand= "+rs.getString("brand"));
                             System.out.println("model= "+rs.getString("model"));
                             System.out.println("price= "+rs.getInt("price"));
                         }
                     }catch (Exception e){
                         System.out.println(e);
                     }break;
                case 3:
                    try {
                        Scanner input=new Scanner(System.in);

                        String brand;
                        System.out.println("enter the brand to be searched: ");
                        brand=input.next();

                        Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ smartphonedb?autoReconnect=true&useSSL=false","root","");
                        Statement stmt=c.createStatement();
                        ResultSet rs=stmt.executeQuery("SELECT * FROM `phone` WHERE 'brand'='"+brand+"'");

                        while (rs.next()){
                            System.out.println("imei= "+rs.getString("imei"));

                            System.out.println("model= "+rs.getString("model"));
                            System.out.println("price= "+rs.getInt("price"));

                        }
                    }catch (Exception e){
                        System.out.println(e);
                    }break;
                case 4:
                    try {
                        Scanner input=new Scanner(System.in);
                        int imei;
                        System.out.println("enter the imei to be update: ");
                        imei=input.nextInt();

                        String brand,model,price;

                        System.out.println("enter the brand: ");
                        brand=input.next();
                        System.out.println("enter the model: ");
                        model=input.next();
                        System.out.println("enter the price: ");
                        price=input.next();


                        Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ smartphonedb?autoReconnect=true&useSSL=false","root","");
                        Statement stmt=c.createStatement();
                        stmt.executeUpdate("UPDATE `phone` SET `brand`='"+brand+"',`model`='"+model+"',`price`="+price+" WHERE `imei`="+imei);

                        System.out.println("updated successfully");
                    }catch (Exception e){
                        System.out.println(e);
                    }break;
                case 5:
                    try {
                        String imei;
                        System.out.println("enter the imei to be deleted: ");
                        imei=in.next();
                        Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ smartphonedb?autoReconnect=true&useSSL=false","root","");
                        Statement stmt=c.createStatement();
                        stmt.executeUpdate("DELETE FROM `phone` WHERE 'imei'="+imei);
                        System.out.println("deleted successfully");
                    }catch (Exception e){
                        System.out.println(e);
                    }break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invaild option");
            }
        }
    }
}

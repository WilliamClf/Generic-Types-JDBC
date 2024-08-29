package com.unimater;

import com.sun.net.httpserver.HttpServer;
import com.unimater.controller.HelloWorldHandler;
import com.unimater.dao.ProductTypeDAO;
import com.unimater.model.ProductType;
import com.unimater.dao.SaleTypeDAO;
import com.unimater.model.SaleType;
import com.unimater.dao.SaleItemTypeDAO;
import com.unimater.model.SaleItemType;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main( String[] args ){
        try {
            HttpServer servidor = HttpServer.create(
                    new InetSocketAddress(8080),0
            );

            servidor.createContext("/helloWorld",
                    new HelloWorldHandler());

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbc2608", "root", "sdb162sw"
            );

            ProductTypeDAO productTypeDAO = new ProductTypeDAO(connection);

            productTypeDAO.getAll().forEach(System.out::println);
            productTypeDAO.upsert(new ProductType(0, "Teste ProductType"));
            productTypeDAO.getAll().forEach(System.out::println);
            System.out.println(productTypeDAO.getById(1));
            productTypeDAO.delete(5);
            productTypeDAO.getAll().forEach(System.out::println);

            SaleTypeDAO saleTypeDAO = new SaleTypeDAO(connection);

            saleTypeDAO.getAll().forEach(System.out::println);
            saleTypeDAO.upsert(new SaleType(0, "Teste SaleType"));
            saleTypeDAO.getAll().forEach(System.out::println);
            System.out.println(saleTypeDAO.getById(1));
            saleTypeDAO.delete(5);
            saleTypeDAO.getAll().forEach(System.out::println);

            SaleItemTypeDAO saleItemTypeDAO = new SaleItemTypeDAO(connection);

            saleItemTypeDAO.getAll().forEach(System.out::println);
            saleItemTypeDAO.upsert(new SaleItemType(0, "Teste SaleItemType"));
            saleItemTypeDAO.getAll().forEach(System.out::println);
            System.out.println(saleTypeDAO.getById(1));
            saleItemTypeDAO.delete(5);
            saleItemTypeDAO.getAll().forEach(System.out::println);


            servidor.setExecutor(null);
            servidor.start();
            System.out.println("Servidor rodando na porta 8080");
        } catch (IOException e) {
            System.out.println(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

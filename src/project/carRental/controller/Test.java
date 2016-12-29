package project.carRental.controller;

import project.carRental.connection.DBPool;
import project.carRental.container.Container;
import project.carRental.dao.implementations.OrderDAO;
import project.carRental.dao.implementations.UserDAO;
import project.carRental.entity.Role;
import project.carRental.entity.User;
import project.carRental.propertiesManagers.CommandSQLManager;
import project.carRental.services.SecurityPass;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class Test {
    public static void main(String[] args) throws ParseException, SQLException {
        System.out.println(SecurityPass.passCrypt("1"));
    }
}

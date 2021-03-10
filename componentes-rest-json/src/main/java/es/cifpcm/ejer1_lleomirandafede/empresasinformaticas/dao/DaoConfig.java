/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.ejer1_lleomirandafede.empresasinformaticas.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author fedel
 */
public class DaoConfig {
    private String driverClassName;
    private String databaseUrl;
    private String databaseUser;
    private String databasePassword;

    public DaoConfig() {
    }

    public DaoConfig(final DaoConfig dfc) {

        this.driverClassName = dfc.driverClassName;
        this.databaseUrl = dfc.databaseUrl;
        this.databaseUser = dfc.databaseUser;
        this.databasePassword = dfc.databasePassword;

    }

    public DaoConfig(String archivo) {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(archivo);) {

            Properties prop = new Properties();

            prop.load(input);

            this.setDriverClassName(prop.getProperty("database.driver"));
            this.setDatabaseUrl(prop.getProperty("database.url"));
            this.setDatabaseUser(prop.getProperty("database.user"));
            this.setDatabasePassword(prop.getProperty("database.password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public DaoConfig(String driverClassName, String databaseUrl, String databaseUser, String databasePassword) {
        this.driverClassName = driverClassName;
        this.databaseUrl = databaseUrl;
        this.databaseUser = databaseUser;
        this.databasePassword = databasePassword;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public String getDatabaseUser() {
        return databaseUser;
    }

    public void setDatabaseUser(String databaseUser) {
        this.databaseUser = databaseUser;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public void setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
    }
}


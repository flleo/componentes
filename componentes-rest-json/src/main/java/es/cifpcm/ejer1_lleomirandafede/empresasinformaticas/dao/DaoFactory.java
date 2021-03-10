/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.ejer1_lleomirandafede.empresasinformaticas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fedel
 */

public class DaoFactory {

 
    private static DaoFactory instance;

    protected final DaoConfig dfc;

   
    protected DaoFactory(DaoConfig dfc) {
        this.dfc = new DaoConfig(dfc);
        try {
            Class.forName(dfc.getDriverClassName());
           
        } catch (ClassNotFoundException ex) {
           
        }
    }

    /**
     *
     * @return
     */
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(dfc.getDatabaseUrl(),
                    dfc.getDatabaseUser(), dfc.getDatabasePassword());
        } catch (SQLException ex) {
            //logger.error("getConnection", ex);
            return null;
        }
    }

    /**
     *
     * @param conn
     */
    public void closeConnection(Connection conn) {

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
               //logger.error("closeConnection", ex);
            }
        }

    }

    /**
     * Se llama la primera vez para crear la fábrica de objetos.
     *
     * @param dfc
     * @return
     */
    public static synchronized DaoFactory createInstance(DaoConfig dfc) {

        // El método es synchronized, no pueden entrar dos hilos a la vez
        // Se asegura que sólo se crea una instancia de la DaoFactory
        if (instance == null) {
            instance = new DaoFactory(dfc);
        }
        return instance;
    }

    /**
     * 
     *
     * @return
     */
    public static DaoFactory getInstance() {
        return instance;
    }
}

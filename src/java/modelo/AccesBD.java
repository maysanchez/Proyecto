/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author JL
 */
public class AccesBD {
    
    public Connection conexion() throws SQLException{
        try {
            // Acceso al POOL DE CONEXIONES
            // Obtiene el contexto del Servidor
            
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            
            // Obtiene el DataSource del contexto
            
            DataSource ds = (DataSource) envCtx.lookup("jdbc/store");
            
            // Se obtiene una conexion al DataSource
            
            Connection con = ds.getConnection();
            return con;
        } catch (NamingException ex) {
            Logger.getLogger(AccesBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}

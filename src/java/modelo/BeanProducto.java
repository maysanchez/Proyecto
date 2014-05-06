/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author JL
 */
public class BeanProducto {
    
    private HashMap<Integer,Producto> productos = new HashMap<Integer, Producto>();
    private String mensaje = "";

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void add(String nombreP, String descriP, String fabriP, double precioP, int existP, String unitP, String codigoP, String descuentoP, String descriDP, String nombreArchivo) {
        Producto p = new Producto();
        p.setNombreP(nombreP);
        p.setDescriP(descriP);
        p.setFabriP(fabriP);
        p.setPrecioP(precioP);
        p.setExistP(existP);
        p.setUnitP(unitP);
        p.setCodigoP(codigoP);
        p.setDescuentoP(descuentoP);
        p.setDescriDP(descriDP);
        p.setNombreArchivo(nombreArchivo);
        /////////////////agregar fabricante y los demas campoos
        this.mensaje = "Se agrego exitosamente el producto " + nombreP;

        try {

            Connection con = new AccesBD().conexion();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
            Date date = new Date();

            if (con != null) {
                
                PreparedStatement ps = con.prepareStatement("INSERT INTO promocion values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, codigoP);
                ps.setString(2, descuentoP);
                ps.setString(3, descriDP);
                ps.setString(4, dateFormat2.format(date));
                ps.execute();
                ps = con.prepareStatement("INSERT INTO producto values(default,1,?,?,?,?,?,?,?,?,null,?)",Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, codigoP);
                ps.setString(2, nombreP);
                ps.setString(3, descriP);
                ps.setString(4, fabriP);
                ps.setDouble(5, precioP);
                ps.setInt(6, existP);
                ps.setString(7, unitP);
                ps.setString(8, dateFormat.format(date));
                ps.setString(9, nombreArchivo);
                ps.executeQuery();
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    p.setIdProducto(Integer.parseInt(rs.getString(1)));
                }
                con.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            mensaje = "Acción no realizada";
        }
    }
    
    /*public String getProductos(){
        
    }*/

}

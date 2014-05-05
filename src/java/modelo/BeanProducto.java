/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author JL
 */
public class BeanProducto {

    private String nombreP = "";
    private String descriP = "";
    private String fabriP = "";
    private double precioP = 0;
    private int existP = 0;
    private String unitP = "";
    private String codigoP = "";
    private String descuentoP = "";
    private String descriDP = "";
    private String nombreArchivo = "";
    private String mensaje = "";

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescriP() {
        return descriP;
    }

    public void setDescriP(String descriP) {
        this.descriP = descriP;
    }

    public String getFabriP() {
        return fabriP;
    }

    public void setFabriP(String fabriP) {
        this.fabriP = fabriP;
    }

    public double getPrecioP() {
        return precioP;
    }

    public void setPrecioP(double precioP) {
        this.precioP = precioP;
    }

    public int getExistP() {
        return existP;
    }

    public void setExistP(int existP) {
        this.existP = existP;
    }

    public String getUnitP() {
        return unitP;
    }

    public void setUnitP(String unitP) {
        this.unitP = unitP;
    }

    public String getCodigoP() {
        return codigoP;
    }

    public void setCodigoP(String codigoP) {
        this.codigoP = codigoP;
    }

    public String getDescuentoP() {
        return descuentoP;
    }

    public void setDescuentoP(String descuentoP) {
        this.descuentoP = descuentoP;
    }

    public String getDescriDP() {
        return descriDP;
    }

    public void setDescriDP(String descriDP) {
        this.descriDP = descriDP;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void add(String nombreP, String descriP, String fabriP, double precioP, int existP, String unitP, String codigoP, String descuentoP, String descriDP, String nombreArchivo) {
        this.nombreP = nombreP;
        this.descriP = descriP;
        /////////////////agregar fabricante y los demas campoos
        this.mensaje = "Se agrego exitosamente el producto " + nombreP;

        try {

            Connection con = new AccesBD().conexion();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();

            if (con != null) {
                PreparedStatement ps = con.prepareStatement("INSERT INTO producto values(default,1,null,?,?,?,?,?,?,?,null,?)");
                ps.setString(1, nombreP);
                ps.setString(2, descriP);
                ps.setString(3, fabriP);
                ps.setDouble(4, precioP);
                ps.setInt(5, existP);
                ps.setString(6, unitP);
                ps.setString(7, dateFormat.format(date));
                ps.setString(8, nombreArchivo);
                ps.execute();
                con.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            mensaje = "Acción no realizada";
        }
    }

}

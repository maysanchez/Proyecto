/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Jorge
 */
public class Producto {

    private int idProducto = 0;
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

    public Producto() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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

}

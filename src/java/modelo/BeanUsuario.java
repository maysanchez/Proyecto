/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JL
 */
public class BeanUsuario {
    
    private String nomPila;
    private String ApPat;
    private String ApMat;
    private String nomUsuario;
    private String password;
    private String Direccion;
    private int idDelegacion;
    private String cp;
    private int idRole;
    
    public String getNomPila() {
        return nomPila;
    }
    
    public void setNomPila(String nomPila) {
        this.nomPila = nomPila;
    }
    
    public String getApPat() {
        return ApPat;
    }
    
    public void setApPat(String ApPat) {
        this.ApPat = ApPat;
    }
    
    public String getApMat() {
        return ApMat;
    }
    
    public void setApMat(String ApMat) {
        this.ApMat = ApMat;
    }
    
    public String getNomUsuario() {
        return nomUsuario;
    }
    
    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getDireccion() {
        return Direccion;
    }
    
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
    public int getIdDelegacion() {
        return idDelegacion;
    }
    
    public void setIdDelegacion(int idDelegacion) {
        this.idDelegacion = idDelegacion;
    }
    
    public String getCp() {
        return cp;
    }
    
    public void setCp(String cp) {
        this.cp = cp;
    }
    
    public int getIdRole() {
        return idRole;
    }
    
    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }
    
    public String consultaVendedor(String nomUsuario) {
        this.nomUsuario = "jolmesV";
        String respuesta = "";
        System.out.println(respuesta);
        try {
            Connection con = new AccesBD().conexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM perfilVendedor WHERE nomUsuario LIKE ?");
            ps.setString(1, this.nomUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                respuesta += "<div class=\"col-md-6\">"
                        + "   <div class=\"form-group\">"
                        + "   <label for=\"nEmpresa\" class=\"col-sm-2 control-label\">Empresa</label>"
                        + "   <div class=\"col-sm-10\">"
                        + "   <input type=\"text\" class=\"form-control\" id=\"nEmpresa\" name=\"nEmpresa\" placeholder=\"Nombre de tu empresa\" value=\"" + rs.getString("nomEmpresa") + "\">"
                        + "   </div>"
                        + "   </div>"
                        + "   <div class=\"form-group\">"
                        + "   <label for=\"nombreP\" class=\"col-sm-2 control-label\">Nombre</label>"
                        + "   <div class=\"col-sm-10\">"
                        + "   <input type=\"text\" class=\"form-control\" id=\"nombreP\" name=\"nombreP\" placeholder=\"Tu nombre personal\" value=\"" + rs.getString("nomPila") + "\">"
                        + "   </div>"
                        + "   </div>"
                        + "   <div class=\"form-group\">"
                        + "   <label for=\"apPat\" class=\"col-sm-2 control-label\">Apellido Paterno</label>"
                        + "   <div class=\"col-sm-10\">"
                        + "   <input type=\"text\" class=\"form-control\" id=\"apPat\" name=\"apPat\" placeholder=\"Apellido Paterno\" value=\"" + rs.getString("ApPat") + "\">"
                        + "   </div>"
                        + "   </div>"
                        + "   <div class=\"form-group\">"
                        + "   <label for=\"apMat\" class=\"col-sm-2 control-label\">Apellido Materno</label>"
                        + "   <div class=\"col-sm-10\">"
                        + "   <input type=\"text\" class=\"form-control\" id=\"apMat\" name=\"apMat\" placeholder=\"Apellido Materno\" value=\"" + rs.getString("ApMat") + "\">"
                        + "   </div>"
                        + "   </div>"
                        + "   <div class=\"form-group\">"
                        + "   <label for=\"direccion\" class=\"col-sm-2 control-label\">Direcci&oacute;n</label>"
                        + "   <div class=\"col-sm-10\">"
                        + "   <input type=\"text\" class=\"form-control\" id=\"direccion\" name=\"direccion\" placeholder=\"Direcci&oacute;n\" value=\"" + rs.getString("direccion") + "\">"
                        + "   </div>"
                        + "   </div>"
                        + "   <div class=\"form-group\">"
                        + "   <label for=\"delegacion\" class=\"col-sm-2 control-label\">Delegaci&oacute;n</label>"
                        + "   <div class=\"col-sm-10\">"
                        + "   <select class=\"form-control\" name=\"delegacion\">";
                ps = con.prepareStatement("SELECT * FROM delegacion");
                ResultSet rs1 = ps.executeQuery();
                while (rs1.next()) {
                    String select = (rs1.getInt("idDelegacion") == rs.getInt("idDelegacion")) ? "selected" : " ";
                    respuesta += "   <option value=\"" + rs1.getString("idDelegacion") + "\" " + select + ">" + rs1.getString("Descripcion") + "</option>";
                }
                respuesta += "   </select>"
                        + "   </div>"
                        + "   </div>"
                        + "   <div class=\"form-group\">"
                        + "   <label for=\"cpU\" class=\"col-sm-2 control-label\">C.P.</label>"
                        + "   <div class=\"col-sm-10\">"
                        + "   <input type=\"text\" class=\"form-control\" id=\"cpU\" name=\"cpU\" placeholder=\"C&oacute;digo Postal\" value=\"" + rs.getString("cp") + "\">"
                        + "   </div>"
                        + "   </div>"
                        + "   </div>"
                        + "   <div class=\"col-md-4\">"
                        + "   <div class=\"form-group\">"
                        + "   <label for=\"user\" class=\"col-sm-2 control-label\">Usuario</label>"
                        + "   <div class=\"col-sm-10\">"
                        + "   <input id=\"user\" name=\"user\" type=\"text\" class=\"form-control\" placeholder=\"Nombre de usuario o nickname\" value=\""+rs.getString("nomUsuario")+"\" required autofocus>"
                        + "   </div>"
                        + "   </div>"
                        + "   <div class=\"form-group\">"
                        + "   <label for=\"pass\" class=\"col-sm-2 control-label\">Usuario</label>"
                        + "   <div class=\"col-sm-10\">"
                        + "   <input id=\"pass\" name=\"pass\" type=\"password\" class=\"form-control\" placeholder=\"Contrase&ntilde;a\" value=\""+rs.getString("password")+"\" required>"
                        + "   </div>"
                        + "   </div>"
                        + "   <div class=\"form-group\">"
                        + "   <div class=\"col-sm-10\">"
                        + "   <button class=\"btn btn-success\" name=\"submit\" type=\"submit\">Actualizar</button>"
                        + "   </div>"
                        + "   </div>"
                        + "   </div>";
            }
                con.close();
        } catch (SQLException ex) {
            respuesta += "<div class=\"alert alert-warning\"><p class=\"lead\">Tuvimos problemas con tu conexión a internet</p></div>";
            Logger.getLogger(BeanUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.err.println(respuesta);
        return respuesta;
    }
    
}

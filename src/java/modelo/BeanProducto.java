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
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JL
 */
public class BeanProducto {

    private HashMap<Integer, Producto> productos = new HashMap<Integer, Producto>();
    private String mensaje = "";
    private int idVendedor = 1;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
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
            DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();

            if (con != null) {
                PreparedStatement ps = null;
                System.out.println("-"+codigoP+"-");
                if (!"".equals(codigoP) && !"".equals(descuentoP) && !"".equals(descriDP)) {
                    System.out.println("ENTRO");
                    ps = con.prepareStatement("INSERT INTO promocion values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, codigoP);
                    ps.setString(2, descuentoP);
                    ps.setString(3, descriDP);
                    ps.setString(4, dateFormat2.format(date));
                    ps.execute();
                }
                ps = con.prepareStatement("INSERT INTO producto values(default,1,?,?,?,?,?,?,?,?,null,?)", Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, ("".equals(codigoP))?null:codigoP);
                ps.setString(2, nombreP);
                ps.setString(3, descriP);
                ps.setString(4, fabriP);
                ps.setDouble(5, precioP);
                ps.setInt(6, existP);
                ps.setString(7, unitP);
                ps.setString(8, dateFormat.format(date));
                ps.setString(9, nombreArchivo);
                ps.execute();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    p.setIdProducto(Integer.parseInt(rs.getString(1)));
                }
                con.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            mensaje = "Acción no realizada";
        }
    }
    
    public void update(String nombreP, String descriP, String fabriP, double precioP, int existP, String unitP, String codigoP, String descuentoP, String descriDP, String nombreArchivo){
		try{
			 Connection con = new AccesBD().conexion();
            
			if (con != null) {
                PreparedStatement ps = null;
				    ps = con.prepareStatement("SELECT * FROM producto WHERE codigoP = ?", Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, codigoP);
                    ps.execute();
                
					//ResultSet rs = ps.getResultSet();
					ResultSet rs = ps.getGeneratedKeys();
					
					if(rs.next()){ 
						//EL PRODUCTO EXISTE
						PreparedStatement ps1 = con.prepareStatement("update producto set nombreP = ?,descriP = ?,fabriP = ?,precioP = ?,existP = ?,unitP = ?, descuentoP = ?, descriDP = ?, nombreArchivo = ? where codigoP = ?");
						ps1.setString(10, codigoP);
						ps1.setString(1, nombreP);
						ps1.setString(2, descriP);
						ps1.setString(3, fabriP);
						ps1.setString(4, precioP);
						ps1.setString(5, existP);
						ps1.setString(6, unitP);
						ps1.setString(7, descuentoP);
						ps1.setString(8, descriDP);
						ps1.setString(9, nombreArchivo);
						ps1.execute();

						this.reset();
						this.codigoP = codigoP;
						this.nombreP = nombreP;
						this.descriP = descriP;
						this.fabriP = fabriP;
						this.precioP = precioP;
						this.existP = existP;
						this.unitP = unitP;
						this.descuentoP = descuentoP;
						this.descriDP = descriDP;
						this.nombreArchivo = nombreArchivo;
						this.mensaje = "Elproducto " + nombreP + "ha sido modificado exitosamente";
					}
					
					else
						mensaje = "No se ha encontrado el producto"; 
					
					con.close();
		
		}
		
		catch (Exception ex){
				ex.printStackTrace();
				mensaje = "Acción no realizada";
		}
	
	
	}
    
    

    public String read() {
        String respuesta = "";
        int productos = 0;
        try {
            Connection con = new AccesBD().conexion();
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) "
                    + "FROM producto WHERE idVendedor LIKE ?");
            ps.setInt(1, idVendedor);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                productos = rs.getInt(1);
            }
            if (productos > 0) {
                ps = con.prepareStatement("SELECT nombre,Descripcion,Fabricante,Precio,Existencia,imagen "
                        + "FROM producto WHERE idVendedor LIKE ?");
                ps.setInt(1, idVendedor);
                rs = ps.executeQuery();
                respuesta += "<div class=\"row placeholders\">"
                        + "<h1 class=\"text-center page-header\">Estos son tus productos registrados</h1>";
                while (rs.next()) {
                    respuesta += "<div class=\"col-md-6 col-md-3\">"
                            + "            <img src=\"./images/" + rs.getString("imagen") + "\" class=\"img-circle\" alt=\"" + rs.getString("Descripcion") + "\">"
                            + "            <h4>" + rs.getString("nombre") + "</h4>"
                            + "            <p><span class=\"text-muted\">Fabricante: " + rs.getString("Fabricante") + "</span><p>"
                            + "            <p><span class=\"text-muted\">Precio: " + rs.getString("Precio") + "</span><p>"
                            + "            <p><span class=\"text-muted\">Existencia: " + rs.getString("Existencia") + "</span><p>"
                            + "</div>";
                }
                respuesta += "</div>";
            } else {
                respuesta += "<div class=\"alert alert-info\"><p class=\"lead\">Por el momento no tienes productos registrados</p></div>";
            }
        } catch (SQLException ex) {
            respuesta += "<div class=\"alert alert-warning\"><p class=\"lead\">Tuvimos problemas con tu conexión a internet</p></div>";
            Logger.getLogger(BeanProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    /*public String getProductos(){
        
     }*/
}

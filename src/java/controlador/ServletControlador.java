/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.*;
import java.util.Date;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import modelo.BeanProducto;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author JL
 */
public class ServletControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{
            PrintWriter out = response.getWriter();
            HttpSession ses = request.getSession(true);
            BeanProducto producto = (BeanProducto) ses.getAttribute("producto");
            if(producto == null){
                producto = new BeanProducto();
                ses.setAttribute("producto", producto);
            }
            InputStream filecontent = null;
            List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            
            String nombreP = "";
            String descriP = "";
            String fabriP = "";
            double precioP = 0;
            int existP = 0;
            String unitP = "";
            String codigoP = "";
            String descuentoP = "";
            String descriDP = "";
            String accion = "";
            String nombreArchivo = "";
            for (FileItem item : items) {
                if (item.isFormField()) {
                    String fieldname = item.getFieldName();
                    String fieldvalue = item.getString();
                    if(fieldname.equals("nombreP"))
                        nombreP = fieldvalue;
                    if(fieldname.equals("descriP"))
                        descriP = fieldvalue;
                    if(fieldname.equals("fabriP"))
                        fabriP = fieldvalue;
                    if(fieldname.equals("precioP"))
                        precioP = Double.valueOf(fieldvalue);
                    if(fieldname.equals("existP"))
                        existP = Integer.parseInt(fieldvalue);
                    if(fieldname.equals("unitP"))
                        unitP = fieldvalue;
                    if(fieldname.equals("codigoP"))
                        codigoP = fieldvalue;
                    if(fieldname.equals("descuentoP"))
                        descuentoP = fieldvalue;
                    if(fieldname.equals("descriDP"))
                        descriDP = fieldvalue;
                    if(fieldname.equals("submit"))
                        accion = fieldvalue;
                } else {
                    nombreArchivo = new Date().getTime() + "_" + nombreP + "_" + FilenameUtils.getName(item.getName());
                    filecontent = item.getInputStream();
                }
            }

            if (accion.equals("Consulta")) {
                //producto.read(id, pass);
            } else if (accion.equals("Actualiza")) {
                //System.err.println(subirImagen(filecontent,nombreArchivo));
                //producto.update(id, descripcion, fabricante, precio, unidad, existencia, nombreArchivo, pass);
            } else if (accion.equals("Alta")) {
                System.err.println(subirImagen(filecontent,nombreArchivo));
                producto.add(nombreP, descriP, fabriP, precioP, existP, unitP, codigoP, descuentoP,descriDP,nombreArchivo);
            } else if (accion.equals("Baja")) {
                //producto.delete(id, pass);
            }

            response.sendRedirect("principal.jsp");
        }catch(FileUploadException fue){System.out.println(fue);}
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean subirImagen(InputStream archi, String filename) {
        ServletConfig  config = getServletConfig();
	ServletContext context = config.getServletContext();
        String path = context.getContextPath();
        System.out.println(path);
        System.out.println(context.getRealPath("/"));
        System.out.println(context.getRealPath("/") + "Imagenes\\"+ filename);
        /*try {
            File f = new File(context.getRealPath("/") + "Imagenes\\"+ filename);
            FileUtils.copyInputStreamToFile(archi, f);
        }
        catch(IOException e)
        {
            return false;
        }*/
        return true;
    }

}

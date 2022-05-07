
package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modeloDAO.ClienteDAO;


public class Controlador extends HttpServlet {

    private ClienteDAO dao;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        List<Cliente> Clientes = new ArrayList<>();
        switch (accion) {
            case "listar" -> {
                dao = new ClienteDAO();
                Clientes =dao.getClientes();
                request.setAttribute("Clientes", Clientes);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
             case "nuevo" -> request.getRequestDispatcher("add.jsp").forward(request, response);
             case "agregar" -> {
                 int r=0;
                 String nombre = request.getParameter("txtnombre");
                 String apellido = request.getParameter("txtapellido");
                 String telefono = request.getParameter("txttelefono");
                 String correo = request.getParameter("txtcorreo");
                 String status = request.getParameter("txtstatus");
                 Cliente c = new Cliente();
                 c.setNombre(nombre);
                 c.setApellido(apellido);
                 c.setTelefono(telefono);
                 c.setCorreo(correo);
                 c.setStatus(status);
                 r=dao.add(c);
                 if (r!=0) {
                     request.getRequestDispatcher("Controlador?accion=listar").forward(request, response);
                 }else 
                 {
                     request.getRequestDispatcher("mensaje.jsp").forward(request, response); 
                 }
            }
             case "editar" -> {
                 int id=Integer.valueOf(request.getParameter("id"));
                 Cliente cliente = dao.getid(id);
                 request.setAttribute("cliente", cliente);
                  request.getRequestDispatcher("editar.jsp").forward(request, response); 
             }
             case "actualizar" -> {
                 String nombre1 = request.getParameter("txtnombre");
                 String apellido1 = request.getParameter("txtapellido");
                 String telefono1 = request.getParameter("txttelefono");
                 String correo1 = request.getParameter("txtcorreo");
                 String status1 = request.getParameter("txtstatus");
                  int idcliente=Integer.valueOf(request.getParameter("txtid"));
                  Cliente cli = new Cliente(idcliente, nombre1, apellido1, telefono1, correo1, status1);
                  int respuesta =dao.update(cli);
                  if (respuesta!=0) {
                     request.getRequestDispatcher("Controlador?accion=listar").forward(request, response);
                 }else 
                 {
                     request.getRequestDispatcher("mensaje.jsp").forward(request, response); 
                 }
             }
             case "eliminar" ->{
                 int idclien=Integer.valueOf(request.getParameter("id"));
                 int res= dao.delete(idclien);
                  if (res!=0) {
                     request.getRequestDispatcher("Controlador?accion=listar").forward(request, response);
                 }else 
                 {
                     request.getRequestDispatcher("mensaje.jsp").forward(request, response); 
                 }
             }
            default -> throw new AssertionError();
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


package modeloDAO;

import config.Conexion;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class ClienteDAO implements interfaceClienteDAO{

    @Override
    public List<Cliente> getClientes() {
        
        List<Cliente> clientes = new ArrayList<>();
        String sql="select * from cliente";
        
        try {
            PreparedStatement ps= Conexion.Conectar().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
               Cliente c= new Cliente();
               c.setId(rs.getInt(1));
               c.setNombre(rs.getString(2));
               c.setApellido(rs.getString(3));
               c.setTelefono(rs.getString(4));
               c.setCorreo(rs.getString(5));
               c.setStatus(rs.getString(6));
               clientes.add(c);
            }
        } catch (SQLException e) {
            System.err.println("Error"+e);
        }
             
        return clientes;
    }
 

    @Override
    public Cliente getid(int id) {
         String sql="select * from cliente where Idcli ="+id;
          Cliente c= new Cliente();
         try {
            PreparedStatement ps= Conexion.Conectar().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
               c.setId(rs.getInt(1));
               c.setNombre(rs.getString(2));
               c.setApellido(rs.getString(3));
               c.setTelefono(rs.getString(4));
               c.setCorreo(rs.getString(5));
               c.setStatus(rs.getString(6));
          
            }
        } catch (SQLException e) {
            System.err.println("Error"+e);
        }
         return c;
    }

    @Override
    public int add(Cliente c) {
        int resultado =0;
         String sql="insert into cliente(Nombre,Apellido,Telefono,Correo,Status) values(?,?,?,?,?)";
         try {
            PreparedStatement ps= Conexion.Conectar().prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getTelefono());
            ps.setString(4, c.getCorreo());
            ps.setString(5, c.getStatus());
            resultado =ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error to add in DB");
        }
         return resultado;
    }

    @Override
    public int update(Cliente c) {
     int resultado =0;
         String sql="update cliente set Nombre=?,Apellido=?,Telefono=?,Correo=?,Status=? where IdCli =?";
         try {
            PreparedStatement ps= Conexion.Conectar().prepareStatement(sql);
             ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getTelefono());
            ps.setString(4, c.getCorreo());
            ps.setString(5, c.getStatus());
            ps.setInt(6, c.getId());
            resultado =ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error to update in DB");
        }
         return resultado;    
    }

    @Override
    public int delete(int id) {
         
        int resultado =0;
        String sql="delte from cliente where Idcli ="+id;
        try {
            PreparedStatement ps= Conexion.Conectar().prepareStatement(sql);
            resultado =ps.executeUpdate();
        } catch (SQLException e) {
        }
        return resultado;
    }
     
}

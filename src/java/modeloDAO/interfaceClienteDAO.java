
package modeloDAO;

import java.util.List;
import modelo.Cliente;


public interface interfaceClienteDAO {
     public List<Cliente>getClientes();
     public Cliente getid(int id);
     public int add(Cliente c);
     public int update(Cliente c);
     public int delete (int id);
}

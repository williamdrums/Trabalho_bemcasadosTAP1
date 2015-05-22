package Service;

import java.util.List;

import Classe.Cliente;
import DAO.ClienteDAO;

public class ClienteService {

	  private ClienteDAO clienteDAO;

	    //Contrutor
	    public ClienteService() {
	        clienteDAO = new ClienteDAO();
	    }

	    public void cadastrar(Cliente cliente) throws ServiceException {

	        if (cliente.getNome().isEmpty()) {
	            throw new ServiceException(" Campo nome é obrigatorio ");
	        }
	        if (cliente.getTelefone().isEmpty()) {
	            throw new ServiceException(" Campo telefone é obrigatorio ");
	        }
	         if (cliente.getEmail().isEmpty()) {
	            throw new ServiceException(" Campo Email é obrigatorio ");
	        }
	        clienteDAO.cadastrar(cliente);
	    }

	      public Cliente buscarPorId(Integer id) {
	        return clienteDAO.buscarPorId(id);
	    }

	    public void excluir(Cliente cliente) {
	       clienteDAO.excluir(cliente);
	    }

	     public List<Cliente> buscarTodos() {
	        return clienteDAO.buscarTodos();
	    }
}

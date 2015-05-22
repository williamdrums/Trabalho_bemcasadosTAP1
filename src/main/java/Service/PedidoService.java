package Service;

import java.util.List;

import Classe.Pedido;



/*public class PedidoService {

    private PedidoDAO pedidoDAO;

    public PedidoService() {
    	pedidoDAO = new PedidoDAO();
    }

    public void salvar(Pedido pedido) throws ServiceException  {

        if (pedido.getId() == null) {
           throw new ServiceException("Campo id é obrigatorio!") ;
        }

        if (pedido.getOrigemPedido().isEmpty()) {
            throw new ServiceException("Campo fone é obrigatório!");
        }
        if(pedido.getDataPedido() == null){
        	throw new ServiceException("Campo Data Pedido é obrigatório!");
        }
        if(pedido.getCliente() == null){
        	throw new ServiceException("Campo Cliente é obrigatório!");
        }
        if(pedido.getCerimonial().isEmpty()){
        	throw new ServiceException("Campo Cerimonial é obrigatório!");
        }
        if(pedido.getDataEvento() == null){
        	throw new ServiceException("Campo Data Evento é obrigatório!");
        }
        if(pedido.getTipoEvento() == null){
        	throw new ServiceException("Campo Tipo Evento é obrigatório!");
        }
        if(pedido.getHoraEvento().isEmpty()){
        	throw new ServiceException("Campo Hora Evento é obrigatório!");
        }
        if(pedido.getLocalEvento().isEmpty()){
        	throw new ServiceException("Campo Local Evento é obrigatório!");
        }
        if(pedido.getEnderecoEvento().isEmpty()){
        	throw new ServiceException("Campo Endereco Evento é obrigatório!");
        }
        /*if(pedido.getObs().isEmpty()){
        	throw new ServiceException("Campo obs é obrigatório!");
        }*/
        

      /*  pedidoDAO.salvar(pedido);

    }

    public void excluir(Integer id) {
        pedidoDAO.excluir(id);
    }

    public Pedido buscarPorId(Integer id) {
        return pedidoDAO.buscarPorId(id);
    }

    public List<Pedido> buscarTodos() {
            return pedidoDAO.buscarTodos();
    }
}*/

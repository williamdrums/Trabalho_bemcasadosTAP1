package ClasseTestes;

import Classe.Cliente;
import Classe.ItemPedido;
import Classe.Pedido;
import Classe.Produto;
import DAO.ClienteDAO;
import DAO.ItemPedidoDAO;

public class TesteClienteDAO {

	public static void main(String[] args) {

		/*
		 * Cliente cli = new Cliente(); cli.setNome("Drummer");
		 * cli.setTelefone("92773344"); cli.setEmail("www@hotmail.com");
		 * 
		 * ClienteDAO cliDAO = new ClienteDAO(); cliDAO.salvar(cli);
		 */

		// teste cliente
		//testBuscaPorId();
		//testCadastrarItemPedido();
		  testDeletarItemPedido();	
	}

	/*private static void testBuscaPorId() {
		ClienteDAO cliDAO = new ClienteDAO();
		Cliente res = cliDAO.buscarPorId(5);
		System.err.println(res.getNome() + " " + res.getTelefone() + " "
				+ res.getEmail() + " " + "Id do usuário " + res.getId());

	}*/

	private static void testCadastrarItemPedido() {

		ItemPedido itp = new ItemPedido();
		Produto prod = new Produto();
		itp.setIdItemPedido(1);
		itp.setQuantidade(4);
		itp.setValor(50.00);
        itp.setId(2);
		itp.setIdProduto(2);
        
        ItemPedidoDAO itpDao = new ItemPedidoDAO();
		itpDao.cadastrarItemPedido(itp);
		
	}
	
	private static void testDeletarItemPedido() {
        ItemPedido itp = new ItemPedido();

        itp.setIdItemPedido(2);

        ItemPedidoDAO itpDAO = new ItemPedidoDAO();
        itpDAO.excluirItemPedido(itp);

    }

}

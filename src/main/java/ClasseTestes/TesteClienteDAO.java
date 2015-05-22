package ClasseTestes;

import Classe.Cliente;
import DAO.ClienteDAO;

public class TesteClienteDAO {

	public static void main(String[] args) {
		
		/*Cliente cli = new Cliente();
		cli.setNome("Drummer");
		cli.setTelefone("92773344");
		cli.setEmail("www@hotmail.com");
		
		ClienteDAO cliDAO = new ClienteDAO();
		cliDAO.salvar(cli);*/

		
		
		//teste cliente		
		testBuscaPorId(); 

	}
    private static void testBuscaPorId() {
        ClienteDAO cliDAO = new ClienteDAO();
        Cliente res = cliDAO.buscarPorId(5);
        System.err.println(res.getNome() + " " + res.getTelefone() + " " + res.getEmail() + " " + "Id do usuário " + res.getId());

    }

}

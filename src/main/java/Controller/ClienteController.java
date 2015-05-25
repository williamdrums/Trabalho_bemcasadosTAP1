package Controller;

//chama a lista com todos clientes cadastrado
//http://localhost:8085/bemcasadosTAP1/ClienteController?acao=lis


//chama a tela de cadastro de cliente
//http://localhost:8085/bemcasadosTAP1/ClienteController?acao=cad

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Classe.Cliente;
import DAO.ClienteDAO;

@WebServlet({ "/clicontroller", "/ClienteServlet", "/ClienteController",
"/ClienteController.do" })
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
//		captura parametro da tela
		String acao = req.getParameter("acao");
		ClienteDAO cliDAO = new ClienteDAO();
		
		if(acao!=null && acao.equals("exc")){
//			captura parametro da tela
			String id = req.getParameter("id");
			Cliente cliente = new Cliente();
			cliente.setId(Integer.parseInt(id));
			cliDAO.excluir(cliente);
			
//			redireciona pagina apos a acao excluir para pagina anterior
			resp.sendRedirect("clicontroller?acao=lis");
		}
		
		if(acao!=null && acao.equals("alt")){
//			captura parametro da tela
			String id = req.getParameter("id");
			
//			busca objeto cliente no banco
			Cliente cliente = cliDAO.buscarPorId(Integer.parseInt(id));
			//seta o atributo  no request com objeto cliente
			req.setAttribute("cliente",cliente);
			
//			encaminha objeto usuario para tela
			RequestDispatcher saida = req.getRequestDispatcher("formcliente.jsp");
			saida.forward(req, resp);
			
		}
		
		if(acao!=null && acao.equals("cad")){
//			cria novo objeto cliente 
			Cliente cliente = new Cliente();
			cliente.setId(0);
			cliente.setNome("");
			cliente.setTelefone("");
			cliente.setEmail("");
			
			//seta o atributo  no request com objeto cliente
			req.setAttribute("cliente",cliente);
			
//			encaminha objeto usuario para tela
			RequestDispatcher saida = req.getRequestDispatcher("formcliente.jsp");
			saida.forward(req, resp);
			
		}
		
		
		

		if(acao!=null && acao.equals("lis")){
//			obeter a lista
		
        List<Cliente> listacli = cliDAO.buscarTodos();
//	saida para o browser
//	PrintWriter saida = resp.getWriter();
//	saida.print(lista);
	
	
//	engaveta no request a lista
	req.setAttribute("listacli", listacli);
	
	RequestDispatcher saida = req.getRequestDispatcher("listadeclientes.jsp");
	saida.forward(req, resp);
    }
}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		
//		recebe dados da tela html
		String nome = req.getParameter("nome");
		String telefone = req.getParameter("telefone");
		String email = req.getParameter("email");
		String id = req.getParameter("id");

		
//		cria objeto cliente e seta os valores vindo da tela
		Cliente cliente = new Cliente();
		
		if(id!=""){
			
			cliente.setId(Integer.parseInt(id));
		}
		cliente.setNome(nome);
		cliente.setTelefone(telefone);
		cliente.setEmail(email);
		

		
//      pede para o clienteDAO salvar os dados no banco de dados
		ClienteDAO cliDAO = new ClienteDAO();
		cliDAO.salvar(cliente);

//		saida para o browser
		PrintWriter saida = resp.getWriter();
		saida.print("Salvo com sucesso!!!");
		
	} 
}

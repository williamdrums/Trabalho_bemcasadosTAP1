package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Classe.Cliente;
import Classe.Pedido;
import Classe.Produto;
import DAO.ClienteDAO;
import DAO.PedidoDAO;
import DAO.ProdutoDAO;

@WebServlet({ "/pedcontroller", "/PedidoServlet", "/PedidoController",
		"/PedidoController.do" })
public class PedidoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ClienteDAO cliDAO = new ClienteDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// captura parametro da tela
		String acao = req.getParameter("acao");

//		recebe o id do combo selecionado que deve ser utilizado para buscar o cliente por id
		String idclienteTela = req.getParameter("idCliente");
		
		
		
		PedidoDAO pedDAO = new PedidoDAO();

		if (acao != null && acao.equals("exc")) {
			// captura parametro da tela
			String id = req.getParameter("id");
			Pedido pedido = new Pedido();
			pedido.setId(Integer.parseInt(id));
			pedDAO.excluir(pedido);
			// resp.getWriter()
			// .print("<script> window.alert('Excluido Sucesso!'); location.href='ProdutoController?acao=lis'; </script>");

			// redireciona pagina apos a acao excluir para pagina anterior
			resp.sendRedirect("pedcontroller?acao=lis");
		}

		if (acao != null && acao.equals("cad")) {

			// cria novo objeto pedido
			Pedido pedido = new Pedido();
			pedido.setId(0);
			pedido.setOrigemPedido("");
			pedido.setDataPedido(null);
			pedido.setCliente(null);
			pedido.setCerimonial(null);
			pedido.setDataEvento(null);
			pedido.setTipoEvento(null);
			pedido.setHoraEvento("");
			pedido.setIndicacao("");
			pedido.setLocalEvento("");
			pedido.setEnderecoEvento("");
			pedido.setObs("");
			pedido.setItens(null);

			// seta o atributo no request com objeto pedido
			req.setAttribute("pedidocli", pedido);

			// encaminha objeto pedido para tela
     		RequestDispatcher saida = req.getRequestDispatcher("pedido.jsp");
			saida.forward(req, resp);

		}

		if (acao != null && acao.equals("lis")) {
			// obeter a lista

          List<Pedido> lista = pedDAO.buscarTodos();

			// engaveta no request a lista
			req.setAttribute("lista", lista);

			RequestDispatcher saida = req
					.getRequestDispatcher("pedidos.jsp");
			saida.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// recebe dados da tela html
		String id = req.getParameter("id");
		String origemPedido = req.getParameter("origempedido");
		String dataPedido = req.getParameter("datapedido");
		String cliente = req.getParameter("cliente");
		String cerimonial = req.getParameter("cerimonial");
		String dataEvento = req.getParameter("dataevento");
		String tipoEvento = req.getParameter("tipoevento");
		String horaEvento = req.getParameter("horaevento");
		String indicacao = req.getParameter("indicacao");
		String localEvento = req.getParameter("localevento");
		String enderecoEvento = req.getParameter("enderecoevento");
		String obs = req.getParameter("obs");
		String itensLista = req.getParameter("itenslista");

		// cria objeto produto e seta os valores vindo da tela
		Pedido pedido = new Pedido();

		if (id != "") {

			pedido.setId(Integer.parseInt(id));
		}
		pedido.setOrigemPedido(origemPedido);
		
		//converte string em date
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
//		Date data = (Date) formatter.parse(dataPedido); 
//		pedido.setDataPedido(data);
		
//		cria um novo cliente ,converte o id de cliente que vem com id da tela e passa pa idCli,depois e convertido e passado o idCli no buscarPorId
		Cliente clienteRelacionado = new Cliente();
		Integer idCli = Integer.parseInt(cliente);
		clienteRelacionado = cliDAO.buscarPorId(idCli);
		
		pedido.setCliente(clienteRelacionado);
		

		// pede para o prodDAO salvar os dados no banco de dados
		PedidoDAO pedDAO = new PedidoDAO();
        pedDAO.salvar(pedido);

		// saida para o browser
		PrintWriter saida = resp.getWriter();
		saida.print("Produto salvo com sucesso!!!");

	}
}

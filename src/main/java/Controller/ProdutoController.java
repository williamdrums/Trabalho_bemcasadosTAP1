package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Classe.Produto;
import DAO.ProdutoDAO;


@WebServlet({ "/prodcontroller", "/ProdutoServlet", "/ProdutoController",
"/ProdutoController.do" })
public class ProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
		

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		
//			captura parametro da tela
			String acao = req.getParameter("acao");
			ProdutoDAO prodDAO = new ProdutoDAO();
			
			if(acao!=null && acao.equals("exc")){
//				captura parametro da tela
				String id = req.getParameter("id");
				Produto produto= new Produto();
				produto.setId(Integer.parseInt(id));
				prodDAO.excluir(produto);
//				resp.getWriter()
//				.print("<script> window.alert('Excluido Sucesso!'); location.href='ProdutoController?acao=lis'; </script>");
				
//				redireciona pagina apos a acao excluir para pagina anterior
				resp.sendRedirect("prodcontroller?acao=lis");
			}
			
			if(acao!=null && acao.equals("alt")){
//				captura parametro da tela
				String id = req.getParameter("id");
				
//				busca objeto cliente no banco
				Produto produto = prodDAO.buscarPorId(Integer.parseInt(id));
				//seta o atributo  no request com objeto cliente
				req.setAttribute("produto",produto);
				
//				encaminha objeto produto para tela
				RequestDispatcher saida = req.getRequestDispatcher("produtos.jsp");
				saida.forward(req, resp);
				
//				redireciona pagina apos a acao excluir para pagina anterior
				resp.sendRedirect("prodcontroller?acao=lis");
				
			}
			
			if(acao!=null && acao.equals("cad")){
//				cria novo objeto produto 
				Produto produto = new Produto();
				produto.setId(0);
				produto.setDescricao("");
				produto.setValor("");
				
				//seta o atributo  no request com objeto produto
				req.setAttribute("produto",produto);
				
//				encaminha objeto produto para tela
				RequestDispatcher saida = req.getRequestDispatcher("produtos.jsp");
				saida.forward(req, resp);
				
			}
			
			
			

			if(acao!=null && acao.equals("lis")){
//				obeter a lista
			
	        List<Produto> lista = prodDAO.buscarTodos();

		
		
//		engaveta no request a lista
		req.setAttribute("lista", lista);
		
		RequestDispatcher saida = req.getRequestDispatcher("listadeprodutos.jsp");
		saida.forward(req, resp);
	    }
	}
		
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			
//			recebe dados da tela html
			String descricao = req.getParameter("descricao");
			String valor = req.getParameter("valor");
			String id = req.getParameter("id");

			
//			cria objeto produto e seta os valores vindo da tela
			Produto produto = new Produto();
			
			if(id!=""){
				
				produto.setId(Integer.parseInt(id));
			}
			produto.setDescricao(descricao);
			produto.setValor(valor);
			
			

			
//	      pede para o prodDAO salvar os dados no banco de dados
			ProdutoDAO prodDAO = new ProdutoDAO();
			prodDAO.salvar(produto);

//			saida para o browser
			PrintWriter saida = resp.getWriter();
			saida.print("Produto salvo com sucesso!!!");
			
		} 

}

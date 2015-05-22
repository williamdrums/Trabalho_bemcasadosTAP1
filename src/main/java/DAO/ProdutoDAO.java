package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Classe.Produto;
import ConexaoBD.ConexaoUtil;

public class ProdutoDAO {

	
	private Connection con = ConexaoUtil.getConnection();

	public void cadastrar(Produto produto){
		
		String sql = "INSERT INTO PRODUTO (descricao,valor)values(?,?)";
		
//		constroe o PreparedStatement com SQL
		try {
			PreparedStatement preparadorSQL = con.prepareStatement(sql);
			preparadorSQL.setString(1, produto.getDescricao());
			preparadorSQL.setString(2, produto.getValor());
			
			
			preparadorSQL.execute();
			preparadorSQL.close();
			
			System.out.println("Produto cadastrado com sucesso!");
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void salvar(Produto produto){
		if(produto.getId() !=null && produto.getId()!=0){
			alterar(produto);
		}else{
			cadastrar(produto);
		}
	}
	
	 public Produto buscarPorId(Integer id) {

	        String sql = "SELECT * FROM produto WHERE idproduto=?";
	        try {

	            //prepara e executa o sql
	            PreparedStatement preparadorSQL = con.prepareStatement(sql);
	            preparadorSQL.setInt(1, id);

	            //Armazenando Resultado da consulta
	            ResultSet resultado = preparadorSQL.executeQuery();
	            if (resultado.next()) {

	                Produto prod = new Produto();

	                //Atribuindo dados do resultado no objeto produto
	               prod.setId(id);
	               prod.setDescricao(resultado.getString("descricao"));
	               prod.setValor(resultado.getString("valor"));
	                
	                preparadorSQL.close();
	                return prod;
	            } else {
	                return null;
	            }
	        } catch (SQLException ex) {

	            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
	            return null;
	        }

	    }

	    public void excluir(Produto produto) {

	        String sql = "DELETE FROM produto WHERE idproduto=?";

	        try {
	            PreparedStatement preparadorSQL = con.prepareStatement(sql);
	            preparadorSQL.setInt(1, produto.getId());

	            preparadorSQL.execute();
	            preparadorSQL.close();
	        } catch (SQLException ex) {
//	            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
	        	ex.printStackTrace();
	        }
	    }

	    public List<Produto> buscarTodos() {
	        String sql = "SELECT * FROM produto ORDER BY idproduto";
	        List<Produto> lista = new ArrayList<>();
	        try {
	            PreparedStatement preparadorSQL = con.prepareStatement(sql);

	            //Armazenando Resultado da consulta
	            ResultSet resultado = preparadorSQL.executeQuery();

	            while (resultado.next()) {
	                //Instancia de produto
	                Produto prod = new Produto();

	                //Atribuindo dados do resultado no objeto produto
	                
	                prod.setId(resultado.getInt("idproduto"));
	                prod.setDescricao(resultado.getString("descricao"));
	                prod.setValor(resultado.getString("valor"));
	                //Adicionando produto na lista
	                lista.add(prod);
	            }

	            preparadorSQL.close();
	            return lista;
	        } catch (SQLException ex) {

	            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
	            return null;
	        }

	    }

//	    Método que irá alterar os dados
	    public void alterar(Produto produto) {

	        String sql = "UPDATE produto SET descricao = ?, valor= ?  WHERE idproduto = ? ";

	        // constroi preparedstatement com o sql
	        try {
	            PreparedStatement preparador = con.prepareStatement(sql);
	            preparador.setString(1, produto.getDescricao());
	            preparador.setString(2, produto.getValor());
	            preparador.setInt(3, produto.getId());

	            preparador.execute();
	            preparador.close();

	            System.out.println("Produto alterado com sucesso ! ");

	        } catch (SQLException e) {
	            
	            e.printStackTrace();
	        }

	    }

}

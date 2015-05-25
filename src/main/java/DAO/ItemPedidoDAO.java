package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Classe.ItemPedido;
import ConexaoBD.ConexaoUtil;

public class ItemPedidoDAO {
	
	private Connection con = ConexaoUtil.getConnection();

	public void cadastrarItemPedido(ItemPedido itemped){
		
		String sql = "INSERT INTO ItemPedido (id,quantidade,valor,iditempedido,idproduto) values(?,?,?,?,?)";
		
//		constroe o PreparedStatement com SQL
		try {
			PreparedStatement preparadorSQL = con.prepareStatement(sql);
			
			preparadorSQL.setInt(1, itemped.getIdItemPedido());
			preparadorSQL.setInt(2, itemped.getQuantidade());
			preparadorSQL.setDouble(3, itemped.getValor());
			preparadorSQL.setInt(4, itemped.getId());
			preparadorSQL.setInt(5, itemped.getIdProduto());
			//preparadorSQL.setObject(4, itemped.getPedido());
			//preparadorSQL.setObject(5, itemped.getProduto());
			
			preparadorSQL.execute();
			preparadorSQL.close();
			
			System.out.println("Cadastrado com sucesso!");
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	/*public void salvar(ItemPedido itemped){
		if(itemped.getId() !=null && itemped.getId()!=0){
			alterar(itemped);
		}else{
			cadastrarItemPedido(itemped);
		}
	}*/
	
	 //public ItemPedido buscarPorId(Integer id) {

	   //     String sql = "SELECT * FROM itempedido WHERE iditempedido=?";
	     //   try {

	            //prepara e executa o sql
	       //     PreparedStatement preparadorSQL = con.prepareStatement(sql);
	         //   preparadorSQL.setInt(1, id);

	            //Armazenando Resultado da consulta
	           // ResultSet resultado = preparadorSQL.executeQuery();
	            //if (resultado.next()) {

	                
	            	//ItemPedido itp = new ItemPedido();	
	            	
	                //Atribuindo dados do resultado no objeto cliente
	                /*itp.setIdItemPedido(resultado.getInt(itp.getIdItemPedido()));
	                itp.setIdProduto(resultado.getInt(itp.getIdProduto()));
	                itp.setQuantidade(resultado.getInt(itp.getQuantidade()));
	                itp.setValor(resultado.getDouble("valor"));
	                
	                preparadorSQL.close();
	                return itp;
	            } else {
	                return null;
	            }
	        } catch (SQLException ex) {

	            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
	            return null;
	        }

	    }*/

	    public void excluirItemPedido(ItemPedido itp) {

	        String sql = "DELETE FROM itempedido WHERE iditempedido=?";

	        try {
	            PreparedStatement preparadorSQL = con.prepareStatement(sql);
	            preparadorSQL.setInt(1, itp.getId());

	            preparadorSQL.execute();
	            preparadorSQL.close();
	        } catch (SQLException ex) {
//	            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
	        	ex.printStackTrace();
	        }
	    }

	    public List<ItemPedido> buscarTodos() {
	        String sql = "SELECT * FROM itempedido ORDER BY iditempedido";
	        List<ItemPedido> lista = new ArrayList<>();
	        try {
	            PreparedStatement preparadorSQL = con.prepareStatement(sql);

	            //Armazenando Resultado da consulta
	            ResultSet resultado = preparadorSQL.executeQuery();

	            while (resultado.next()) {
	                //Instancia de cliente
	                ItemPedido itp= new ItemPedido();

	                //Atribuindo dados do resultado no objeto cliente
	                itp.setId(resultado.getInt("iditempedido"));
	                itp.setId(resultado.getInt("id"));
	                itp.setIdProduto(resultado.getInt("idproduto"));
	                itp.setQuantidade(resultado.getInt("quantidade"));
	                itp.setValor(resultado.getDouble("valor"));
	                
	                //Adicionando cliente na lista
	                lista.add(itp);
	            }

	            preparadorSQL.close();
	            return lista;
	        } catch (SQLException ex) {

	            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
	            return null;
	        }

	    }

//	    Método que irá alterar os dados
	   /* public void alterar(Cliente cliente) {

	        String sql = "UPDATE CLIENTE SET nome = ?, telefone= ? ,email= ? WHERE idcliente = ? ";

	        // constroi preparedstatement com o sql
	        try {
	            PreparedStatement preparador = con.prepareStatement(sql);
	            preparador.setString(1, cliente.getNome());
	            preparador.setString(2, cliente.getTelefone());
	            preparador.setString(3, cliente.getEmail());
	            preparador.setInt(4, cliente.getId());

	            preparador.execute();
	            preparador.close();

	            System.out.println("Alterado com sucesso ! ");

	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	    }*/


}

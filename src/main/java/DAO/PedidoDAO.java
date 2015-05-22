package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

import Classe.Cliente;
import Classe.Pedido;
import Classe.TipoEvento;
import ConexaoBD.ConexaoUtil;

public class PedidoDAO {

	ClienteDAO clienteDAO = new ClienteDAO();
    TipoEventoDAO eventoDAO = new TipoEventoDAO();
	   Connection con;

	    public PedidoDAO() {
	        con = ConexaoUtil.getConnection();
	    }
	    
	    public void salvar(Pedido pedido){
	    	if(pedido.getId()==null){
	    		cadastrar(pedido);
	    	}else{
//	    		alterar(pedido);
	    	}
	    }
	    
	    public void cadastrar(Pedido pedido){
	    	
	    	String sql = "INSERT INTO Pedido(origemPedido,dataPedido,idcliente,"
	                + "cerimonial,dataEvento,idtipoEvento,horaEvento,"
	                + "indicacao,localEvento,enderecoEvento,obs)"
	                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	    	

	        try {
//	        	prepara o sql para inserir os dados
	            PreparedStatement preparadorSQL = con.prepareStatement(sql);
	            
	    
	            
	            preparadorSQL.setString(1, pedido.getOrigemPedido());
	            preparadorSQL.setDate(2, new Date(pedido.getDataPedido().getTime()));
	            preparadorSQL.setInt(3,pedido.getCliente().getId());
	            preparadorSQL.setString(4, pedido.getCerimonial());
	            preparadorSQL.setDate(5, new Date(pedido.getDataEvento().getTime()));
	            preparadorSQL.setInt(6, pedido.getTipoEvento().getId());
	            preparadorSQL.setString(7, pedido.getHoraEvento());
	            preparadorSQL.setString(8, pedido.getIndicacao());
	            preparadorSQL.setString(9, pedido.getLocalEvento());
	            preparadorSQL.setString(10, pedido.getEnderecoEvento());
	            preparadorSQL.setString(11, pedido.getObs());
	            
//	            ItemPedidoController ip = new ItemPedidoController();
	           // ip.salvar((ItemPedido) pedido.getItens());
	            preparadorSQL.execute();
	            preparadorSQL.close();

	        } catch (SQLException ex) {
	            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

	   

	}


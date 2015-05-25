package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Classe.Cliente;
import Classe.ItemPedido;
import Classe.Pedido;
import Classe.TipoEvento;
import ConexaoBD.ConexaoUtil;

public class PedidoDAO {

	Connection con;

	public PedidoDAO() {
		con = ConexaoUtil.getConnection();
	}

	ClienteDAO clienteDAO = new ClienteDAO();
	TipoEventoDAO eventoDAO = new TipoEventoDAO();

	public void cadastrar(Pedido pedido) throws ParseException {

		String sql = "INSERT INTO pedido(\n"
				+ "            id, origempedido, datapedido, cerimonial, dataevento, horaevento, \n"
				+ "            indicacao, endereco, observacao, localevento, idtipoevento, idcliente)\n"
				+ "    VALUES (?, ?, ?, ?, ?, ?, \n"
				+ "            ?, ?, ?, ?, ?, ?)";

		// constroi preparedstatement com o sql
		try {
			PreparedStatement preparador = con.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);

			preparador.setInt(1, pedido.getId());
			preparador.setString(2, pedido.getOrigemPedido());
			preparador.setDate(3, new java.sql.Date(pedido.getDataPedido()
					.getTime()));
			preparador.setString(4, pedido.getCerimonial());
			preparador.setDate(5, new java.sql.Date(pedido.getDataEvento()
					.getTime()));
			preparador.setString(6, pedido.getHoraEvento());
			preparador.setString(7, pedido.getIndicacao());
			preparador.setString(8, pedido.getEnderecoEvento());
			preparador.setString(9, pedido.getObs());
			preparador.setString(10, pedido.getLocalEvento());
			preparador.setInt(12, pedido.getTipoEvento().getId());
			preparador.setInt(11, pedido.getCliente().getId());

			preparador.execute();
			ResultSet res = preparador.getGeneratedKeys();
			int key = 0;
			while (res.next()) {
				key = res.getInt(1);
			}
			preparador.close();

			System.out.println("Cadastrado com sucesso ! ");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void excluir(Pedido entidade) {

		String sql = "DELETE FROM pedido WHERE id=?";

		try {
			PreparedStatement preparadorSQL = con.prepareStatement(sql);
			preparadorSQL.setInt(1, entidade.getId());

			preparadorSQL.execute();
			preparadorSQL.close();
		} catch (SQLException ex) {
			Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE,
					null, ex);
			ex.printStackTrace();
		}
	}

	public Pedido buscarPorId(Integer id) {

		String sql = "SELECT * FROM pedido WHERE id=?";
		try {

			// prepara e executa o sql
			PreparedStatement preparadorSQL = con.prepareStatement(sql);
			preparadorSQL.setInt(1, id);

			// Armazenando Resultado da consulta
			ResultSet resultado = preparadorSQL.executeQuery();
			if (resultado.next()) {

				Pedido ped = new Pedido();
				Cliente cliRelacionado = clienteDAO.buscarPorId(resultado.getInt("idcliente"));
				TipoEvento eventoRelacionado = eventoDAO
						.buscarPorIdEvento(resultado.getInt("idtipoevento"));

				// Atribuindo dados do resultado no objeto cliente
				ped.setId(resultado.getInt("id"));
				ped.setOrigemPedido("origempedido");
				ped.setDataPedido(resultado.getDate("datapedido"));
				// ped.setCliente(buscarPorId(resultado.getInt("idcliente")));
				ped.setCliente(cliRelacionado);
				ped.setCerimonial(resultado.getString("cerimonial"));
				ped.setDataEvento(resultado.getDate("dataevento"));
				// ped.setTipoEvento(buscarPorIdEvento(resultado.getInt("idtipoevento")));
				ped.setTipoEvento(eventoRelacionado);
				ped.setHoraEvento(resultado.getString("horaevento"));
				ped.setIndicacao(resultado.getString("indicacao"));
				ped.setLocalEvento(resultado.getString("localevento"));
				ped.setObs(resultado.getString("obs"));
				ped.setItens((List<ItemPedido>) resultado);
				preparadorSQL.close();
				return ped;
			} else {
				return null;
			}
		} catch (SQLException ex) {

			Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE,
					null, ex);
			return null;
		}

	}

	public void salvar(Pedido pedido) {
		if (pedido.getId() != null && pedido.getId() != 0) {

			try {
				cadastrar(pedido);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public List<Pedido> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

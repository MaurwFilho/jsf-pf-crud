package br.edu.uniandrade.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.uniandrade.entidade.Pedido;
import br.edu.uniandrade.util.FabricaConexao;

public class PedidoDAO {
	
	public void salvar(Pedido pedido){
		try {
			Connection conexao = FabricaConexao.getConexao();
			PreparedStatement ps;
			if (pedido.getId() == null) {
				ps = conexao.prepareStatement("insert into pedido (nome,quantidade) values (?,?)");
			} else {
				ps = conexao.prepareStatement("update pedido set nome=?, quantidade=? where id=?");
				ps.setInt(3, pedido.getId());
			}
			ps.setString(1, pedido.getNome());
			ps.setInt(2, pedido.getQuantidade());
			ps.execute();
			FabricaConexao.fecharConexao();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deletar(Integer idPedido){
		try {
			Connection conexao = FabricaConexao.getConexao();
			PreparedStatement ps = conexao.prepareStatement("delete from pedido where id_pedido=?");
			ps.setInt(1, idPedido);
			ps.execute();
			FabricaConexao.fecharConexao();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Pedido> buscar(){
		try {
			Connection conexao = FabricaConexao.getConexao();
			PreparedStatement ps = conexao.prepareStatement("select * from pedido");
			ResultSet rs = ps.executeQuery();
			List<Pedido> pedidos = new ArrayList<Pedido>();
			while(rs.next()){
				Pedido pedido = new Pedido();
				pedido.setId(rs.getInt("id_pedido"));
				pedido.setNome(rs.getString("nome"));
				pedido.setQuantidade(rs.getInt("quantidade"));
				pedidos.add(pedido);
			}
			FabricaConexao.fecharConexao();
			ps.close();
			rs.close();
			return pedidos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}

package br.edu.uniandrade.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.uniandrade.entidade.Produto;
import br.edu.uniandrade.util.FabricaConexao;

public class ProdutoDAO {

	public void salvar(Produto produto) {
		try {
			Connection conexao = FabricaConexao.getConexao();
			PreparedStatement ps;
			if (produto.getId() == null) {
				ps = conexao.prepareStatement("insert into produto (nome,descricao,preco) values (?,?,?)");
			} else {
				ps = conexao.prepareStatement("update produto set nome=?, descricao=?, preco=? where id=?");
				ps.setInt(4, produto.getId());
			}
			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getDescricao());
			ps.setFloat(3, produto.getPreco());
			ps.execute();
			FabricaConexao.fecharConexao();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deletar(Integer idProduto) {
		try {
			Connection conexao = FabricaConexao.getConexao();
			PreparedStatement ps = conexao.prepareStatement("delete from produto where id=?");
			ps.setInt(1, idProduto);
			ps.execute();
			FabricaConexao.fecharConexao();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Produto> buscar() {
		try {
			Connection conexao = FabricaConexao.getConexao();
			PreparedStatement ps = conexao.prepareStatement("select * from produto");
			ResultSet resultSet = ps.executeQuery();
			List<Produto> produtos = new ArrayList<Produto>();
			while (resultSet.next()) {
				Produto produto = new Produto();
				produto.setId(resultSet.getInt("id"));
				produto.setNome(resultSet.getString("nome"));
				produto.setDescricao(resultSet.getString("descricao"));
				produto.setPreco(resultSet.getFloat("preco"));
				produtos.add(produto);
			}
			FabricaConexao.fecharConexao();
			ps.close();
			resultSet.close();
			return produtos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}

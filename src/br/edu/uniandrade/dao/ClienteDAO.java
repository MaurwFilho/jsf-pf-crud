package br.edu.uniandrade.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import com.sun.org.glassfish.external.probe.provider.annotations.ProbeParam;

import br.edu.uniandrade.entidade.Cliente;
import br.edu.uniandrade.util.FabricaConexao;

public class ClienteDAO {
	
	public boolean salvar(Cliente cliente) {
		try {
			Connection conexao = FabricaConexao.getConexao();
			PreparedStatement ps = conexao.prepareStatement("insert into cliente (usuario,senha,nome) values (?,?,?)");
			ps.setString(1, cliente.getUsuario());
			ps.setString(2, DigestUtils.md5Hex(cliente.getSenha()));
			ps.setString(3, cliente.getNome());
			ps.execute();
			FabricaConexao.fecharConexao();
			ps.close();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}
	}

	public boolean verificar(Cliente cliente) {
		try {
			Connection conexao = FabricaConexao.getConexao();
			PreparedStatement ps = conexao.prepareStatement("select * from cliente where usuario=? and senha=?");
			ps.setString(1, cliente.getUsuario());
			ps.setString(2, DigestUtils.md5Hex(cliente.getSenha()));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				boolean a = rs.getString("usuario").equals(cliente.getUsuario());
				if (a) {
					return true;
				}
			}
			FabricaConexao.fecharConexao();
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}

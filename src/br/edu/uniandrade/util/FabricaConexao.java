package br.edu.uniandrade.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

	private static Connection conexao;
	private static final String URL_CONEXAO = "jdbc:postgresql://localhost/sistema-produtos";
	private static final String USUARIO = "postgres";
	private static final String SENHA = "123456";

	public static Connection getConexao() {
		if (conexao == null) {
			try {
				Class.forName("org.postgresql.Driver");
				conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return conexao;
	}

	public static void fecharConexao() {
		if (conexao != null) {
			try {
				conexao.close();
				conexao = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

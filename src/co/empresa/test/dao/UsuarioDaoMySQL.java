package co.empresa.test.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.empresa.test.modelo.Usuario;
import co.empresa.test.util.ConexionMySQL;

public class UsuarioDaoMySQL implements UsuarioDao {
	private ConexionMySQL conexion;
	private static final String INSERT_USUARIO_SQL = "INSERT INTO usuario(nombre,email,pais) VALUE(?,?,?);";
	private static final String DELETE_USUARIO_SQL = "DELETE FROM usuario WHERE id = ?;";
	private static final String UPDATE_USUARIO_SQL = "UPDATE usuario SET nombre = ? ,email = ?,pais= ? WHERE id =?;";
	private static final String SELECT_USUARIO_BY_ID = "SELECT * FROM usuario WHERE id=?;";
	private static final String SELECT_ALL_USUARIOS = "SELECT * FROM usuario; ";
	
	public UsuarioDaoMySQL() {
		this.conexion = ConexionMySQL.getConexion();
	}
	
	public void insert (Usuario usuario) throws SQLException{
		System.out.print("Endap");
		System.out.println(usuario);
		try {
			System.out.println("1");
			PreparedStatement preparedStatement = (PreparedStatement)conexion.setPreparedStatement(INSERT_USUARIO_SQL);
			System.out.println("2");
			preparedStatement.setString(1, usuario.getNombre());
			System.out.println("3");
			preparedStatement.setString(2, usuario.getEmail());
			System.out.println("4");
			preparedStatement.setString(3, usuario.getPais());
			System.out.println("5");
			conexion.execute();
			System.out.println("6");
		}catch(SQLException e) {
			System.out.println("EROR");
			e.printStackTrace();	
		} 
	}
	
	public void delete (int id) throws SQLException{
		try {
			PreparedStatement preparedStatement = (PreparedStatement)conexion.setPreparedStatement(DELETE_USUARIO_SQL);
			preparedStatement.setInt(1, id);
			conexion.execute();
		}catch(SQLException e ) {
			
		}
		
	}
	
	public void update (Usuario usuario) throws SQLException  {
		try {
			PreparedStatement preparedStatement = (PreparedStatement)conexion.setPreparedStatement(UPDATE_USUARIO_SQL);
			preparedStatement.setString(1, usuario.getNombre());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getPais());
			preparedStatement.setInt(4,usuario.getId());			
			conexion.execute();
		}catch(SQLException e) {
			
		}
	}
	
	public List<Usuario> selectAll() {
		List<Usuario> usuarios = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement)conexion.setPreparedStatement(SELECT_ALL_USUARIOS);
			
			ResultSet rs = conexion.query();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String pais = rs.getString("pais");
				usuarios.add(new Usuario(id,nombre,email,pais));
			}
			
		}catch(SQLException e) {
			
		}
		return usuarios;
		
	}
	
	
	public Usuario select(int id) {
		Usuario usuario=null;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement)conexion.setPreparedStatement(SELECT_USUARIO_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = conexion.query();
			while(rs.next()) {
				
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String pais = rs.getString("pais");
				usuario  = new Usuario(id,nombre,email,pais);
			}
			
		}catch(SQLException e) {
			
		}
		return usuario;
		
	}
	
	
	
	

}

package model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 
 * @author Corentin Devrouete
 * @version 1.2
 */
public class DBGame {

	private DBConnection connection;
	/**
	 * Initialize the game database
	 */
	public DBGame(){
		this.connection = new DBConnection();
	}
	
	/**
	 * Execute the SQL queries
	 * @param sql
	 * 		it's a sql query
	 * @param id
	 * 		sets the id
	 * @return the result of the query
	 */
	public ResultSet procedure(String sql, int id){
		try{
			System.out.println("hi");
			CallableStatement call = connection.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			System.out.println("hello");
			return call.getResultSet();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("coucou");
			return null;
		}
	}
	
	/**
	 * Execute the SQL queries
	 * @param sql
	 * 		it's a sql query
	 * @return the result of the query
	 */
	public ResultSet procedure(String sql){
		try{
			CallableStatement call = connection.getConnection().prepareCall(sql);
			call.execute();
			return call.getResultSet();
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
}
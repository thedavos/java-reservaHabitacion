package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import clases.Habitacion;

//Utilidades
import utils.ConnectionDB;

public class HabitacionModel {
	
	private Connection conn = null;
	
	private Connection connect() {
		ConnectionDB db = new ConnectionDB();
		this.conn = db.connectionMySQL();
		return this.conn;
	}
	
	public void createHab(Habitacion hab) {
		String query = "";
		
		try {
			query = "INSERT INTO Cliente("
					+ "numero, "
					+ "piso, "
					+ "descripcion, "
					+ "estado)"
					+ " values (?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = this.connect().prepareStatement(query);
			preparedStmt.setString(1, hab.getNumHab());
			preparedStmt.setString(2, String.valueOf(hab.getPiso()));
			preparedStmt.setString(3, hab.getDescripcion());
			preparedStmt.setString(4, String.valueOf(hab.getEstado()));
			preparedStmt.execute();
			
			preparedStmt.close();
			this.conn.close();
			this.conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Habitacion getHab(int idHab) {
		String query = "";
		Habitacion hab = null;
		
		try {
			query = "SELECT * FROM Habitacion WHERE "
					+ "id = '" + idHab + "'";
			
			Statement statement = this.connect().createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				
				int id = result.getInt("id");
				String numHab = result.getString("numero");
				char piso = (char) (result.getString("piso").charAt(0) + result.getString("piso").charAt(1));
				String descripcion = result.getString("descripcion");
				char estado = result.getString("estado").charAt(0);
				
				hab = new Habitacion(
						numHab,
						descripcion,
						piso,
						estado
				);
				hab.setId(id);
				
				return hab;
			}
			
			statement.close();
			this.conn.close();
			this.conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return hab;
	}
	
	public ArrayList<Habitacion> getHabs() {
		ArrayList<Habitacion> Habs = new ArrayList<Habitacion>();
		String query = "";
		
		try {
			query = "SELECT * FROM Habitacion";
			
			Statement statement = this.connect().createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while (result.next()) {
				int id = result.getInt("id");
				String numHab = result.getString("numero");
				char piso = (char) (result.getString("piso").charAt(0) + result.getString("piso").charAt(1));
				String descripcion = result.getString("descripcion");
				char estado = result.getString("estado").charAt(0);
				
				Habitacion hab = new Habitacion(
						numHab,
						descripcion,
						piso,
						estado
				);
				hab.setId(id);
				
				Habs.add(hab);
			}
			
			statement.close();
			this.conn.close();
			this.conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Habs;	
	}
	
	public void updateHab(Habitacion hab, int id) {
		String query = "";
		
		try {
			query = "UPDATE Habitacion SET numero = ?, "
					+ "piso = ?, "
					+ "descripcion = ?, "
					+ "estado = ? WHERE idHabitacion = ?";
			
			PreparedStatement preparedStmt = this.connect().prepareStatement(query);
			preparedStmt.setString(1, hab.getNumHab());
			preparedStmt.setString(2, String.valueOf(hab.getPiso()));
			preparedStmt.setString(3, hab.getDescripcion());
			preparedStmt.setString(4, String.valueOf(hab.getEstado()));
			preparedStmt.setInt(5, hab.getId());
			
			preparedStmt.executeUpdate();
			
			preparedStmt.close();
			this.conn.close();
			this.conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteHab(int id) {
		String query = "";
		
		try {
			
			query = "DELETE FROM Habitacion WHERE idHabitacion = ?";
			
			PreparedStatement preparedStmt = this.connect().prepareStatement(query);
			preparedStmt.setInt(1, id);
			
			preparedStmt.executeUpdate();
			
			preparedStmt.close();
			this.conn.close();
			this.conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

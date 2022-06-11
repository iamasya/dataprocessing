package jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Instruments.instrument;
import servlets.LabCRUDInterface;

public class SqlCRUD implements LabCRUDInterface<instrument> {
	
	Connection connection;
	
	public SqlCRUD() {
		
		this.connection = new Connect().getCon();
		System.out.println(connection);
		
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void create(instrument t) {
		// TODO Auto-generated method stub
		try (PreparedStatement st = connection.prepareStatement("INSERT INTO instruments (title,info,price) " + "VALUES (?,?,?)")) {
			st.setString(1, t.getTitle());
			st.setString(2, t.getInfo());
			st.setFloat(3, t.getPrice());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<instrument> read() {
		// TODO Auto-generated method stub
		List<instrument> list = new ArrayList<>();

		try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM instruments;");) {
			while (rs.next()) {
				list.add(new instrument(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getFloat(4)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
		

	@Override   
	public void update(int id, instrument t) {
		// TODO Auto-generated method stub
		try(PreparedStatement st = connection.prepareStatement("UPDATE instruments " + "SET \"title\"=?, \"info\"=?, \"price\"=? WHERE id=?;")){
			st.setString(1, t.getTitle());
			st.setString(2, t.getInfo());
			st.setFloat(3, t.getPrice());
			st.setInt(4, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try(PreparedStatement st = connection.prepareStatement("DELETE FROM instruments WHERE id=?;")){
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
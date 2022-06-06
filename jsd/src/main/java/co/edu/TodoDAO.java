package co.edu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO extends DAO {
	public List<Todo> doList(){
		connect();
		List<Todo> list = new ArrayList<>();
		String sql = "SELECT * FROM DO_LIST ORDER BY 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Todo td = new Todo();
				td.setDoId(rs.getInt("do_id"));
				td.setContent(rs.getString("content"));
				td.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return doList();
	}
	
	
	 public void insertlist(Todo td) {
	      connect();
	      String sql = "INSERT INTO DO_LIST VALUES(TODO_SEQ.NEXTVAL, ?, ?)";
	      try {
	         psmt = conn.prepareStatement(sql);
	         psmt.setString(1, td.getContent());
	         psmt.setString(2, td.getStatus());
	         psmt.executeUpdate();              
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         disconnect();
	      }
	   }
	 
	 
	 public void deletelist(Todo td) {
		connect();
		String sql = "DELETE FROM DO_LIST WHERE DO_ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, td.getDoId());
			psmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					disconnect();
				}
	 }
}

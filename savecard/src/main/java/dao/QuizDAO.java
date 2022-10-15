package dao;

import java.sql.SQLException;
import java.sql.Statement;

import model.Quiz;

public class QuizDAO extends DAO {
	public QuizDAO() {
		super();
		databaseConnection();
	}
	
	public void bdClose() {
		databaseConnectionClose();
	}
	
	public boolean insert(Quiz q) {
		System.out.println(q.toString());
		boolean status = false;
			try {
				System.out.println("chamou insert");
				Statement stm = conn.createStatement();
				String query = "insert into quiz (r1, r2, r3, r4, usuario_id) values ('" + q.getR1() + "', '" + q.getR2() + "', '"+ q.getR3() + "', '"+ q.getR4() + "', '"+ q.getUsuarioId() +"')";
				stm.executeUpdate(query);
				stm.close();
				status = true;
				System.out.println("chamou insert");
			} catch (SQLException e) {
				e.getMessage();
			}
		
		return status;
	}
}

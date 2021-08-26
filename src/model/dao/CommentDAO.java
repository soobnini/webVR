package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Comment;

public class CommentDAO {
private JDBCUtil jdbcUtil = null;
	
	public CommentDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil ��ü ����
	}

	//comment ����
	public int create(Comment comment) throws SQLException {
		String sql = "insert into comment (content, date, user_id, artwork_id) values (?, ?, ?, ?)"; //null�� �θ� �˾Ƽ� �����ϴ���? �ƴϸ� id �÷��� �����ϰ� �־�� �ϴ� ����?	
		Object[] param = new Object[] {
				comment.getContent(), 
				new java.sql.Date(comment.getDate().getTime()), 
				comment.getUserID(), 
				comment.getArtwId()};				
		jdbcUtil.setSqlAndParameters(sql, param);	
		try {				
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();
		}		
		return 0;			
	}
	
	//artwork id�� ���� �ش� ��ǰ�� ���� comment�� list ��ȸ
	public List<Comment> findCommentListByArtworkId(int artworkId) {
		String sql = "select id, content, date, user_id " 
      		   + "from comment "
      		   + "where artwork_id=? "
      		   + "order by id"; //�ð� ������� id�� ��������ϱ� �׳� id�� ����
		jdbcUtil.setSqlAndParameters(sql, new Object[] {artworkId});	
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			List<Comment> commentList = new ArrayList<Comment>();	
			while (rs.next()) {
				Comment comment = new Comment(
					rs.getInt("id"),
					rs.getString("content"),
					new java.util.Date(rs.getDate("date").getTime()),
					rs.getInt("user_id"),
					artworkId);
				commentList.add(comment);	
			}		
			return commentList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

}
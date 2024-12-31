package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.dto.PostDto;
import test.util.DBConnector;

public class PostDao {
	public boolean insert(PostDto dto) {
		Connection conn =null;
		PreparedStatement pstmt=null;
		int rowcount = 0;
		try {
			conn= new DBConnector().getConn();
			String sql="""
					insert into posts
					(id, title, content)
					values(posts_seq.nextval, ?, ?) 
					""";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			rowcount=pstmt.executeUpdate();
		}catch(SQLException se){
			se.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(rowcount>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean delete(int id) {
		Connection conn =null;
		PreparedStatement pstmt=null;
		int rowcount=0;
		try {
			conn = new DBConnector().getConn();
			String sql="""
						delete from posts
						where id=?
					""";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rowcount=pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
			}
		}
		if(rowcount>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean update(PostDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int rowcount=0;
		try {
			conn= new DBConnector().getConn();
			String sql="""
					update posts
					set title=?, content=?
					where id=?
					""";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getId());
			rowcount=pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){
				
			}
		}
		if(rowcount>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public PostDto getData(int id) {
		PostDto dto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn= new DBConnector().getConn();
			String sql="""
					select title, content
					from posts
					where id=?
					""";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto=new PostDto();
				dto.setId(id);
				dto.setTitle("title");
				dto.setContent("content");
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		return dto;
	}
	
	public List<PostDto> getList(){
		List<PostDto> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn = new DBConnector().getConn();
			String sql="""
						select id, title, content
						from posts
						order by id asc
					""";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				PostDto dto=new PostDto();
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				list.add(dto);
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if (rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if (conn!=null) conn.close();
			}catch(Exception e) {}
		}
		return list;
	}
}

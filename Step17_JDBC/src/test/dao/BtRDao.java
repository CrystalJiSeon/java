package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.dto.BtRDto;
import test.util.DBConnector;

public class BtRDao {
	public boolean insert(BtRDto dto) {
		Connection conn= null;
		PreparedStatement pstmt=null;
		int rowCount=0;
		try {
			conn=new DBConnector().getConn();
			String sql="""
					insert into BtR
					(no, title, writer)
					values(seq_BtR.nextval, ?, ?)
					""";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getWriter());
			rowCount=pstmt.executeUpdate();
		}catch(SQLException se){
			se.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(rowCount>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean update(BtRDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int rowCount=0;
		try {
			conn= new DBConnector().getConn();
			String sql="""
					update BtR
					set title=?, writer=?
					where no=?
					""";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getWriter());
			pstmt.setInt(3, dto.getNo());
			rowCount=pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();				
			}catch(Exception e){	}
		}
		if(rowCount>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean delete(int num) {
		Connection conn=null;
		PreparedStatement pstmt = null;
		int rowCount=0;
		try {
			conn = new DBConnector().getConn();
			String sql="""
					delete from BtR
					where no=?
					""";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rowCount=pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				
			}
		}
		if (rowCount>0) {return true;}
		else {return false;}
		
	}
	
	public BtRDto getData(int no) {
		BtRDto dto=null;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn= new DBConnector().getConn();
			String sql="""
					select no, title, writer
					from BtR
					where no =?
					""";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next()){
				dto=new BtRDto();
				dto.setNo(no);
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
			}
			
		} catch(SQLException se) {
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
	
	public List<BtRDto> getList(){
		List<BtRDto> list = new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			conn =new DBConnector().getConn();
			String sql="""
					select no, title, writer
					from BtR
					order by no asc
					""";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BtRDto dto=new BtRDto();
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				list.add(dto);
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
		return list;
	}
	
}

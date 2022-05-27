package com.reetu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Med;

@Repository
public class MedRepo {
	
	                    @Autowired
	                    JdbcTemplate jdbctemplate;
	                    
	                    //to add medicine
	                    public String addmed(Med m, MultipartFile image) {
	                    	try {
	                    		
	                    		String query = "insert into med values(?,?,?,?)";
	                    		int x=jdbctemplate.update(query, new Object[] {m.getMid(), m.getName(), m.getPrice(), image.getInputStream()});
	                    		if(x!=0) {
	                    			return "success";
	                    		}else {
	                    			return "failed";
	                    		}
								
							} catch (Exception e) {
								e.printStackTrace();
								return "failed";
							}
	                    	
	                    }
	                    
	                    //to view all medicine
	                    public List<Med> viewall(){
	                    	class DataMapper implements RowMapper{

								@Override
								public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
									Med m= new Med();
									m.setMid(rs.getInt("mid"));
									m.setName(rs.getString("name"));
									m.setPrice(rs.getInt("price"));
									return m;
								}
	                    		
	                    	}
	                    	try {
	                    		  final String query = "select * from med";
	                    		  List<Med> m=jdbctemplate.query(query, new DataMapper());
	                    		  return m;
								
							} catch (Exception e) {
								return null;
							}
	                    }
	                    
	                    // to get image from databade
	                    public byte[] getimage(int mid) {
	                    	class DataMapper implements RowMapper{

								@Override
								public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
									
									return rs.getBytes("image");
								}
	                    		
	                    	}
	                    	try {
	                    		final String query="select image from med where mid=?";
	                    		byte[] b=(byte[])jdbctemplate.queryForObject(query, new DataMapper(), new Object[] {mid});
	                    		return b;
								
							} catch (Exception e) {
								e.printStackTrace();
								return null;
							}
	                    }
	                    
	                    //get same name med
	                    public List<Med> getlikename(String name){
	                    	class DataMapper implements RowMapper{

								@Override
								public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
									Med m = new Med();
									m.setMid(rs.getInt("mid"));
									m.setName(rs.getString("name"));
									m.setPrice(rs.getInt("price"));
									return m;
								}
	                    		
	                    	}
	                    	try {
	                    		 final String query="select * from med where name like?";
	                    		 List<Med> m = jdbctemplate.query(query, new DataMapper(), new Object[] {"%"+name+"%"});
	                    		 return m;
								
							} catch (Exception e) {
								e.printStackTrace();
								return null;
							}
	                    }
	                    
	                    //delete a med
	                    public String delete(int mid) {
	                    	try {
	                    		String query = "delete from med where mid=?";
	                    		int x = jdbctemplate.update(query,new Object[] {mid});
	                    		if(x!=0) {
	                    			return "success";
	                    		}else {
	                    			return "failed";
	                    		}
								
							} catch (Exception e) {
								e.printStackTrace();
								return "failed";
							}
	                    }
	                    
	                    //update med
	                    public String update(Med m) {
	                    	try {
	                    		  String query="update med set name=?,price=? where mid=?";
	                    		  int x=jdbctemplate.update(query, new Object[] {m.getName(), m.getPrice(), m.getMid()});
	                    		  
	                    		  if(x!=0) {
	                    			  return "success";
	                    		  }else {
	                    			  return "failed";
	                    		  }
								
							} catch (Exception e) {
								e.printStackTrace();
								return "failed";
							}
	                    }
	                    
	                    //updateimage
	                    public String updateimage(int mid, MultipartFile image) {
	                    	try {
	                    		String query="update med set image=? where mid=?";
	                    		int x= jdbctemplate.update(query, new Object[] {image.getInputStream(), mid});
	                    		if(x!=0) {
	                    			return "success";
	                    		}else {
	                    			return "failed";
	                    		}
								
							} catch (Exception e) {
								e.printStackTrace();
								return "failed";
							}
	                    }
	                    //get all ids only
	                    public List<Integer> getallids(){
	                    	class DataMapper implements RowMapper{

								@Override
								public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
									
									return rs.getInt("mid");
								}
	                    		
	                    	}
	                    	try {
	                    		   final String query="select mid from med";
	                    		   List<Integer> l=jdbctemplate.query(query, new DataMapper());
	                    		   return l;
								
							} catch (Exception e) {
								e.printStackTrace();
								return null;
							}
	                    }

}

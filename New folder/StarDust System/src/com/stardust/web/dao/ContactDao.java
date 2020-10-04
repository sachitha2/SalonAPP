package com.stardust.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stardust.web.connection.ConnectionProvider;
import com.stardust.web.model.Contacts;
import com.stardust.web.model.Customer;

public class ContactDao {

	private static Connection conn;
	
	public ContactDao() {
    	conn = ConnectionProvider.getConnection();
	}
	
	public static List<Contacts> getreg(){
		List<Contacts> co = new ArrayList<Contacts>();

		try{
				String sql = "SELECT * FROM Contact_Registered";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Contacts cont = new Contacts();
					cont.setRegContactID(rs.getInt("contactID"));
					cont.setRegName(rs.getString("name"));
					cont.setRegEmail(rs.getString("email"));
					cont.setRegPhone(rs.getInt("phone"));
					cont.setRegMessage(rs.getString("message"));
					cont.setRegCustomerID(rs.getInt("customerID"));
					co.add(cont);
				}
					
		} catch (SQLException e) {
            e.printStackTrace();
        }
		
		
		return co;
	}
	
	
	public static List<Contacts> nonreg(){
		List<Contacts> co1 = new ArrayList<Contacts>();

		try{
				String sql1 = "SELECT * FROM Contact_UnRegistered";
				PreparedStatement ps1 = conn.prepareStatement(sql1);
				ResultSet rs1 = ps1.executeQuery();
				while (rs1.next()) {
					Contacts cont1 = new Contacts();
					cont1.setNonContactID(rs1.getInt("contactID"));
					cont1.setNonName(rs1.getString("name"));
					cont1.setNonEmail(rs1.getString("email"));
					cont1.setNonPhone(rs1.getInt("phone"));
					cont1.setNonMessage(rs1.getString("message"));
					co1.add(cont1);
				}
					
		} catch (SQLException e) {
            e.printStackTrace();
        }
		
		
		return co1;
	}
}

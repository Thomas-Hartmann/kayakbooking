package model;

import control.Booking;
import control.Kayak;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Nov 10, 2016 
 */
public class KayakMapper {
    public Kayak getKayak(int id){
        Kayak kayak = null;
        try {
            String sql = "SELECT id, name, model, description, year, color, length from kayak WHERE id = ?";
            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                int kayakid = rs.getInt("id");
                String name = rs.getString("name");
                String model = rs.getString("model");
                String desc = rs.getString("description");
                int year = rs.getInt("year");
                String color = rs.getString("color");
                double length = rs.getDouble("length");
                kayak = new Kayak(kayakid, name, model, desc, color, length, null);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return kayak;
    }
    
    public List<Kayak> getAllKayaks(){
        List<Kayak> kayaks = new ArrayList();
        try {
            String sql = "SELECT id, name, model, description, year, color, length FROM kayak";
            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                int kayakid = rs.getInt("id");
                String name = rs.getString("name");
                String model = rs.getString("model");
                String desc = rs.getString("description");
                int year = rs.getInt("year");
                String color = rs.getString("color");
                double length = rs.getDouble("length");
                Kayak kayak = new Kayak(kayakid, name, model, desc, color, length, null);
                kayaks.add(kayak);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return kayaks;
    }
}

package model;

import control.Booking;
import control.Kayak;
import control.User;
import control.exceptions.BookingNotPossibleException;
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
public class BookingMapper {
    
    private UserMapper um = new UserMapper();
    private KayakMapper km = new KayakMapper();
    
//    public Booking getBooking(int id){}
    
    public List<Booking> getAllBookings(){
        List<Booking> bookings = new ArrayList();
        try {
            String sql = "select userid, kayakid, bookingdate from booking";
            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                
                int userid = rs.getInt("userid");
                int kayakid = rs.getInt("kayakid");
                Date date = new Date(rs.getDate("bookingdate").getTime()); //convert from java.sql.date to java.util.date
                Booking booking = new Booking(km.getKayak(kayakid),um.getUser(userid), date);
                bookings.add(booking);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return bookings;
    }
//    
//    public List<Booking> getBookingsFromDate(Date date){
//        
//    }
//    
//    public List<Booking> getBookingsFromUser(User user){
//        
//    }
//    
    public void makeBooking(Kayak kayak, User user, Date date) throws BookingNotPossibleException{
        Booking booking = null;
        if(!isBooked(kayak, date)){ 
            try {
                String sql = "INSERT INTO booking(userid, kayakid, bookingdate) VALUES (?, ?, ?)";
                PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
                pstmt.setInt(1, user.getId());
                pstmt.setInt(2, kayak.getId());
                pstmt.setDate(3, new java.sql.Date(date.getTime()));
                int result = pstmt.executeUpdate();
            } catch (SQLException ex) {
                throw new BookingNotPossibleException(ex.getMessage());
            }

        } else {
            throw new BookingNotPossibleException();
        }
    }
//    
    public boolean isBooked(Kayak kayak, Date date){
        
        try {
            String sql = "SELECT userid, kayakid, bookingdate FROM booking WHERE kayakid = ? AND bookingdate = ?";
            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
            pstmt.setInt(1, kayak.getId());
            pstmt.setDate(2, new java.sql.Date(date.getTime()));
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}

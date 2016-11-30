package model;

import model.entity.Booking;
import model.entity.Kayak;
import model.entity.User;
import model.entity.exceptions.BookingNotPossibleException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Nov 10, 2016
 */
public class DataFacade {

    BookingMapper bm = new BookingMapper();
    KayakMapper km = new KayakMapper();
    UserMapper um = new UserMapper();
    
    public static void main(String[] args) {
        
        DataFacade df = new DataFacade();
        System.out.println("testing getAllBookings()");
        for(Booking booking : df.getAllBookings()) {
            System.out.println("booking date: "+booking.getDate()+" of kayak: "+booking.getKayak().getName());
        }
        System.out.println("testing makeBooking()");
        System.out.println("user: "+df.getUser(1).getId());
        try {
            df.makeBooking(df.getKayak(1), df.getUser(1), new Date());
        } catch (BookingNotPossibleException ex) {
            ex.printStackTrace();
        }
        System.out.println("testing getAllKayaks()");
        for (Kayak kayak : df.getAllKayaks()) {
            System.out.println("kayak: "+kayak.getName());
        }
        System.out.println("testing getKayak() med id: 1");
        System.out.println(df.getKayak(1).getName());
        
        System.out.println("testing getAllUsers()");
        for (User user : df.getAllUsers()) {
            System.out.println(user.getName());
        }
        System.out.println("testing getUser() with id: 1");
        System.out.println(df.getUser(1));
    }
    public List<Booking> getAllBookings(){
        return bm.getAllBookings();
    }
    public void makeBooking(Kayak kayak, User user, Date date) throws BookingNotPossibleException{
        bm.makeBooking(kayak, user, date);
    }
    public List<Kayak> getAllKayaks(){
        return km.getAllKayaks();
    }
    public Kayak getKayak(int id){
        return km.getKayak(id);
    }
    public List<User> getAllUsers(){
        return um.getAllUsers();
    }
    public User getUser(int id){
       return um.getUser(id);
    }
    public boolean authenticate(String username, String password){
        return um.authenticate(username, password);
    }
    public User getUserFromName(String username){
        return um.getUserByName(username);
    }
}

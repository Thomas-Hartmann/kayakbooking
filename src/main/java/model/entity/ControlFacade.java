package model.entity;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import model.entity.exceptions.BookingNotPossibleException;
import java.util.Date;
import java.util.List;
import model.DataFacade;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Nov 10, 2016 
 */
public class ControlFacade {
    private DataFacade df = new DataFacade();
    
    public boolean authenticate(String username, String password){
        return df.authenticate(username, password);
    }
    public List<Booking> getAllBookings(){
        return df.getAllBookings();
    }
    public List<Kayak> getAllKayaks(){
        return df.getAllKayaks();
    }
    public List<User> getAllUsers(){
        return df.getAllUsers();
    }
    public Kayak getKayak(int id){
        return df.getKayak(id);
    }
    public User getUser(int id){
        return df.getUser(id);
    }
    public void makeBooking(Kayak kayak, User user, Date date) throws BookingNotPossibleException{
        df.makeBooking(kayak, user, date);;
    }
    public User getUserByName(String username){
        return df.getUserFromName(username);
    }
}

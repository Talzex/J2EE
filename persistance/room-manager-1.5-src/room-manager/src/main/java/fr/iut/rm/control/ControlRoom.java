package fr.iut.rm.control;

import com.google.inject.Inject;
import com.google.inject.persist.UnitOfWork;
import fr.iut.rm.persistence.dao.RoomDao;
import fr.iut.rm.persistence.domain.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * Created by cjohnen on 02/02/17.
 */
public class ControlRoom {
    /**
     * Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ControlRoom.class);

    /**
     * Unit of work is used to drive DB Connection
     */
    @Inject
    UnitOfWork unitOfWork;

    /**
     * Data Access Object for rooms
     */
    @Inject
    RoomDao roomDao;

     /*
     * * Displays all the rooms content in DB
     */
    public void showRooms() {
        unitOfWork.begin();

        List<Room> rooms = roomDao.findAll();
        if (rooms.isEmpty()) {
            System.out.println("No room");
        } else {
            System.out.println("Rooms :");
            System.out.println("--------");
            for (Room room : rooms) {
                System.out.println(String.format("   [%d], name '%s' desc '%s' ", room.getId(), room.getName(), room.getDescription()));
            }
        }

        unitOfWork.end();
    }

    /**
     * Creates a room in DB
     *
     * @param name the name of the room
     * @param desc the desc of the room
     */
    public void createRoom(final String name, final String desc) {
        unitOfWork.begin();

        // TODO check unicity

        Room room = new Room();
        room.setName(name);
        room.setDescription(desc);
        try{
            roomDao.saveOrUpdate(room);
        } catch (ConstraintViolationException e){
            System.out.println(e.getConstraintViolations());
        }

        unitOfWork.end();
    }

    public void deleteRoom (final String name) {
        unitOfWork.begin();

        Room room = new Room();
        room = roomDao.findByName(name);
        if(room != null){
            roomDao.removeRoom(room);
            System.out.println(" -- Room with name " + name + " delete");
        } else {
            System.out.println(" -- No room with name " + name  +" found");
        }
        unitOfWork.end();
    }

    public void enterRoom(String roomName, String person) {
        unitOfWork.begin();
        Room room = roomDao.findByName(roomName);
        if(room != null){
            
            System.out.println(" -- Room with name " + roomName + " delete");
        } else {
            System.out.println(" -- No room with name " + roomName  +" found");
        }
        unitOfWork.end();
    }

    public void leaveRoom(String room, String person) {
        unitOfWork.begin();

        unitOfWork.end();
    }

    public void logRoom(String room) {
        unitOfWork.begin();

        unitOfWork.end();
    }

    public void logPerson(String person) {
        unitOfWork.begin();

        unitOfWork.end();
    }
}

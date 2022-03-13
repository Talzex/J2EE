package fr.iut.rm.web.api;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;
import com.sun.jersey.api.NotFoundException;
import fr.iut.rm.persistence.dao.AccessEventDao;
import fr.iut.rm.persistence.dao.RoomDao;
import fr.iut.rm.persistence.domain.AccessEvent;
import fr.iut.rm.persistence.domain.Room;
import fr.iut.rm.web.api.model.AccessEventVO;
import fr.iut.rm.web.api.model.RoomDetailsVO;
import fr.iut.rm.web.api.model.RoomVO;
import fr.iut.rm.web.api.model.SaveRoomVO;
import org.jboss.logging.annotations.Pos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Room WS Endpoint
 */
@Path("/rooms")
@RequestScoped
public class RoomResource {

    /**
     * Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(RoomResource.class);

    /**
     * Injected Room DAO
     */
    @Inject
    private RoomDao roomDao;
    /**
     * Injected Access Event DAO
     */
    @Inject
    private AccessEventDao accessEventDao;

    /**
     * List all rooms
     *
     * @return all defined rooms
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=UTF-8"})
    public List<RoomVO> listRooms(@QueryParam("q")String q) {
        logger.debug("List all rooms");
        // TODO add a query parameter (@QueryParam) to filter on room names using roomDao.searchByName method
        List<Room> rooms = null;
        if(q != null){
            rooms = roomDao.searchByName(q);
        } else {
            rooms = roomDao.findAll();
        }

        // Convert rooms into visual object (select only necessary fields)
        final List<RoomVO> roomsVO = rooms.stream().map(room -> {
            final RoomVO roomVO = new RoomVO();
            roomVO.setId(room.getId());
            roomVO.setName(room.getName());
            roomVO.setDescription(room.getDescription());
            return roomVO;
        }).collect(Collectors.toList());

        //Return objects
        return roomsVO;
    }

    @GET
    @Path("/{roomId}/events")
    @Produces({MediaType.APPLICATION_JSON + "; charset=UTF-8"})
    public List<AccessEventVO> listAccessEvent(@PathParam(value = "roomId") long roomId, @QueryParam(value = "type") String type){
        logger.debug("List all Event");
        List<AccessEvent> events;
        Room room = roomDao.get(roomId);
        if(room ==  null){
            return null;
        }
        events = accessEventDao.findBy(room.getId(), null);
        List<AccessEventVO> eventVO = events.stream().map(ae -> {
            AccessEventVO accessEventVO = new AccessEventVO();
            accessEventVO.setId(ae.getId());
            accessEventVO.setType(ae.getType());
            accessEventVO.setUserName(ae.getUserName());
            return accessEventVO;
        }).collect(Collectors.toList());

        if(type != null && (type.equals("IN") || type.equals("OUT"))){
            List<AccessEventVO> listWithType = new ArrayList<>();
            eventVO.forEach(ae -> {
                if(ae.getType().toString().equals(type))
                    listWithType.add(ae);
            });

            return listWithType;
        }

        return eventVO;
    }

    /**
     * Retrieve a room by its name.
     *
     * @param roomId room identifier
     * @return found room
     */
    @GET
    @Path("/{roomId}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=UTF-8"})
    public RoomDetailsVO getRoom(@PathParam(value = "roomId") long roomId) {
        logger.debug("Retrieve room with id {}", roomId);
        Room room = roomDao.get(roomId);

        if(room == null){
            throw new NotFoundException();
        }
        List<AccessEvent> accessEventList = accessEventDao.findBy(roomId,null);
        RoomDetailsVO roomDetailsVO = new RoomDetailsVO();
        roomDetailsVO.setId(room.getId());
        roomDetailsVO.setName(room.getName());
        roomDetailsVO.setDescription(room.getDescription());
        roomDetailsVO.setAccessEventsCount(accessEventList.size());

        return roomDetailsVO;
    }

    @POST
    @Path("/{roomId}/events")
    @Produces({MediaType.APPLICATION_JSON + "; charset=UTF-8"})
    public Response addAccess(AccessEventVO accessEventVO, @PathParam(value = "roomId") long roomId){
        logger.debug("Add Access");
        Room room = roomDao.get(roomId);
        if(room == null){
            throw new NotFoundException();
        }
        AccessEvent event = new AccessEvent();
        event.setRoom(room);
        event.setType(accessEventVO.getType());
        event.setUserName(accessEventVO.getUserName());
        event.setDateTime(LocalDateTime.now());
        accessEventDao.saveOrUpdate(event);
        return  Response.ok().entity(event.getId()).build();
    }


    /**
     * Delete an accessEvent
     *
     */
    @DELETE
    @Path("/{roomId}/events/{eventId}")
    @Consumes({MediaType.APPLICATION_JSON + "; charset=UTF-8"})
    public void deleteEvent(@PathParam(value = "roomId") long roomId, @PathParam(value = "eventId") long eventId) {
        logger.debug("Delete an access event");

        Room r = roomDao.get(roomId);
        if(r == null)
            return;

        AccessEvent ae = accessEventDao.get(eventId);
        if(ae == null)
            return;

        accessEventDao.delete(ae);
    }


    /**
     * Creates a Room
     *
     * @param roomVO room object to create
     * @return Response :
     * - 400 if given room contains bad values
     * - 409 if a room already exists with the given name
     * - 200 with the created room id in case of success
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON + "; charset=UTF-8"})
    public Response createRoom(SaveRoomVO roomVO) {
        logger.debug("Create a room");
        // TODO check mandatory parameters -> http status 400
        if(roomVO.getName() == null && roomVO.getDescription() == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        // TODO Check if a room already exists with this name -> http status 409
        Room room = roomDao.findByName(roomVO.getName());
        if(room != null){
            return Response.status(Response.Status.CONFLICT).build();
        }

        // TODO Creates room in db
        Room room1 = new Room();
        room1.setName(roomVO.getName());
        room1.setDescription(roomVO.getDescription());
        roomDao.saveOrUpdate(room1);

        // TODO Return a response with status 200 (OK) and created room id

        return Response.ok().build();
    }

    // TODO creates other resources on access events


}
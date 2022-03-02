package fr.iut;

import com.google.inject.Singleton;

import fr.iut.model.Room;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class ListRoomServlet extends HttpServlet {
    ArrayList<Room> fakeRooms = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        Template freemarkerTemplate = null;
        freemarker.template.Configuration freemarkerConfiguration =
                new freemarker.template.Configuration();
        freemarkerConfiguration.setClassForTemplateLoading(this.getClass(), "/");
        freemarkerConfiguration.setObjectWrapper(new DefaultObjectWrapper());
        try {
            freemarkerTemplate =
                    freemarkerConfiguration.getTemplate("templates/listRoom.ftl");
        } catch (IOException e) {
            System.out.println("Unable to process request,  error during freemarker template retrieval.");  }

        Map<String, Object> root = new HashMap<String, Object>();
        // navigation data and links
        Room room = new Room("room1",0,15);
        Room room2 = new Room("room2",2,16);
        Room room3 = new Room("room100", 25,100);
        fakeRooms.add(room);
        fakeRooms.add(room2);
        fakeRooms.add(room3);
        root.put("title", "LIST FAKE ROOM");
        root.put("fakeRooms", fakeRooms);
        PrintWriter out = response.getWriter();
        assert freemarkerTemplate != null;
        try {
            freemarkerTemplate.process(root, out);
            out.close();}
        catch (TemplateException e) { e.printStackTrace(); }
        // set mime type
        response.setContentType("text/html");
    }
}
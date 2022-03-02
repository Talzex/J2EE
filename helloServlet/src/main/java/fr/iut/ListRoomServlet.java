package fr.iut;

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

@WebServlet(name = "listRoom", urlPatterns = {"/listRoom"})
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
            System.out.println("Unable to process request," +
                    "error during freemarker template retrieval.");  }

        Map<String, Object> root = new HashMap<String, Object>();
        // navigation data and links
        Room room1 = new Room("r1", 0,25);
        Room room2 = new Room("r2", 5,30);
        Room room3 = new Room("r3", 20,20);

        fakeRooms.add(room1);
        fakeRooms.add(room2);
        fakeRooms.add(room3);

        root.put("title", "freemarker Servlet");
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
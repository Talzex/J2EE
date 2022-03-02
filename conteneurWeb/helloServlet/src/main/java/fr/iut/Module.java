package fr.iut;

import com.google.inject.servlet.ServletModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Module extends ServletModule {
    /*Logger*/
    private static final Logger logger =
            LoggerFactory.getLogger(Module.class);

    @Override
    protected void configureServlets() {
        super.configureServlets();
        serve("/hello").with(HelloServlet.class);
        serve("/home").with(HomeServlet.class);
        serve("/listRoom").with(ListRoomServlet.class);
        serve("/qrcode").with(QRCodeServlet.class);
        logger.info("WebModule configureServlets ended.");
    }
}

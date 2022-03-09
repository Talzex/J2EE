package fr.iut;




import com.google.inject.servlet.ServletModule;


public class Module extends ServletModule {
    /*Logger*/
    private static final Logger logger =
            LoggerFactory.getLogger(Module.class);

    @Override
    protected void configureServlets() {
        super.configureServlets();
        serve("/hello").with(HelloServlet.class);
        serve("/home").with(HelloServlet.class);
        serve("listRoom").with(ListRoomServlet.class);
        serve("/qrcode").with(QRCodeServlet.class);
        logger.error("WebModule configureServlets ended.");
    }
}

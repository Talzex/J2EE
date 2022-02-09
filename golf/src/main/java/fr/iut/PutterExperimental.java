package fr.iut;

import java.awt.geom.Point2D;

public class PutterExperimental implements Club {
    private final static int DISTANCE_MAX = 500;
    public void shoot(final double force, final double direction, final Ball ball) {
        double x = ball.getPosition().getX();
        double y = ball.getPosition().getY();
        x += (force * DISTANCE_MAX) * Math.sin(direction);
        y += (force * DISTANCE_MAX) * Math.cos(direction);
        ball.setPosition(new Point2D.Double(x, y));  }
}

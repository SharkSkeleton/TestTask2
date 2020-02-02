package com.todoapp;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;

import java.util.Date;

public class Todo {

    private String id;
    private String title;
    private double square;
    private double radius;
    private double heights;
    private double widthA;
    private double widthB;
    private boolean deleted;
    private Date createdOn = new Date();

    public Todo(BasicDBObject dbObject) {
        this.id = ((ObjectId) dbObject.get("_id")).toString();
        this.title = dbObject.getString("title");
        this.square = dbObject.getDouble("square");
        this.radius = dbObject.getDouble("radius");
        this.heights = dbObject.getDouble("heights");
        this.widthA = dbObject.getDouble("widthA");
        this.widthB = dbObject.getDouble("widthB");
        this.deleted = dbObject.getBoolean("deleted");
        this.createdOn = dbObject.getDate("createdOn");
    }

    public String getTitle() {
        return title;
    }

    public Double getSquare() {
        SquareCount s = new SquareCount();
        switch (getTitle()) {
            case "Circle": return s.circleSquare(getRadius());
            case "Square": return s.square(getWidthA());
            case "Triangle":return s.triangleSquare(getWidthA(), getHeights());
            case "Rectangle": return s.rectangleSquare(getWidthA(), getWidthB());
            case "Parallelogram":
            case "Diamond":
                return s.parallelogramSquare(getWidthA(), getHeights());
            case "Trapeze": return s.trapezeSquare(getWidthA(), getWidthB(), getHeights());
            case "Ellipse": return s.ellipseSquare(getWidthA(), getWidthB());
        }
        return square;
    }

    public String getId() {
        return id;
    }

    public Double getRadius() {
        return radius;
    }

    public Double getHeights() {
        return heights;
    }

    public Double getWidthA() {
        return widthA;
    }

    public Double getWidthB() {
        return widthB;
    }

    public boolean isDeleted() { return deleted; }

    public Date getCreatedOn() {
        return createdOn;
    }
}

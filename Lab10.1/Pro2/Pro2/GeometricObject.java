package Pro2;
import java.util.*;
public abstract class GeometricObject {

    private String color = "Red";
    private boolean filled;
    private Date dateCreated;

    //Construct
    public GeometricObject(){
        dateCreated = new java.util.Date();
    }

    public GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    //Method
    public String getColor() {
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public boolean IsFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    @Override
    public String toString() {
        return "created on" + dateCreated +"\nColor : " + color + "\nFilled : " + filled;
    }
}
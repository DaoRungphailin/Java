import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class ClockPane extends Pane {
     private int hour;
     private int minute;
     private int second;
     private boolean hourHandVisible = true;
     private boolean minuteHandVisible = true;
     private boolean secondHandVisible = true;

     public ClockPane() {
          setTime();
     }

     public ClockPane(int hour, int minute, int second) {
          this.hour = hour;
          this.minute = minute;
          this.second = second;
          printClock();
     }

     public void setTime() {
          Calendar calendar = new GregorianCalendar();

          this.hour = calendar.get(Calendar.HOUR_OF_DAY);
          this.minute = calendar.get(Calendar.MINUTE);
          this.second = calendar.get(Calendar.SECOND);
          printClock();
     }

     public int getHour() {
          return this.hour;
     }

     public void setHour(int hour) {
          this.hour = hour;
     }

     public int getMinute() {
          return this.minute;
     }

     public void setMinute(int minute) {
          this.minute = minute;
     }

     public int getSecond() {
          return this.second;
     }

     public void setSecond(int second) {
          this.second = second;
     }

     public boolean isHourHandVisible() {
          return this.hourHandVisible;
     }

     public boolean getHourHandVisible() {
          return this.hourHandVisible;
     }

     public void setHourHandVisible(boolean hourHandVisible) {
          this.hourHandVisible = hourHandVisible;
     }

     public boolean isMinuteHandVisible() {
          return this.minuteHandVisible;
     }

     public boolean getMinuteHandVisible() {
          return this.minuteHandVisible;
     }

     public void setMinuteHandVisible(boolean minuteHandVisible) {
          this.minuteHandVisible = minuteHandVisible;
     }

     public boolean isSecondHandVisible() {
          return this.secondHandVisible;
     }

     public boolean getSecondHandVisible() {
          return this.secondHandVisible;
     }

     public void setSecondHandVisible(boolean secondHandVisible) {
          this.secondHandVisible = secondHandVisible;
     }

     public void printClock() {
          double clockRadius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
          double centerX = getWidth() / 2;
          double centerY = getHeight() / 2;

          Circle circle = new Circle(centerX, centerY, clockRadius);
          circle.setFill(Color.WHITE);
          circle.setStroke(Color.BLACK);
          Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
          Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
          Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
          Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

          double sLength = clockRadius * 0.8;
          double secondX = centerX + sLength *
                    Math.sin(second * (2 * Math.PI / 60));
          double secondY = centerY - sLength *
                    Math.cos(second * (2 * Math.PI / 60));
          Line sLine = new Line(centerX, centerY, secondX, secondY);
          sLine.setStroke(Color.RED);

          double mLength = clockRadius * 0.65;
          double xMinute = centerX + mLength *
                    Math.sin(minute * (2 * Math.PI / 60));
          double minuteY = centerY - mLength *
                    Math.cos(minute * (2 * Math.PI / 60));
          Line mLine = new Line(centerX, centerY, xMinute, minuteY);
          mLine.setStroke(Color.BLUE);

          double hLength = clockRadius * 0.5;
          double hourX = centerX + hLength *
                    Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
          double hourY = centerY - hLength *
                    Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
          Line hLine = new Line(centerX, centerY, hourX, hourY);
          hLine.setStroke(Color.GREEN);

          getChildren().clear();
          getChildren().addAll(circle, t1, t2, t3, t4);

          if (secondHandVisible) {
               getChildren().add(sLine);
          }
          if (minuteHandVisible) {
               getChildren().add(mLine);
          }
          if (hourHandVisible) {
               getChildren().add(hLine);
          }
     }

     @Override
     public void setWidth(double width) {
          super.setWidth(width);
          printClock();
     }

     @Override
     public void setHeight(double height) {
          super.setHeight(height);
          printClock();
     }
}
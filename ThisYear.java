import org.code.theater.*;
import org.code.media.*;

public class ThisYear extends Scene {

  private String[] captions2026 = {"The Frame in Dubai","Burj Al Arab in Dubai","Meme that I find funny","Dubai view","Mosque in Dubai","My Dad and I in Dubai Sand Dunes","On the plane home"};
  private String[] images2026;

  // Variables (instance & static)

  // Constructor
  public ThisYear() {
     String[] images2026 = FileReader.toStringArray("2026.txt");
  }
  // Paramterized Constructor
  public ThisYear(String[] images2026) {
    this.images2026 = images2026;
  }

  /**
   * Top level drawScene method
   */
  public void drawScene() {
    draw2026();
    drawEnding();
  }

  /*
   * Draw slideshow background using enlarged image
   */
  public void drawBackground(){
    drawImage("codeWallpaper.jpg",0,0,800);
  }


  /*
   * Draw stacking memories
   * Adds title to the top
   * Stacks all images in the text 
   * Adds number of photos on top right
   * Adds captions on the bottom of the stacking images
   */
  public void draw2026() {
    drawBackground();
    setTextColor("white");
    drawText("Here are photos from this year! " + photoAmount() + " photos", 20, 20);
    int centerX = 200;  // center of the stack
    int centerY = 150;  // center of the stack
    int size = 200;
    int index = 0;
    
    for (String image : images2026) {
      
      // choose a random degree to rotate (0-20)
      int angle = (int) (Math.random() * 21);
      // if odd angle, rotate other direction
      if (angle % 2 == 1) {
        angle = (-1) * angle;
      }
      double dAngle = (double) angle;
      
      // calculate position for center-based rotation
      // standard 2D rotation: 
      // newX = x * cos(angle) - y * sin(angle)
      // newY = x * sin(angle) + y * cos(angle)
      double radians = Math.toRadians(dAngle);
      double halfSize = size / 2.0;
      int adjustedX = (int)(centerX - (halfSize * Math.cos(radians) - halfSize * Math.sin(radians)));
      int adjustedY = (int)(centerY - (halfSize * Math.sin(radians) + halfSize * Math.cos(radians)));
      
      
      // image on top of black boarder (if drawn)
      drawImage(image, adjustedX, adjustedY, size, dAngle);
      setFillColor("black");
      drawRectangle(0, 350, 400, 100);
      drawText(captions2026[index], 20, 380);
      index++;
      pause(3);
    }

     pause(1.5);
     clear("white");
  }
/*
   * Draw ending slide using shapes and text
   */
  public void drawEnding(){
     drawBackground();
     setFillColor("Red");
     drawRectangle(50,100,300,200);
     drawText("Happy New Year!", 63, 150);
     // splits up text due to overflow on screen
     drawText("This year, I strive to be", 63, 250);
     drawText("a better person", 63, 275);
  }

  /*
   * Returns the number of photos in the images2026 text file
   */
  public int photoAmount(){
    return images2026.length;
  }

}

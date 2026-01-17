import org.code.theater.*;
import org.code.media.*;

public class LastYear extends Scene {

  // Variables (instance & static)

  private String[] memoriesImages;
  private String[] friendsImages;
  private String[] musicImages;
  private String[] musicAudio;

  // Constuctor
  public LastYear() {
    String[] memoriesImages = FileReader.toStringArray("memories.txt");
    String[] friends = FileReader.toStringArray("friends.txt");
    String[] music = FileReader.toStringArray("music.txt");
    String[] musicAudio = FileReader.toStringArray("musicAudio.txt");
  }

  //paramaterized constructor
  public LastYear(String[] memoriesImages, String[] friendsImages, String[] musicImages, String[] musicAudio){
    this.memoriesImages = memoriesImages;
    this.friendsImages = friendsImages;
    this.musicImages = musicImages;
    this.musicAudio = musicAudio;
  }

  /*
   * Top level drawScene method
   */
  public void drawScene() {
    drawBackground();
    drawIntro();
    drawMemories();
    drawFriends();
    drawMusic();
  }

  // other methods
  
  /*
   * Draw introduction slide using shapes and text
   */
  public void drawIntro(){
     setFillColor("Red");
     drawRectangle(50,100,300,200);
     drawText("Happy 2025! Here is my recap!", 63, 150);
     drawText("By: Ayaan Arneja - 15", 63, 250);
     pause(5);
     clear("white");
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
   * Stacks all images in the text file
   */
 public void drawMemories() {
    drawBackground();
    setTextColor("white");
    drawText("Here are some of my memories!", 63,20);
    int centerX = 200;  // center of the stack
    int centerY = 150;  // center of the stack
    int size = 200;
    
    for (String image : memoriesImages) {
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
      pause(1.5);
    }

     pause(1.5);
     clear("white");
  }

  /*
   * Draws all 16 imported album covers into a grid
   * Plays a snippet of music from each album when it is placed
   */
  public void drawMusic() {
    drawBackground();
    setFillColor("Black");
    drawRectangle(50,100,300,200);
    setTextColor("White");
    drawText("Here are my albums of this year:", 62, 200);
    drawText("- Ayaan Arneja (SOUND ON!)", 70, 250);
    pause(3);
    clear("white");
    drawBackground();

    //4x4 grid
    int tileSize = 100;
    int width = getWidth();
    int height = getHeight();
    int imageIndex = 0;
    for (int y = 0; y < height; y += tileSize) {
      for (int x = 0; x < width; x += tileSize) {

        //remove overflow errors
        if (imageIndex >= musicImages.length) {
            return; // stop drawing
        }
        
        drawImage(musicImages[imageIndex], x, y, tileSize);
        //clips audio
        double[] audio = SoundLoader.read(musicAudio[imageIndex]);
        double[] clip1 = createClip(audio, 0, 3);
        playSound(clip1);
        pause(2.6); // time to sync with Audio
        
        imageIndex++;
      }
    }
    pause(1.5);
    clear("white");
  }

    /*
     * Returns a clip of the specfied Audio file
     */
    public static double[] createClip(double[] sound, int start, int end) {
    int SAMPLE_RATE = 44100;
    int startIndex = start * SAMPLE_RATE;
    int endIndex = end * SAMPLE_RATE;

    //only clips part of the song
    double[] newSound = new double[endIndex - startIndex];

    int index = 0;
    
    while (startIndex < endIndex) {
      newSound[index] = sound[startIndex];
      startIndex++;
      index++;
    }

    return newSound;
  }


  /* Draw stacking friends images
   * Adds title to the top
   * Stacks all images in the text file
   */
public void drawFriends() {
    drawBackground();
    setTextColor("white");
    drawText("Here are photos of me with my friends!", 27,20);
    int centerX = 200;  // center of the stack
    int centerY = 150;  // center of the stack
    int size = 200;
    
    for (String image : friendsImages) {
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
      pause(1.5);
    }

     pause(1.5);
     clear("white");
  }
}
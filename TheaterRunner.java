import org.code.theater.*;

public class TheaterRunner {
  public static void main(String[] args) {

    //read text files for scene classes
    String[] memories = FileReader.toStringArray("memories.txt");
    String[] friends = FileReader.toStringArray("friends.txt");
    String[] music = FileReader.toStringArray("music.txt");
    String[] musicCaptions = FileReader.toStringArray("musicAudio.txt");

    String[] images2026 = FileReader.toStringArray("2026.txt");



    // Create scene objects
    LastYear lastYear = new LastYear(memories,friends,music,musicCaptions);
    ThisYear thisYear = new ThisYear(images2026);

    // Call top level methods
    lastYear.drawScene();
    thisYear.drawScene();

    // Play scenes (in order of arguments)
    Theater.playScenes(lastYear, thisYear);
    
  }
}
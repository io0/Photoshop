import java.util.Scanner;
import java.io.*;

public class ImageFileUtilities{
  public static Image read(String filename) {
    //declaration
    String metadata = "";
    int maxRange = -1;
    Pixel[][] img = null;
    
    try{
      Scanner sc = new Scanner(new File(filename));
      int format = Integer.parseInt(sc.next().substring(1,2));
      sc.nextLine();
      while (sc.hasNext("#")){
        metadata = metadata + sc.nextLine() + "\n";
      }
      int width = sc.nextInt();
      int height = sc.nextInt();
      maxRange = sc.nextInt();
      img = new Pixel[height][width];
      
      if (format == 2){
        for (int i=0; i<img.length; i++){
          for (int j=0; j<img[0].length; j++){
            img[i][j] = new Pixel(sc.nextInt());
          }
        }
      } else if (format == 3) {
        for (int i=0; i<img.length; i++){
          for (int j=0; j<img[0].length; j++){
            img[i][j] = new Pixel(sc.nextInt(), sc.nextInt(), sc.nextInt());
          }
        }
      } else {
        throw new IllegalArgumentException("Format does not exist");
      }
    } catch (IOException e){
      System.out.println("Unexpected input");
    }
    
    Image theImage = new Image(metadata, maxRange, img); 
    return theImage;
  }
  
  //write pnm image
  public static void writePnm(Image theImage, String filename){
    try{
      FileWriter fw = new FileWriter(filename);
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write("P3");
      bw.newLine();
      bw.write(theImage.getMetadata());
      bw.write(theImage.getWidth() + " " + theImage.getHeight() + " " + theImage.getMaxRange());
      bw.newLine();
      for (int i=0; i<theImage.getHeight(); i++){
        for (int j=0; j<theImage.getWidth(); j++){
          bw.write(theImage.getPixel(i,j).getRed() + " ");
          bw.write(theImage.getPixel(i,j).getGreen() + " ");
          bw.write(theImage.getPixel(i,j).getBlue() + " ");
        }
        bw.newLine();
      }
      bw.close();
      fw.close();
    } catch (IOException e){
      System.out.println("Error while writing file");
    }
  }
  
  //write pgm image
  public static void writePgm(Image theImage, String filename){
    try{
      FileWriter fw = new FileWriter(filename);
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write("P2");
      bw.newLine();
      bw.write(theImage.getMetadata());
      bw.write(theImage.getWidth() + " " + theImage.getHeight() + " " + theImage.getMaxRange());
      bw.newLine();
      for (int i=0; i<theImage.getHeight(); i++){
        for (int j=0; j<theImage.getWidth(); j++){
          bw.write(theImage.getPixel(i,j).grey() + " ");
        }
        bw.newLine();
      }
    } catch(IOException e) {
      System.out.println("You done goof");
    }
  }
}
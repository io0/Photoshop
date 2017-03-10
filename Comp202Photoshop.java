public class Comp202Photoshop{
  public static void main(String[] args){
    
    //check input
    if (args.length<4){
      throw new IllegalArgumentException("Invalid input");
    }
    //read file
    Image theImage = ImageFileUtilities.read(args[0]);
    
    //perform operation
    if (args[3].equals("-fh")){
      theImage.flip(true);
    } else if (args[3].equals("-fv")){
      theImage.flip(false);
    } else if (args[3].equals("-gs")){
      theImage.toGrey();
    } else if (args[3].equals("-cr")){
      try {
        theImage.crop(Integer.parseInt(args[4]), Integer.parseInt(args[5]), Integer.parseInt(args[6]), Integer.parseInt(args[7]));
      } catch (Exception e){
        System.out.println("Specify dimensions for crop");
      }
    } else {
      throw new IllegalArgumentException("The requested operation does not exist");
    }
    
    //write file
    if (args[2].equals("pgm")){
      ImageFileUtilities.writePgm(theImage, args[1]);
    } else if (args[2].equals("pnm")){
      ImageFileUtilities.writePnm(theImage, args[1]);
    } else {
      throw new IllegalArgumentException("The requested file format does not exist");
    }
  }
}
    
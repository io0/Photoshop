public class Pixel{
  //declaration
  private int red;
  private int green;
  private int blue;
  
  public Pixel(int red, int green, int blue){
    //check hex values
    if (red<0||red>255||green<0||green>255||blue<0||blue>255){
      throw new IllegalArgumentException ("RGB value expected");
    } else {
    this.red = red;
    this.green = green;
    this.blue = blue;
    }
  }
  
  public Pixel (int intensity){
    if (intensity<0||intensity>255){
      throw new IllegalArgumentException ("RGB value expected");
    } else {
    this.red = intensity;
    this.green = intensity;
    this.blue = intensity;
    }
  }
  
  //getters
  public int getRed(){
    return this.red;
  }
  public int getGreen(){
    return this.green;
  }
  public int getBlue(){
    return this.blue;
  }
  
  //find grey
  public int grey(){
    return (int)((this.red + this.green + this.blue)/3.0);
  }
}
  
  
  
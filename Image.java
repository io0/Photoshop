public class Image{
  //declaration
  private String metadata;
  private int maxRange;
  private Pixel[][] data;
  
  //constructor
  public Image(String metadata, int maxRange, Pixel[][] data){
    if (maxRange<0){
      throw new IllegalArgumentException("Invalid max range");
    }
    this.metadata = metadata;
    this.maxRange = maxRange;
    //make copy of pixel data
    Pixel[][] temp = new Pixel[data.length][data[0].length];
    for (int i=0; i<data.length; i++){
      for (int j=0; j<data[0].length; j++){
        temp[i][j] = data[i][j];
      }
    }
    this.data = temp;
  }
  
  //getters
  public String getMetadata(){
    return this.metadata;
  }
  public int getMaxRange(){
    return this.maxRange;
  }
  public int getWidth(){
    return this.data[0].length;
  }
  public int getHeight(){
    return this.data.length;
  }
  public Pixel getPixel(int i, int j){
    return this.data[i][j];
  }
  
  //flip method
  public void flip(boolean horizontal){
    Pixel[][] temp = new Pixel[this.data.length][this.data[0].length];
    if (horizontal){
      for (int i=0; i<temp.length; i++){
        for (int j=0; j<temp[0].length; j++){
          temp[i][j] = this.getPixel(i,temp[0].length-j-1);
        }
      }
    } else {
       for (int i=0; i<temp.length; i++){
        for (int j=0; j<temp[0].length; j++){
          temp[i][j] = this.getPixel(temp.length-i-1, j);
        }
      }
    }
    this.data = temp;
  }
  
  //convert to greyscale
  public void toGrey(){
    Pixel[][] temp = new Pixel[this.data.length][this.data[0].length];
    for (int i=0; i<temp.length; i++){
      for (int j=0; j<temp[0].length; j++){
        temp[i][j] = new Pixel(this.data[i][j].grey());
      }
    }
    this.data = temp;
  }
  
  //crop method
  public void crop(int startX, int startY, int endX, int endY){
    if (startX<0||endX<startX||endX>this.data[0].length||startY<0||endY<startY||endY>this.data.length){
      throw new IllegalArgumentException("Can't crop");
    }
    Pixel[][] temp = new Pixel[endY-startY][endX-startX];
    for (int i=0; i<temp.length; i++){
        for (int j=0; j<temp[0].length; j++){
          temp[i][j] = this.data[startY+i][startX+j];
        }
      }
    this.data = temp;
  }
}
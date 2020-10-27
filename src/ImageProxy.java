public class ImageProxy implements Element{

    String url;
    Image realImage=null;

    public ImageProxy(String s){
        url=s;
    }

    Image loadImage(){

        if(realImage==null){
            realImage=new Image(url);
        }
        return realImage;
    }

    public void print() {
        Image img=loadImage();
        img.print();
        
    }
}

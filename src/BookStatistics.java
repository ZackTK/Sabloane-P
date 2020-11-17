import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.*;
public class BookStatistics implements Visitor {

    int sectionCounter=0;
    int imageCounter=0;
    int tableCounter=0;
    int paragraphCounter=0;
    JSONObject obj=new JSONObject();
    JSONArray img=new JSONArray();
    JSONArray para=new JSONArray();
    JSONArray sect=new JSONArray();
    JSONArray imgprox=new JSONArray();
    JSONArray tab=new JSONArray();

    public void visit(Image image){imageCounter++;
    img.add(image.getImageName());}

    public void visit(Section section){sectionCounter++;
    sect.add(section.getTitle());}

    public void visit(ImageProxy imageProxy){imageCounter++;
    imgprox.add(imageProxy.getRealImage());}

    public void visit(Paragraph paragraph){paragraphCounter++;
    para.add(paragraph.getName());}

    public void visit(Table table){tableCounter++;
    tab.add(table.getName());}

    public void CreateJSON() throws Exception{
        try(FileWriter file=new FileWriter("BookStats.json")){
            obj.put("Section",sect);
            obj.put("Table",tab);
            obj.put("Image",img);
            obj.put("ImageProxy",imgprox);
            obj.put("Paragraph",para);
            file.write(obj.toString());
            file.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void printStatistics(){
     System.out.println("Book Statistics: ");
     System.out.println("Number of Images: "+ imageCounter);
     System.out.println("Number of Tables: "+ tableCounter);
     System.out.println("Number of Paragraphs: "+ paragraphCounter);
     System.out.println("Number of Sections: "+ sectionCounter);
    }
}

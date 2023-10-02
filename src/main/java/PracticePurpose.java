import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class PracticePurpose {
    public static void main(String[] args) {


        ArrayList<String> arr = new ArrayList<>();
        arr.add("120");
        arr.add("250");

        arr.add("200");


        System.out.println(arr);

        for(String colors : arr){
            System.out.println(colors);
            String pen = colors;
            if(pen.equalsIgnoreCase("200")){
                arr.add("yellow");
            }
        }




    }
}

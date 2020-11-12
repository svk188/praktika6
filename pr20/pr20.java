package pr20;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

class Change {
    private String string="";
    private int max=100;
    void add(int elements){
        string+= elements==' '?'#':(char)elements;
        if(string.length()==max){
            try(FileWriter writer = new FileWriter("src/pr20/war2.txt", true)){
                writer.write(string);
                writer.flush();
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
            string="";
        }
    }
}
class Words {
    public String string;
    int kol=0;
    public Words(String str) {
        this.string = str;
        kol=1;
    }
}
public class pr20 {
    public static void main(String[] args) {
        int c;
        Change write= new Change();
        ArrayList<Words> words = new  ArrayList<>();
        boolean q;
        String temp="";
        String string="";
        try(FileWriter writer = new FileWriter("src/pr20/war2.txt", false)){
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

        int max=100;
        boolean flag;
        try(FileReader reader =new FileReader("src/pr20/war.txt")){
            while ((c=reader.read())!=-1){
                q=((c>=1040 && c<=1071)||(c>=1072 && c<=1103)||((char)c=='\''));
                write.add(c);
                if(q){
                    if(c>=1040 && c<=1071)
                        c+=1072-1040;
                    temp+=(char)c;
                }
                if(!temp.equals("")&&!q){
                    flag=false;
                    for(int j=0;j<words.size();++j){
                        if(words.get(j).string.equals(temp)){
                            ++words.get(j).kol;
                            flag=true;
                            break;
                        }
                    }
                    if(!flag) words.add(new Words(temp));
                    temp="";
                }
            }
            try(FileWriter writer = new FileWriter("src/pr20/war2.txt", true)){
                writer.write(string);
                writer.flush();
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
            string="";
            reader.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        int k=1;
        words.sort(Comparator.comparingInt(o -> o.kol));
        for (int i=words.size()-1;i>=words.size()-10;i--) {
            System.out.print(k + " место - ");
            System.out.println("\""+words.get(i).string + "\"" + " " + words.get(i).kol+ " раз");
            k++;
            }

    }
}


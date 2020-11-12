package pr20;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

class Change {
    private String string="";
    private int max=100;

    public Change() {
        try(FileWriter writer = new FileWriter("src/pr20/war2.txt", false)){
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    void add(int elements){
        string+= elements==' '?'#':(char)elements;
        if(string.length()==max) writeinFile();
    }

    void writeinFile(){
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
class Words {
    public String str;
    int kol=0;
    public Words(String str) {
        this.str = str;
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
                        if(words.get(j).str.equals(temp)){
                            ++words.get(j).kol;
                            flag=true;
                            break;
                        }
                    }
                    if(!flag) words.add(new Words(temp));
                    temp="";
                }
            }
            write.writeinFile();
            reader.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        int k=1;
        words.sort(Comparator.comparingInt(o -> o.kol));
        for (int i=words.size()-1;i>=words.size()-10;i--) {
            System.out.print(k + " ����� - ");
            System.out.println("\""+words.get(i).str + "\"" + " " + words.get(i).kol+ " ���");
            k++;
            }

    }
}


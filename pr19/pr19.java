package pr19;
import java.io.*;


public class pr19 {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    pr19() throws IOException {
        System.out.println("-----Реализовать запись в файл введённой с клавиатуры информации!-----");
        System.out.println("Введите название файла!");
        Write();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("-----Реализовать вывод информации из файла на экран!-----");
        OutPut();
        System.out.println("---------------------------------------------------------");
        System.out.println("-----Заменить информацию в файле на информацию, введённую с клавиатуры!-----");
        Rewritting();
        System.out.println("Результат выполнения!");
        OutPut();
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("-----Добавить в конец исходного файла текст!-----");
        AddLast();
        System.out.println("Результат выполнения!");
        OutPut();
        System.out.println("\n-------------------------------------------------");


    }

    void Write() throws IOException {
        OutputStream outputStream = new FileOutputStream("C://Users//pypki//IdeaProjects//pr9//src//pr19//" + reader.readLine());
        System.out.println("Введите информацию, которую хотите добавить! Конец ввода exit");
        while (true) {
            String data = reader.readLine();
            if (data.equals("exit")) {
                break;
            } else {
                outputStream.write((data + "\r\n").getBytes());
            }
        }
        System.out.println("Информация записана!");
        outputStream.close();
    }

    void OutPut() {
        try (FileReader reader2 = new FileReader("C://Users//pypki//IdeaProjects//pr9//src//pr19//txtx")) {
            int c;
            while ((c = reader2.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    void Rewritting()
    {
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите информацию,на которую хотите заменить! Конец ввода exit");
        try (FileWriter writer = new FileWriter("C://Users//pypki//IdeaProjects//pr9//src//pr19//txtx", false)) {
            while (true) {
                String text = reader2.readLine();
                if (text.equals("exit")) {
                    break;
                } else {
                    writer.write(text + "\n");
                    writer.flush();
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    void AddLast()

    {
        try (FileWriter writer = new FileWriter("C://Users//pypki//IdeaProjects//pr9//src//pr19//txtx", true)) {
            String text = "Hello World!";
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        pr19 Test = new pr19();
    }
}



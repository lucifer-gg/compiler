import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        Stack stack=new Stack();
        stack.push(new Token(-1,0,"S"));
        TokenQueue tokenQueue=readQueue("resource/input.txt");
        SyntanticAnalyzer syntanticAnalyzer=new SyntanticAnalyzer(tokenQueue,stack);
        ArrayList<String> res=syntanticAnalyzer.start();
        emptyFile("resource/output.txt");
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
            writeFile(res.get(i),"resource/output.txt");
        }


    }

    private static TokenQueue readQueue(String path) throws IOException {
        TokenQueue tokenQueue1=new TokenQueue();
        FileInputStream fis = new FileInputStream(path);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        line=br.readLine();
        while (line!=null) {
          String[] list1=line.split(" ");
          tokenQueue1.enqueue(new Token(1,Integer.parseInt(list1[2]),list1[0]));
          line=br.readLine();
        }
        tokenQueue1.enqueue(new Token(1,15,"$"));
        br.close();
        isr.close();
        fis.close();
        return tokenQueue1;

    }
    private static void writeFile(String s,String path) {
        FileWriter fw = null;
        try {
            File f=new File(path);
            fw = new FileWriter(f, true);

        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println(s);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void emptyFile(String filename){
        FileWriter fw = null;
        try {
            File f=new File(filename);
            fw = new FileWriter(f);
            fw.write("");
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

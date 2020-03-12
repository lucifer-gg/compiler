import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
        //这里做从文件中读取并且分割成单词数组
        LexicalAnalyzer lexicalAnalyzer;
        List<String> strlist=readFile("resource/input.txt");
        List<String>res=new ArrayList<String>();
        //处理单个单词
        for(int i=0;i<strlist.size();i++){
            lexicalAnalyzer=new LexicalAnalyzer(strlist.get(i));
            try{
                lexicalAnalyzer.isSpecial();
                lexicalAnalyzer.start();
            }catch (formatException e){
                String s="";
                if(e.getMsg().split("/").length==2){
                    System.out.println(e.getMsg().split("/")[0]+" "+e.getMsg().split("/")[1]+" "+strlist.get(i));
                    s+=(e.getMsg().split("/")[0]+" "+e.getMsg().split("/")[1]+" "+strlist.get(i));
                    res.add(s);
                }else{

                    if(e.getMsg().indexOf("ILLEGAL")==-1){
                        s+=e.getMsg()+" "+strlist.get(i)+" "+strlist.get(i);
                        res.add(s);
                        System.out.println(e.getMsg()+" "+strlist.get(i)+" "+strlist.get(i));
                    }else{
                        System.out.println(e.getMsg()+" "+strlist.get(i)+" "+strlist.get(i));

                    }

                }
            }
        }
        //输出到文件
        emptyFile("resource/output.txt");
        for(int i=0;i<res.size();i++){
            writeFile(res.get(i),"resource/output.txt");
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

    private static void readFileALL(String strFile){
        try{
            InputStream is = new FileInputStream(strFile);
            int iAvail = is.available();
            byte[] bytes = new byte[iAvail];
            is.read(bytes);
            is.close();
            String inputString=new String(bytes);
            System.out.println(bytes[1]);
            String res=inputString.replace("\n"," ");
            System.out.println(res);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static List<String> readFile(String path) throws IOException {
        List<String> list = new ArrayList<String>();
        FileInputStream fis = new FileInputStream(path);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while ((line = br.readLine()) != null) {
            if(line.length()==0){
                continue;
            }
            line=line.replaceAll("\\t"," ");
            line=line.trim();
            String test=line.replaceAll( "\\s{1,}", " " );
            String[] list1=test.split(" ");

            for(int i=0;i<list1.length;i++){
                list.add(list1[i]);
            }

        }
        br.close();
        isr.close();
        fis.close();
        return list;
    }
}


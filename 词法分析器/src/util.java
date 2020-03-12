public class util {
    public static  boolean isdigit(char achar){
        if(achar>=48&&achar<=57){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isletter(char achar){
        if(achar>=97&&achar<=122){
            return true;
        }else {
            return false;
        }
    }
    public static boolean isdot(char achar){
        if(achar=='.'){
            return true;
        }else{
            return false;
        }
    }
    public static int chartype(char achar){
        if(isdigit(achar)){
            return 0;
        }else if(isletter(achar)){
            return 1;
        }else if(isdot(achar)){
            return 2;
        }else{
            return 3;
        }
    }
}

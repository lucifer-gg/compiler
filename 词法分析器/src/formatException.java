
public class formatException extends Exception{
    private String msg;
    formatException(String string){
        msg=string;
    }
    public String getMsg(){
        return msg;
    }
}

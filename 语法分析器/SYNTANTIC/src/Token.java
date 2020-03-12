public class Token {
    private int type;
    private int no;
    private String str;

    public Token(int type,int no,String str){
        this.type=type;
        this.no=no;
        this.str=str;
    }

    public Token(){}
    public int getType(){
        return type;
    }
    public int getNo(){
        return no;
    }
    public String getStr() {
        return str;
    }
}

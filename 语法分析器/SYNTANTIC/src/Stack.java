import java.util.ArrayList;

public class Stack {
    private ArrayList<Token> tokenArrayList;
    public Stack(){
        tokenArrayList = new ArrayList<Token>();
        tokenArrayList.add(new Token(1,15,"$"));
    }

    public void push(Token t){
        tokenArrayList.add(t);
    }

    public void pop(){
        tokenArrayList.remove(tokenArrayList.size() - 1);
    }

    public Token get(){
        return tokenArrayList.get(tokenArrayList.size() - 1);
    }

}

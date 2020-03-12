import java.util.ArrayList;

public class TokenQueue {
    private ArrayList<Token> tokenArrayList;

    public TokenQueue() {
        tokenArrayList = new ArrayList<Token>();

    }
    public Token getFirst(){
        return tokenArrayList.get(0);
    }

    public void dequeue(){
        tokenArrayList.remove(0);
    }

    public void enqueue(Token token){
       tokenArrayList.add(token);
    }

    public int getsize(){
        return tokenArrayList.size();
    }


}

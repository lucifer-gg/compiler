import java.util.ArrayList;

public class SyntanticAnalyzer {
    private  TokenQueue tokenQueue;
    private  Stack stack;
    private ArrayList<String> res;
    //LL(1)预测分析表
    private int parsingTable[][]={
            {0,-1,-1,1,-1,-1,-1,-1,-1,2,-1,-1,-1,-1,-1,-1},
            {3,-1,-1,-1,3,-1,-1,-1,-1,-1,-1,-1,3,-1,-1,-1},
            {-1,-1,5,-1,-1,5,-1,-1,-1,-1,4,-1,-1,-1,-1,5},
            {6,-1,-1,-1,6,-1,-1,-1,-1,-1,-1,-1,6,-1,-1,-1},
            {-1,-1,8,-1,-1,8,-1,-1,-1,-1,8,7,-1,-1,-1,8},
            {10,-1,-1,-1,9,-1,-1,-1,-1,-1,-1,-1,11,-1,-1,-1},
            {12,-1,-1,-1,12,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,14,-1,-1,-1,-1,-1,-1,-1,13,-1,14},
            {16,-1,-1,-1,15,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}


    };

    //语法规则表
    private Grammar grammarlist[]=new Grammar[17];
    public SyntanticAnalyzer(TokenQueue tokenQueue,Stack stack){
        this.tokenQueue=tokenQueue;
        this.stack=stack;
        res=new ArrayList<String>();
        for(int i=0;i<=16;i++){
            grammarlist[i]=new Grammar(i);
        }

    }

    public ArrayList<String> start(){
        Token stackTop;
        Token queueTop;
        while(true) {
            stackTop = stack.get();
            queueTop = tokenQueue.getFirst();
            if(stackTop.getNo()==15&&queueTop.getNo()==15){
                return res;
            }
            else if(stackTop.getNo()==15&&queueTop.getNo()!=15){
                res.clear();
                res.add("can not construct a parsing tree");
                return res;
            }
            else if(stackTop.getNo()!=15&&queueTop.getNo()==15){
                res.clear();
                res.add("can not construct a parsing tree");
                return res;
            }
            else{
                if(stackTop.getType()==1){
                    //栈顶和队首都是终结符
                    if(stackTop.getNo()==queueTop.getNo()){
                        stack.pop();
                        tokenQueue.dequeue();
                        continue;
                    }
                    else{
                        //错误处理
                        res.clear();
                        res.add("can not construct a parsing tree");
                        return res;
                    }
                }else{
                    //栈顶为非终结符
                    stack.pop();
                    //根据表推导
                    if(parsingTable[stackTop.getNo()][queueTop.getNo()]==-1){
                        res.clear();
                        res.add("can not construct a parsing tree");
                        return res;
                    }
                    grammarlist[parsingTable[stackTop.getNo()][queueTop.getNo()]].addGrammarToRes(res);
                    grammarlist[parsingTable[stackTop.getNo()][queueTop.getNo()]].addToStack(stack);
                    continue;
                }
            }
        }
    }
}

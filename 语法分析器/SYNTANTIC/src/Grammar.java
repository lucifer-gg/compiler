import java.util.ArrayList;

public class Grammar {
    private int no;
    private ArrayList<Token> tokenArrayList=new ArrayList<>();
    public Grammar(int no){
        this.no=no;
        start(no);
    }
    public void addToStack(Stack stack){
        for(int i=0;i<tokenArrayList.size();i++){
            stack.push(tokenArrayList.get(i));
        }

    }
    public void addGrammarToRes(ArrayList<String> arrayList){
        if(no==0){
            //System.out.println("S->id = E");
            arrayList.add("S->id = E");
        }else if(no==1){
           // System.out.println("S->if(C){S}else{S}");
            arrayList.add("S->if(C){S}else{S}");
        }else if(no==2){
           // System.out.println("S->while(C){S}");
            arrayList.add("S->while(C){S}");
        }else if(no==3){
           // System.out.println("E->T E'");
            arrayList.add("E->T E'");
        }else if(no==4){
            //System.out.println("E'->+ T E'");
            arrayList.add("E'->+ T E'");
        }else if(no==5){
            //System.out.println("E'->ε");
            arrayList.add("E'->ε");
        }else if(no==6){
            //System.out.println("T->F T'");
            arrayList.add("T->F T'");
        }else if(no==7){
            //System.out.println("T'->* F T'");
            arrayList.add("T'->* F T'");
        }else if(no==8){
            //System.out.println("T'->ε");
            arrayList.add("T'->ε");
        }else if(no==9){
            //System.out.println("F->( E )");
            arrayList.add("F->( E )");
        }else if(no==10){
            //System.out.println("F->id");
            arrayList.add("F->id");
        }else if(no==11){
            //System.out.println("F->num");
            arrayList.add("F->num");
        }else if(no==12){
            //System.out.println("C->D C'");
            arrayList.add("C->D C'");
        }else if(no==13){
            //System.out.println("C'->LO D C'");
            arrayList.add("C'->LO D C'");
        }else if(no==14){
            //System.out.println("C'->ε");
            arrayList.add("C'->ε");
        }else if(no==15){
            //System.out.println("D->(C)");
            arrayList.add("D->(C)");
        }else if(no==16){
            //System.out.println("D->id CO num");
            arrayList.add("D->id CO num");
        }
    }

    private void start(int no){
        if(no==0){
            tokenArrayList.add(new Token(1,2,";"));
            tokenArrayList.add(new Token(-1,1,"E"));
            tokenArrayList.add(new Token(1,1,"="));
            tokenArrayList.add(new Token(1,0,"id"));

        }else if(no==1){
            tokenArrayList.add(new Token(1,7,"}"));
            tokenArrayList.add(new Token(-1,0,"S"));
            tokenArrayList.add(new Token(1,6,"{"));
            tokenArrayList.add(new Token(1,8,"else"));
            tokenArrayList.add(new Token(1,7,"}"));
            tokenArrayList.add(new Token(-1,0,"S"));
            tokenArrayList.add(new Token(1,6,"{"));
            tokenArrayList.add(new Token(1,5,")"));
            tokenArrayList.add(new Token(-1,6,"C"));
            tokenArrayList.add(new Token(1,4,"("));
            tokenArrayList.add(new Token(1,3,"if"));


        }else if(no==2){
            tokenArrayList.add(new Token(1,7,"}"));
            tokenArrayList.add(new Token(-1,0,"S"));
            tokenArrayList.add(new Token(1,6,"{"));
            tokenArrayList.add(new Token(1,5,")"));
            tokenArrayList.add(new Token(-1,6,"C"));
            tokenArrayList.add(new Token(1,4,"("));
            tokenArrayList.add(new Token(1,9,"while"));



        }else if(no==3){
            tokenArrayList.add(new Token(-1,2,"E'"));
            tokenArrayList.add(new Token(-1,3,"T"));


        }else if(no==4){
            tokenArrayList.add(new Token(-1,2,"E'"));
            tokenArrayList.add(new Token(-1,3,"T"));
            tokenArrayList.add(new Token(1,10,"+"));

        }else if(no==5){

        }else if(no==6){
            tokenArrayList.add(new Token(-1,4,"T'"));
            tokenArrayList.add(new Token(-1,5,"F"));

        }else if(no==7){
            tokenArrayList.add(new Token(-1,4,"T'"));
            tokenArrayList.add(new Token(-1,5,"F"));
            tokenArrayList.add(new Token(1,11,"*"));

        }else if(no==8){

        }else if(no==9){
            tokenArrayList.add(new Token(1,5,")"));
            tokenArrayList.add(new Token(-1,1,"E"));
            tokenArrayList.add(new Token(1,4,"("));

        }else if(no==10){
            tokenArrayList.add(new Token(1,0,"id"));

        }else if(no==11){
            tokenArrayList.add(new Token(1,12,"num"));

        }else if(no==12){
            tokenArrayList.add(new Token(-1,7,"C'"));
            tokenArrayList.add(new Token(-1,8,"D"));

        }else if(no==13){
            tokenArrayList.add(new Token(-1,7,"C'"));
            tokenArrayList.add(new Token(-1,8,"D"));
            tokenArrayList.add(new Token(1,13,"L'"));

        }else if(no==14){


        }else if(no==15){
            tokenArrayList.add(new Token(1,5,")"));
            tokenArrayList.add(new Token(-1,6,"C"));
            tokenArrayList.add(new Token(1,4,"("));

        }else if(no==16){

            tokenArrayList.add(new Token(1,12,"num"));
            tokenArrayList.add(new Token(1,14,"C'"));
            tokenArrayList.add(new Token(1,0,"id"));

        }

    }
}

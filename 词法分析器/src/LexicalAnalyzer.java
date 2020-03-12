public class LexicalAnalyzer {
    private String word="";
    private int len;
    private int ptr;
    private int state=0;


    LexicalAnalyzer(String s){
        word=s;
        len=s.length();
        ptr=0;

    }
    public void start() throws formatException{
        char aChar;
        int charstate=-1;//0代表读入的字符为digit，1代表letter，2代表dot，3代表读入的不是可以识别的字符

        while(true){
           aChar=getChar();
           if(aChar=='\0'){
               switch (state){
                   case 1:
                   case 3:
                   case 7:throw new formatException("NUMBER");
                   case 2:throw new formatException("ID");
                   case 6:throw new formatException("MYREG1");
                   case 4:
                   case 9:throw new formatException("MYREG2");
                   default:throw new formatException("ERROR");
               }
           }
           charstate=util.chartype(aChar);
           switch (state){
               case 0:
                   switch (charstate){
                       case 0:state=1;break;
                       case 1:state=2;break;
                       case 2:
                           throw new formatException("ILLEGAL_GRAMMAR");
                       case 3:
                           throw new formatException("ILLEGAL_CHAR");
                   }
                   break;
               case 1:
                   switch (charstate){
                       case 0:state=3;break;
                       case 1:state=4;break;
                       case 2:state=5;break;
                       case 3:
                           throw new formatException("ILLEGAL_CHAR");
                   }
                   break;
               case 2:
                   switch (charstate){
                       case 0:
                       case 1:state=2;break;
                       case 2:
                           throw new formatException("ILLEGAL_GRAMMAR");
                       case 3:
                           throw new formatException("ILLEGAL_CHAR");
                   }
                   break;
               case 3:
                   switch (charstate){
                       case 0:state=3;break;
                       case 2:state=5;break;
                       case 1:
                           throw new formatException("ILLEGAL_GRAMMAR");
                       case 3:
                           throw new formatException("ILLEGAL_CHAR");
                   }
                   break;
               case 4:
                   switch (charstate){
                       case 0:state=6;break;
                       case 1:
                       case 2:
                           throw new formatException("ILLEGAL_GRAMMAR");
                       case 3:
                           throw new formatException("ILLEGAL_CHAR");

                   }
                   break;

               case 5:
                   switch (charstate){
                       case 0:state=7;break;
                       case 1:
                       case 2:
                           throw new formatException("ILLEGAL_GRAMMAR");
                       case 3:
                           throw new formatException("ILLEGAL_CHAR");

                   }
                   break;
               case 6:
                   switch (charstate){
                       case 0:state=8;break;
                       case 1:state=4;break;
                       case 2:
                           throw new formatException("ILLEGAL_GRAMMAR");
                       case 3:
                           throw new formatException("ILLEGAL_CHAR");
                   }
                   break;
               case 7:
                   switch (charstate){
                       case 0:break;
                       case 1:
                       case 2:
                           throw new formatException("ILLEGAL_GRAMMAR");
                       case 3:
                           throw new formatException("ILLEGAL_CHAR");
                   }
                   break;
               case 8:
                   switch (charstate){
                       case 0:state=8;break;
                       case 1:state=9;break;
                       case 2:
                           throw new formatException("ILLEGAL_GRAMMAR");
                       case 3:
                           throw new formatException("ILLEGAL_CHAR");
                   }
                   break;
               case 9:
                   switch (charstate){
                       case 0:state=8;break;
                       case 1:
                       case 2:
                           throw new formatException("ILLEGAL_GRAMMAR");
                       case 3:
                           throw new formatException("ILLEGAL_CHAR");
                   }
                   break;
           }

        }





    }
    public void isSpecial() throws formatException{
        switch (word){
            case "then":throw new formatException("THEN/null");
            case "else":throw new formatException("ELSE/null");
            case "public":throw new formatException("PUBLIC/null");
            case "static":throw new formatException("STATIC/null");
            case "if":throw new formatException("IF/null");
            case "main":throw new formatException("MAIN/null");
            case "while":throw new formatException("WHILE/null");
            case "do":throw new formatException("DO/null");
            case "=":throw new formatException("RELOPE/E");
            case "==":throw new formatException("RELOPE/EQ");
            case ">":throw new formatException("RELOPE/GT");
            case ">=":throw new formatException("RELOPE/GE");
            case "<":throw new formatException("RELOPE/LT");
            case "<=":throw new formatException("RELOPE/LE");
            case "!=":throw new formatException("RELOPE/NE");
        }

    }




    private char getChar(){
        if(ptr<len){
            ptr+=1;
            return word.charAt(ptr-1);
        }else{
            return '\0';
        }

    }

}

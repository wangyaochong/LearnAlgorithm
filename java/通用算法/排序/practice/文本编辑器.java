package 通用算法.排序.practice;
import java.util.Scanner;
public class 文本编辑器 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s = scanner.nextLine();
        int opCount=Integer.parseInt(s);
        int caseNumber=1;
        while(opCount>0){
            String input="";
            String s1 = scanner.nextLine();
            int inputCount=Integer.parseInt(s1);
            while(inputCount>0){
                input+=scanner.nextLine().trim();
                inputCount--;
            }
            System.out.println("Case "+caseNumber+":");
            processString(input);
            opCount--;
            caseNumber++;
        }
    }
    public static void processString(String str){
        int currentIndex=0;
        StringBuilder result=new StringBuilder();
        int resultIndex=0;
        while(currentIndex<str.length()){
            switch (str.charAt(currentIndex)){
                case '1':
                    result.insert(resultIndex,str.charAt(currentIndex+1));//插入
                    resultIndex++;
                    currentIndex+=2;
                    break;
                case '2':
                    result.replace(resultIndex-1,resultIndex,"");//删除
                    resultIndex--;
                    currentIndex++;
                    break;
                case '3':
                    if(resultIndex>0){
                        resultIndex--;
                    }
                    currentIndex++;
                    break;
                case '4':
                    if(resultIndex<result.length()){
                        resultIndex++;
                    }
                    currentIndex++;
                    break;
                case '5':
                    if(resultIndex==0){//如果光标在最前面
                        System.out.print("|");
                    }
                    for(int i=0;i<result.length();i++){
                        System.out.print(result.charAt(i));
                        if(resultIndex==i+1){
                            System.out.print('|');
                        }
                    }
                    System.out.println();
                    currentIndex++;
                    break ;
            }
        }
    }
}

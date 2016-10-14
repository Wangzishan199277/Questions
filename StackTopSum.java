import java.util.*;
public class StackTopSum{
    public static class StackCalculator{
        Map<Integer, Integer> hash;
        int pos;
        int pushed;
        int poped;
        
        StackCalculator(){
            pos = 0;
            pushed = 0;
            poped = 0;
            hash = new HashMap<Integer, Integer>();
        }
        
        void update(Stack<Integer> input_stack, int value){
            if(input_stack.size() > hash.size()){
                hash.put(pos, poped-pushed);
                pos -= 1;
                pushed += value;
            }else{
                pos += 1;
                hash.remove(pos);
                poped += value;
            }
        }
        
        int getSum(Stack<Integer> input_stack, int x) {
            if(hash.isEmpty()){
                init(input_stack);
            }
            return hash.get(x+pos) + pushed - poped;
        }
        
        void init(Stack<Integer> input_stack) {
            Stack<Integer> copy_stack = new Stack<Integer>();
            copy_stack.addAll(input_stack);
            int sum = 0;
            int size = copy_stack.size();
            for(int i = 1; i <= 10; i++) {
                sum += copy_stack.peek();
                hash.put(i, sum);
                copy_stack.pop();
            }
        }
    }
    public static void main(String []args){
        Stack<Integer> input_stack = new Stack<Integer>();
        for(int i = 1; i <= 10; i++) {
            input_stack.push(i);
        }
        StackCalculator calculator = new StackCalculator();
        // calculator.init(input_stack);
        for(int i =1; i <= 10; i++) {
            System.out.println(calculator.getSum(input_stack, i));
        }
        
        input_stack.push(11);
        // System.out.println(input_stack.size());
        // for(int i =1; i <= 11; i++) {
        //     System.out.println(calculator.hash.get(i));
        // }
        calculator.update(input_stack, 11);
        System.out.println("push an int 11");
        for(int i =1; i <= 11; i++) {
            System.out.println(calculator.getSum(input_stack, i));
        }
        
        Integer temp = input_stack.pop();
        calculator.update(input_stack, temp);
        System.out.println("pop top 11");
        for(int i =1; i <= 10; i++) {
            System.out.println(calculator.getSum(input_stack, i));
        }
    }
}

10                                                                                                                                                                                                                        
19                                                                                                                                                                                                                        
27                                                                                                                                                                                                                        
34                                                                                                                                                                                                                        
40                                                                                                                                                                                                                        
45                                                                                                                                                                                                                        
49                                                                                                                                                                                                                        
52                                                                                                                                                                                                                        
54                                                                                                                                                                                                                        
55                                                                                                                                                                                                                        
push an int 11
11                                                                                                                                                                                                                        
21                                                                                                                                                                                                                        
30                                                                                                                                                                                                                        
38                                                                                                                                                                                                                        
45                                                                                                                                                                                                                        
51                                                                                                                                                                                                                        
56                                                                                                                                                                                                                        
60                                                                                                                                                                                                                        
63                                                                                                                                                                                                                        
65                                                                                                                                                                                                                        
66                                                                                                                                                                                                                        
pop top 11
10                                                                                                                                                                                                                        
19                                                                                                                                                                                                                        
27                                                                                                                                                                                                                        
34                                                                                                                                                                                                                        
40                                                                                                                                                                                                                        
45                                                                                                                                                                                                                        
49                                                                                                                                                                                                                        
52                                                                                                                                                                                                                        
54                                                                                                                                                                                                                        
55                                                                                                                                                                                                                

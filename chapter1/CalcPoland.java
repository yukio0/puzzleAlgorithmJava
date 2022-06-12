package chapter1;

import java.util.List;
import java.util.ArrayList;

class CalcPoland{
    public static void main(String args[]){
        String exp = args[0];
        System.out.println(calcPoland(exp));
    }

    public static Double calcPoland(String exp){
        List<Double> space = new ArrayList<Double>();

        for(char c : exp.toCharArray()){
            if(c >= '0' && c <= '9'){
                int add = c - '0';
                space.add(space.size(), Double.valueOf(add));
            }
            else{
                Double second = space.get(space.size() - 1);
                space.remove(space.size() - 1);
                Double first = space.get(space.size() - 1);
                space.remove(space.size() - 1);

                if(c == '+')
                    space.add(space.size(), first + second);
                else if(c == '-')
                    space.add(space.size(), first - second);
                else if(c == '*')
                    space.add(space.size(), first * second);
                else
                    space.add(space.size(), first / second);
            }
        }
        return space.get(0);
    }
}
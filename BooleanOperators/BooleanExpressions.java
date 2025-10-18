package BooleanOperators;
public class BooleanExpressions {
    /**
     * @param args
     */
    public static void main(String[] args) {
        int x = 1;
        
        System.out.println("Given x = " + x + "\n");
        
        // Expression 1: (true) && (3 > 4)
        System.out.println("(true) && (3 > 4)");
        System.out.println("= true && false");
        System.out.println("= " + ((true) && (3 > 4)));
        System.out.println();
        
        // Expression 2: !(x > 0) && (x > 0)
        System.out.println("!(x > 0) && (x > 0)");
        System.out.println("= !(1 > 0) && (1 > 0)");
        System.out.println("= !true && true");
        System.out.println("= false && true");
        System.out.println("= " + (!(x > 0) && (x > 0)));
        System.out.println();
        
        // Expression 3: (x > 0) || (x < 0)
        System.out.println("(x > 0) || (x < 0)");
        System.out.println("= (1 > 0) || (1 < 0)");
        System.out.println("= true || false");
        System.out.println("= " + ((x > 0) || (x < 0)));
        System.out.println();
        
        // Expression 4: (x != 0) || (x == 0)
        System.out.println("(x != 0) || (x == 0)");
        System.out.println("= (1 != 0) || (1 == 0)");
        System.out.println("= true || false");
        System.out.println("= " + ((x != 0) || (x == 0)));
        System.out.println();
        
        // Expression 5: (x >= 0) || (x < 0)
        System.out.println("(x >= 0) || (x < 0)");
        System.out.println("= (1 >= 0) || (1 < 0)");
        System.out.println("= true || false");
        System.out.println("= " + ((x >= 0) || (x < 0)));
        System.out.println();
        
        // Expression 6: (x != 1) == !(x == 1)
        System.out.println("(x != 1) == !(x == 1)");
        System.out.println("= (1 != 1) == !(1 == 1)");
        System.out.println("= false == !true");
        System.out.println("= false == false");
        System.out.println("= " + ((x != 1) == !(x == 1)));


        //3.10.2 
        //(a) Write a Boolean expression that evaluates to true if a number stored in variable num is between 1 and 100. 
        //(b) Write a Boolean expression that evaluates to true if a number stored in variable num is between 1 and 100 or the number is negative.
        System.out.println("= " + ((x >= 1) && (x <= 100)));
        System.out.println("= " + ((x >= 1) && (x <= 100) || (x < 0)));

        //(a) Write a Boolean expression for � x - 5� 6 4.5. (b) Write a Boolean expres- sion for � x - 5� 7 4.5.
    }
}
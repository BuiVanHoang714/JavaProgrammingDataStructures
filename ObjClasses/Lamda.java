package ObjClasses;

@FunctionalInterface
interface Operation {
    int execute(int a, int b);
}
// 2. Truyền Lambda qua Method Parameter

class Calculator {
    // Method nhận lambda/behavior như parameter
    public int calculate(int x, int y, Operation op) {
        return op.execute(x, y);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // Truyền lambda expression
        int result1 = calc.calculate(5, 3, (a, b) -> a + b);
        System.out.println("Plus: " + result1); // 8

        int result2 = calc.calculate(5, 3, (a, b) -> a * b);
        System.out.println("Mutiple: " + result2); // 15
    }
}
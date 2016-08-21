package _01_ElementsJava._05_Branches;

public class C05_Ternary {
    // Тернарная условная операция.

    // Тернарный (троичный) оператор [?:] .
    // Тернарный оператор [?:], является сокращенной формой конструкции if ... else.
    // [?:] - включает в себя три операнда - ( условие ? Если условие ИСТИННО : Если условие ЛОЖНО )

    // Алгоритм работы тернарной операции: (логическое выражение) ? выражение 1 : выражение 2
    //    1. Вычисляется логическое выражение (условие).
    //    2. Если логическое выражение истинно, то вычисляется значение выражения выражение 1, в противном случае - значение выражения выражение 2.
    //    3. Вычисленное значение возвращается.

    public static void main(String[] args) {
        int a = 1, b = 2, max = 0;

        // Переменной max, присваиваем возвращаемое значение тернарного оператора.

        max = (a > b) ? a : b;   // ЕСЛИ:  (a > b)  ТО:  вернуть a  ИНАЧЕ: вернуть b;
        System.out.println(max);
    }
}

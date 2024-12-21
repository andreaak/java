package com.java._01_ElementsJava._07_Methods;

public class _04_MethodsMainOverload {

    public static void main(String[] args) {
        if (args.length > 0)  // если через консоль были введены аргументы
            System.out.println(args[0]);  //то вывести на консоль первый элемент из массива

        else {  //иначе —
            _04_MethodsMainOverload obj = new _04_MethodsMainOverload(); //создать объект
            main(); // и использовать обычный метод с названием main()
        }
    }

    public static void main() {  // это обычный метод с названием main()
        System.out.println("it's usual main method without String[] args!");
    }
}

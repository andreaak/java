package _01_ElementsJava._05_Branches.Logic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class _01_Logic {

    // Побитовые логические операции. (&, |)

    // Например:
    // Мы имеем порт ввода/вывода или регистр с определенным значением в нем.
    // Нам необходимо включить устройство управляемое первым битом, установив первый бит в 1.
    // После нам потребуется выключить устройство, сбросив первый бит в 0.
    //  1 1 1 1   0 0 0 0  -  начальное значение порта ввода/вывода.
    //  7 6 5 4   3 2 1 0  -  нумерация битов управления устройствами.

	@Test
	public void TstLogicBytes() {
        byte port = 0b1110000;     // 0 1 1 1   0 0 0 0  -  начальное значение порта ввода/вывода.
        byte mask = 0b0000010;     // 0 0 0 0   0 0 1 0  -  маска включения устройства управляемого первым битом.
        System.out.println("port = " + port); // ситуация с лампочкой в комнате

        port = (byte)(port | mask);  // Включить устройство управляемое первым битом.
        System.out.println("port = " + port);

        mask = 0b1111101;          // 0 1 1 1   1 1 0 1  -  Создаем маску выключения устройства управляемого первым битом.

        port = (byte)(port & mask);  // Выключить устройство управляемое первым битом.
        System.out.println("port = " + port);
    }
    
    // Побитовые логические операции. (^)

    // Например:
    // Используя операцию XOR, мы можем зашифровать сообщение.
    // В таком виде шифрования используется один ключ, как для шифрования, так и для расшифровки.
    // Криптостойкость такого ключа, можно увеличить, если увеличить его длину.

	@Test
	public void TstLogicXor() {
        short secretKey = 0b0101;   // Секретный ключ (длина - 16 bit).
        char character = 'A';      // Исходный символ для шифрования.

        System.out.println("Исходный символ: " + character + ", его код в кодовой таблице: " + (byte)character);

        // Зашифровываем символ. character = 0100 0001 (65)
        character = (char)(character ^ secretKey); // 0100 0001 ^  0000 0101
        System.out.println("Зашифрованный символ: " + character + ", его код в кодовой таблице: " + (byte) character);

        // Расшифровываем символ. character  = 0100 0100 (68)
        character = (char)(character ^ secretKey); // 0100 0100 ^ 0000 0101
        System.out.println("Расшифрованный символ: " + character + ", его код в кодовой таблице: " + (byte) character);
    }
    
    // Логические операции.

	@Test
	public void TstLogicBoolean() {
		
        boolean operand1 = false, operand2 = false, result = false;

        // Конъюнкция

        // Таблица истинности для Конъюнкции (И) - && - [AND]

        // Если хоть одно из выражений операции операции конъюнкции имеет значение false -
        // все выражение имеет значение false, иначе - true

        // false && false = false                  true && false = false
        // false && true = false                   true && true = true

        operand1 = true;                           // true
        operand2 = false;                          // false
        result = operand1 && operand2;             // false

        System.out.println(operand1 + " AND " + operand2 + " = " + result);

        // Дизъюнкция

        // Таблица истинности для Дизъюнкции (ИЛИ) - || - [OR]

        // Если хоть одно из выражений операции операции Дизъюнкции имеет значение true -
        // все выражение имеет значение true, иначе - false

        // false || false = false                  true || false = true
        // false || true = true                    true || true = true

        operand1 = true;                           // true
        operand2 = false;                          // false
        result = operand1 || operand2;             // true

        System.out.println(operand1 + " OR " + operand2 + " = " + result);

        // Исключающее ИЛИ

        // Таблица истинности для Исключающего ИЛИ - ^ - [XOR]

        // Если оба выражения операции Исключающего ИЛИ имеют одинакое значение -
        // все выражение имеет значение false, если разные - true

        // false ^ false = false                   true ^ false = true
        // false ^ true = true                     true ^ true = false

        operand1 = true;                           // true
        operand2 = false;                          // false
        result = operand1 ^ operand2;              // true

        System.out.println(operand1 + " XOR " + operand2 + " = " + result);

        // Отрицание

        // Таблица истинности для Отрицания (НЕТ) - ! - [NOT]

        // !false  = true
        // !true  = false

        operand1 = true;
        result = !operand1;

        System.out.println("NOT " + operand1 + " = " + result);
    }
    
    // Логические операции.

    // Например:
    // Чтобы проверить условие A < x < B, нельзя записать его в условном операторе непосредственно,
    // так как каждая операция отношения должна иметь два операнда.
    // Правильный способ записи: if ( A < x && x < B).

	@Test
	public void TstLogic() {
        int a = 0, b = 5, x = 3;

        if (a < x && x < b) {   // a < x < b
            System.out.println("Число " + x + " находится в диапазоне чисел от " + a + "  до " + b + ".");
        } else {
            System.out.println("Число " + x + " не попадает в диапазон чисел от " + a + "  до " + b + ".");
        }
    }
    
    // Логический Сдвиг  (shift).

    @Test
	public void TstLogicShift() {
    	
        byte operand = 0b0000001;              // 0000 0001
        System.out.println("Число до сдвига: " + operand);

        // Логический сдвиг числа влево.

        operand = (byte)(operand << 2);   // 0000 0100
        System.out.println("Число после сдвига влево: " + operand);

        // Логический сдвиг числа вправо.

        operand = (byte)(operand >> 1);   // 0000 0010

        System.out.println("Число после сдвига вправо: " + operand);
    }
    
    //  КОРОТКОЗАМКНУТОЕ ВЫЧИСЛЕНИЕ - техника работающая по следующему принципу:
    //  Если значение первого операнда в операции AND (&&) ложно, то второй операнд не вычисляется,
    //  потому что полное выражение в любом случае будет ложным.

	@Test
	public void TstShortLogicComputing() {
        final int MIN_VALUE = 1;
        int denominator = 0;
        int item = 2;

        // Условие, которое работает с использованием техники КОРОТКОЗАМКНУТОГО ВЫЧИСЛЕНИЯ.
        // Если бы это выражение вычислялось полностью, то операция деления во втором операнде,
        // генерировала бы ошибку деления на 0.

        if ((denominator != 0) && (item / denominator) > MIN_VALUE) {   // Оставьте один оператор &
            System.out.println("Мы в блоке IF");
        } else {
            System.out.println("Мы в блоке ELSE");
        }
    }
}

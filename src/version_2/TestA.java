package version_2;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by vlad on 13.09.16.
 */
public class TestA {
    /*
    static final int number = 100;
    static Random randomForTests = new Random();

    static void test1(A[] data) {
        System.out.println("test_1:");
        for (int i = 0; i < data.length; i++) {
            if (data[i].hashCode() == data[i].hashCode()) {
                //    System.out.println("OK");
            } else {
                System.out.println("Not OK");
            }
        }
    }

    static void test2(A[] data) {
        System.out.println("test_2:");
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(data[i])) {
                //    System.out.println("OK");
            } else {
                System.out.println("Not OK");
            }
        }
    }

    static void test3(A[] data) {
        System.out.println("test_3:");
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(data[i].copy())) {
                //    System.out.println("OK");
            } else {
                System.out.println("Not OK");
            }
        }
    }

    static void test4(A[] data) {
        System.out.println("test_4:");
        int randomIndex = randomForTests.nextInt(number);
        for (int i = 0; i < data.length; i++) {
            if (!data[i].equals(data[randomIndex])) { //СОКРАТИТЬ!!! (переписать в три строчки)

                if (data[i] != data[randomIndex]) {
                    //System.out.println("OK");

                } else {
                    System.out.println("Not OK");
                }
            }
        }
    }
    // По-моему этот тест просто неверн. Нужно будет удалить его отсюда.
    static void test5(A[] data) {
        System.out.println("test_5:");
        int randomIndex = randomForTests.nextInt(number);
        for (int i = 0; i < data.length; i++) {
            if (data[i].hashCode() != data[randomIndex].hashCode()) {

                //if (data[i] != data[randomIndex]) { // 6) НЕВЕРНЫЙ ТЕСТ!
                if (!data[i].equals(data[randomIndex])) { //6) вроде исправил //СОКРАТИТЬ кол-во полей!!!
                } else {
                    System.out.println("Not OK");
                }
            }
        }

    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        A test = new A();

        Field intField = null;
        Field listField = null;
        Field enumField = null;

        Field[] fields = test.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            //System.out.println("name: " + field.getName() + " type: " + field.getType());

            if (field.getType() == int.class) {
                intField = field;
                continue;
            }
            if (field.getType() == SomeTestEnum.class) {
                enumField = field;
                continue;
            }
            if (List.class.isAssignableFrom(field.getType())) {
                ParameterizedType myType = (ParameterizedType) field.getGenericType();
                //Object myParam = myType.getActualTypeArguments();

                if (myType.getActualTypeArguments().length > 0 && myType.getActualTypeArguments()[0] == String.class) {
                    listField = field;
                }
            }

        }

        // 7) Изменить подход использования Reflection! Чтобы поля не были захардкожены. Выше попробовал начать исправлять, но не понял как же так сделать.
        //------------------------------------------------------------

        // Это реализовали в цикле
        //Field intField = test.getClass().getDeclaredField("a");
        //intField.setAccessible(true);
        if (intField!= null) {
            int initialValue = 1;
            intField.setInt(test, initialValue);
        }

        //------------------------------------------------------------

        // Это реализовали в цикле
        //Field listField = test.getClass().getDeclaredField("someList");
        //listField.setAccessible(true);
        if (listField != null) {
            List<String> initialList = new ArrayList<>();
            initialList.add("qwerty");
            listField.set(test, initialList);
        }


        //------------------------------------------------------------

        // Это реализовали в цикле
        //Field enumField = test.getClass().getDeclaredField("ste");
       // enumField.setAccessible(true);
        if (enumField != null) {
            SomeTestEnum initialEnum = SomeTestEnum.FIRST;
            enumField.set(test, initialEnum);
        }

        //------------------------------------------------------------


        System.out.println("-----------------------------------------");

        System.exit(0);


    }
    */

}

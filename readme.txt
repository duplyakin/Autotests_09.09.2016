Задача:
1) Нужно создать класс полями различных типов и реаизовать методы hashCode, equals, copy 

2)Написать тестовую функцию testClass, которая будет с помощью Reflection заполнять этот класс и проверять правильность работы функций: hashCode, equals, copy 

3)Написать Generator, который будет генерировать объекты этого класса ( например если есть поле int в классе, то в этом генераторе будет вызов nextInt() , который присвоит полю нового объекта новое значение 

4) Также нужно подумать о расширяемости программы. Дело в том, что впоследствии нужно будет тестировать не один класс, а много доменных классов которые реализуют какой-то один интерфейс.

5) Автоматизировать сбор тестов - чтобы для нового класса тесты писались автоматически.

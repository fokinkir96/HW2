# HW2
This is project on Java for FinUni.

В среде IntelliJ IDEA Community Edition надо создать проект HW2.

В проекте надо создать Java-классы «Дерево» и «Узел дерева», соответствующие первому домашнему заданию.

Надо создать два варианта соединения с БД по jdbc: с PostgreSQL и с H2. При этом название БД, пользователя, пароль и т.п. можно задать в константах Java или в файле свойств. (Соответственно надо приложить драйверы для этих СУБД, которые можно использовать как для ОС Windows, так и для ОС Linux). Для этого надо создать Java-интерфейс или абстрактный класс, затем в двух классах (один из которых будет соответствовать PostgreSQL, а другой - H2) его имплементировать для каждой базы данных с учетом их особенностей. В случае интерфейса можно создать промежуточный класс, в который вынести общую функциональность этих классов.

Параметры должны иметь следующие значения:

СУБД - H2

·       Пользователь:    userTree

·       Пароль пользователя:    pass

·       URL:    jdbc:h2:~/treeDB

СУБД - PostgreSQL

·       Пользователь:    userTree

·       Пароль пользователя:    pass

·       URL:    jdbc:postgresql://localhost/treeDB


Далее надо создать класс и метод этого класса, который прочитает (через jdbc) содержимое таблицы БД, с которой установлено соединение, и построит по прочитанным данным список деревьев.  (По аналогии с первым домашним заданием).

Таблица называется TREES, состоит из двух полей целого типа: id (т.е. id узла) и parent_id (т.е id родительского узла). Для каждого дерева корень дерева в «id родительского узла» содержит ссылку сам на себя (т.е. значения полей id и parent_id в строке, соответствующей корню дерева, совпадают).

Надо разработать функцию, которая для списка деревьев находит суммарное количество листов во всех деревьях.

В классе Main функция public static void main должна прочитать таблицу TREES (используемый вариант соединения с БД должен быть - H2), создать по данным этой таблицы список деревьев. Далее надо вызвать функцию, возвращающую  суммарное количество листов во всех деревьях списка. Далее надо создать файл output.csv и записать в него это число.

Далее надо сделать на maven скрипт сборки приложения в jar.

Надо создать публичный репозиторий на Github и загрузить в него проект (разработанный код, скрипт, драйверы и т.д.)

В качестве результата выполнения задания надо:

1.   Загрузить в систему содержащий проект zip-архив в данное задание.

2.   Загрузить в систему txt-файл, называющийся linkToTheProject2.txt, содержащий ссылку на проект, загруженный в репозиторий на Github.
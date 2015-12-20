import java.io.*;
import java.util.Scanner;
//import java.io.FileNotFoundException;
import java.lang.String;

public class Questions {
    static String[] questions;
    static String[] results;

    private void set_question(String phrase, int question_number) {
        questions[question_number] = phrase;
    }
    private void set_result(String phrase, int question_result) {
        results[question_result] = phrase;
    }

    Questions() {
        questions = new String[200];
        results = new String[200];
        set_questions();
    }


    public String[] read_questions() {
        File file = new File("Questions.txt");
        int k = 200, i = 0, n = 200;
        String[] file_questions = new String[k];
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                file_questions[i] = scanner.nextLine() + "\r\n";
                i++;
                n = i;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return file_questions;
    }

    public String[] read_results() {
        File file = new File("Results.txt");
        int k = 200, i = 0, n = 200;
        String[] file_results = new String[k];
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                file_results[i] = scanner.nextLine() + "\r\n";
                i++;
                n = i;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return file_results;
    }

    private void set_questions() {
/*        set_question("Хотите подобрать модель для оценки премии опциона на облигации?", 0);
        set_question("Учитывать эволюцию ноль-купонных процентных ставок?", 1);
        set_question("Является ли первоначальная временная структура исходной информацией для модели?", 2);
        set_question("Вы хотите использовать многофакторную модель?", 3);
        set_question("Стохастические процессы по долгосрочной и краткосрочной ставке взаимообратны?", 4);
        set_question("Процентная ставка подчиняется законам броуновского движения?", 5);
        set_question("Модель допускает, что краткосрочная процентная ставка принимает отрицательные значения ?", 6);
        set_question("Модель должна обязательно иметь аналитическое представление?", 7);
        set_question("В модели должен быть предусмотрен эффект возвращения к среднему?", 8);
        set_question("Хотите иметь большие возможности выбора временной структуры и волатильности?", 9);
        set_question("Модель Бреннана и Шварца", 101);
        set_question("Модель Лонгстаффа", 102);
        set_question("Модель Рендлемана-Бартерра", 103);
        set_question("Модель Кокса, Ингерсолла и Росса", 104);
        set_question("Модель Васичека", 105);
        set_question("Двухфакторная модель Халла-Уайта", 106);
        set_question("Модель Халла-Уайта", 107);
        set_question("Модель Хо-Ли", 108);
        set_question("Модель Блэка-Карасински", 109);
        set_question("Модели на  основе модели  Блека-Шоулса", 110);
        set_question("Вам вообще не нужно приобретать облигации", 111);*/
        String[] file_questions = read_questions();
        int i = 0;
        int number_of_questions, number_of_results;
        while (file_questions[i]!=null){
            i++;
        }
        number_of_questions = i;
        String[] file_results = read_results();
        i = 0;
        while (file_results[i]!=null){
            i++;
        }
        number_of_results = i;
        for (i=0; i < number_of_questions; i++){
            set_question(file_questions[i], i);
        }
        for (i=0; i < number_of_results; i++){
            set_question(file_results[i], 101+i);
        }
        for (i=0; i < number_of_results; i++){
            set_result(file_results[i], i);
        }
    }

/*    public String print_question(int question_number) {
        System.out.println(questions[question_number]);
        return questions[question_number];
    }*/

    public static void write_to_file (String to_write) /*throws IOException*/ {
        try {
            File flt = new File("Questions.txt");
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(flt)));
            out.print(to_write);
            out.flush();
        } catch (IOException e /*FileNotFoundException e*/) {
            e.printStackTrace();
        }
    }

    public void add_question (String new_question) /*throws IOException*/ {
        String[] old_questions = read_questions();
        String new_questions = "";
        System.out.print(old_questions[0]);
        int i = 0;
        while (old_questions[i] != null) {
            new_questions = new_questions + old_questions[i];
            i++;
        }
        new_questions = new_questions + new_question;
        write_to_file(new_questions);

    }

    public static String get_question(int question_number) {
        return questions[question_number];
    }

    public static int get_question_length() {
        return questions.length;
    }

    public static String get_result(int result_number) {
        return results[result_number];
    }

    public void print_questions(){
        for (int i = 0; i < questions.length; i++){
            System.out.print(questions[i]);
        }
    }

/*    public void add_question(String new_question) {
        set_question(new_question, questions.length + 1);

    }*/

}

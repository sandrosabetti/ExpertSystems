import java.io.*;
import java.util.Scanner;

public class Transitions {
    //static int[][] array = {{1, 2, 7, 4, 101, 103, 104, 8, 9, 106}, {111, 110, 3, 5, 102, 6, 105, 109, 108, 107}};
    static int transitions[][];

    Transitions() {
        transitions = new int[2][20];
        //this.transitions = array;
        transitions = set_transitions();
    }

    public int[][] set_transitions() {
        int[][] file_transitions = numbers_to_int(unite_numbers());
        return file_transitions;
    }

    public static int get_transitions(int transition_number_i, int transition_number_j) {
        return transitions[transition_number_i][transition_number_j];
    }

    public static String[] read_transitions() {
        File file = new File("Transitions.txt");
        int k = 200, i = 0, n = 200;
        String[] file_questions = new String[k];
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                file_questions[i] = scanner.nextLine();
                i++;
                n = i;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return file_questions;
    }

    public static String[] split_reader(int row) {
        String[] str = read_transitions();
        String[] numbers;
/*        for (int j = 0; j < 2; j++) {
            System.out.println(str[j]);
        }*/
        String str2 = str[row];
        numbers = str2.split(" ");
        return numbers;
    }


    public static String[][] unite_numbers(){
        String[] numbers;
        String[][] united_numbers = new String[2][20];
        numbers = split_reader(0);
        united_numbers[0] = numbers;
        numbers = split_reader(1);
        united_numbers[1] = numbers;
/*        int[][] int_united_numbers = new int[2][united_numbers[0].length];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < united_numbers[0].length; j++) {
                int_united_numbers[i][j] = Integer.valueOf(united_numbers[i][j]);
            }
        }
        return int_united_numbers;*/
        return united_numbers;
    }

    public static int[][] numbers_to_int(String[][] united_numbers){
        int[][] int_united_numbers = new int[2][united_numbers[0].length];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < united_numbers[0].length; j++) {
                int_united_numbers[i][j] = Integer.valueOf(united_numbers[i][j]);
            }
        }
        return int_united_numbers;
    }

    public static int get_transitions_length(){
        String[][] united_numbers = unite_numbers();
        return united_numbers[0].length;
    }

    public static void write_to_file (String to_write){
        try {
            File flt = new File("Transitions.txt");
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(flt)));
            out.print(to_write);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void change_transition(int row, int column, String value){
        String[][] united_numbers = unite_numbers();
        String str = "";
        united_numbers[row][column] = value;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < united_numbers[0].length; j++) {
                System.out.println(united_numbers[i][j]);
                str = str + united_numbers[i][j]+" ";
            }
            if (i == 0){
                str = str + System.getProperty("line.separator");
            }
        }
        write_to_file(str);
    }
}
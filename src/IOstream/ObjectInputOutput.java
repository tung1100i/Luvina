package IOstream;

import java.io.*;
import java.util.StringTokenizer;

public class ObjectInputOutput {
    private static final int numberObject = 12;

    public static Student[] readFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        StringTokenizer token;

        String hoTen, queQuan;
        int namSinh;
        float diemTB;
        Student[] students = new Student[numberObject];
        for (int i = 0; i < students.length; i++) {
            token = new StringTokenizer(br.readLine(), ",");
            hoTen = token.nextToken();
            queQuan = token.nextToken();
            namSinh = Integer.valueOf(token.nextToken());
            diemTB = Float.valueOf(token.nextToken());
            students[i] = new Student(hoTen, queQuan, namSinh, diemTB);
        }
        br.close();
        return students;
    }

    public static void sort(Student[] arr) {
        int pos;
        Student x;
        for (int i = 1; i < arr.length; i++) {
            x = arr[i];
            for (pos = i - 1; pos >= 0; pos--) {
                if (x.getNamSinh() < arr[pos].getNamSinh())
                    arr[pos + 1] = arr[pos];
                else
                    break;

            }
            arr[pos + 1] = x;
        }
    }

    public static void writeObject(String outputPath, Student[] students) throws IOException {
        ObjectOutputStream objectOutput = null;

        try {
            objectOutput = new ObjectOutputStream(new FileOutputStream(outputPath));
            for (Student s : students)
                objectOutput.writeObject(s);
        } catch (IOException e) {
            throw new IOException(e);
        } finally {
            if (objectOutput != null)
                objectOutput.close();
        }
    }

    public static void readObject(String intputPath) throws IOException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(intputPath));

        Student x;
        while (true) {
            try {
                x = (Student) input.readObject();
                System.out.println(x.toString());
            } catch (IOException e) {
                input.close();
                break;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        String inputPath = "D:\\Hoc\\Code\\Java\\Luvina\\src\\buoi8\\bai4\\InputObject.dat",
                outputPath = "D:\\Hoc\\Code\\Java\\Luvina\\src\\buoi8\\bai4\\FileStudent.dat";
        Student[] students;
        try {
            students = readFile(inputPath);
            sort(students);
            writeObject(outputPath, students);
            readObject(outputPath);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
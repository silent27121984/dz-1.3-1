import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        createDirectory("/Users/silent27/Games/src");
        createDirectory("/Users/silent27/Games/res");
        createDirectory("/Users/silent27/Games/savegames");
        createDirectory("/Users/silent27/Games/temp");
        createDirectory("/Users/silent27/Games/src/main");
        createDirectory("/Users/silent27/Games/src/test");
        createDirectory("/Users/silent27/Games/res/drawable");
        createDirectory("/Users/silent27/Games/res/vectors");
        createDirectory("/Users/silent27/Games/res/icons");
        createFile("/Users/silent27/Games/src/main/Main.java");
        createFile("/Users/silent27/Games/src/main/Utils.java");
        createFile("/Users/silent27/Games/temp/temp.txt");
        writeFile(new File("/Users/silent27/Games/temp/temp.txt"));
    }

    public static void createDirectory(String name) {
        File directory = new File(name);
        if (directory.mkdir()) {
            System.out.println(directory.getName() + "коталог создан");
        } else {
            System.out.println(name + " каталог существует");
        }
    }

    public static void createFile(String name) {
        File file = new File(name);
        try {
            if (file.createNewFile()) {
                System.out.println(file.getName() + "файл создан");
            } else {
                System.out.println(name + " файл существует");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void writeFile(File name) {
        StringBuilder sb = new StringBuilder();
        try (FileWriter writer = new FileWriter(name, false)) {
            if (name.exists()) {
                sb.append("Созданные каталоги: src, main, test, res, savegames, temp, drawables, vectors, icons. " + " \n" +
                        "Созданные файлы: Main.java, Utils.java, temp.txt");
                writer.write(sb.toString());
                writer.flush();
                writer.close();
            } else {
                System.out.println("Ошибка");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

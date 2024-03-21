import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        StringBuilder tempText = new StringBuilder();
        List listDirectories = new ArrayList();
        listDirectories.addAll(List.of(new String[]{"C://Games", "C://Games//src", "C://Games//res", "C://Games//savegames", "C://Games//temp", "C://Games//src//main", "C://Games//src//test", "C://Games//res//drawables", "C://Games//res//icons", "C://Games//res//vectors"}));
        for (int i = 0; i < listDirectories.size(); i++) {
            createDirectory((String) listDirectories.get(i), tempText);
        }
        createFile("C://Games//src//main", "Main.java", tempText);
        createFile("C://Games//src//main", "Utils.java", tempText);
        createFile("C://Games//temp", "temp.txt", tempText);
        System.out.println(tempText);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C://Games//temp//temp.txt", true))) {
            tempText.append("Ждем следующего запуска програмы.\n");
            bw.write(tempText.toString());
            bw.flush();
        } catch (Exception e) {
            System.out.println("2" + e.getMessage());
        }
    }

    static void createDirectory(String name, StringBuilder tempText) {
        File dirGames = new File(name);
        if (dirGames.mkdir()) {
            tempText.append(" - Создана папка " + name + "\n");
        } else {
            tempText.append(" - Папка " + name + "не создана или уже существует\n");
        }
    }

    static void createFile(String path, String name, StringBuilder tempText) {
        File fileTemp = new File(path + "//" + name);
        try {
            if (fileTemp.createNewFile()) {
                tempText.append(" - В папке " + path + " создан новый файл: " + name + "\n");
            } else {
                tempText.append(" - В папке " + path + " " + name + " уже существует\n");
            }
        } catch (IOException e) {
            System.out.println("1 " + e.getMessage());
        }
    }
}
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File homeDir = new File("C:\\Games");
        File[] dirs = {
                new File(homeDir, "src"),
                new File(homeDir, "res"),
                new File(homeDir, "saveGames"),
                new File(homeDir, "temp"),
                new File(homeDir.getPath() + "\\src", "main"),
                new File(homeDir.getPath() + "\\src", "test"),
                new File(homeDir.getPath() + "\\res", "drawables"),
                new File(homeDir.getPath() + "\\res", "vectors"),
                new File(homeDir.getPath() + "\\res", "icons"),
        };
        File[] files = {
                new File(homeDir.getPath() + "\\src\\main", "Main.java"),
                new File(homeDir.getPath() + "\\src\\main", "Utils.java"),
                new File(homeDir.getPath() + "\\temp", "temp.txt"),
        };

        StringBuilder log = new StringBuilder();
        if (!homeDir.exists()) {
            log.append("Папки ")
                    .append(homeDir.getName())
                    .append(" не существует. Создание папки:\n")
                    .append(makeDir(homeDir));
        }

        for (File dir : dirs) {
            log.append(makeDir(dir));
        }

        try {
            for (File file : files) {
                log.append(makeFile(file));
            }
            String logFilePath = homeDir.getPath() + "\\temp\\temp.txt";
            FileWriter fw = new FileWriter(logFilePath);
            fw.append(log);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(log); //вывод лога в консоль
    }

    public static String makeDir(File dir) {
        return (dir.mkdir() ? "Успешное создание папки " : "Не удалось создать папку ")
                + dir.getPath() + '\n';
    }

    public static String makeFile(File file) throws IOException {
        return (file.createNewFile() ? "Успешное создание файла " : "Не удалось создать файл ")
                + file.getPath() + '\n';
    }
}

package priv.psq.old.filestreamtrain;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

/**
 * FileStreamTrain.java
 * Description: 文件输入输出流联系
 *
 * @author Peng Shiquan
 * @date 2021/5/12
 */
public class FileStreamTrain {
    public static void main(String[] args) throws IOException {
        User[] userList = new User[3];
        userList[0] = new User("zhangshan", 7000, 1996, 11, 29);
        userList[1] = new User("lisi", 8000, 1998, 12, 22);
        userList[2] = new User("wangwu", 9000, 1993, 11, 30);
        try (PrintWriter printWriter = new PrintWriter("/Users/pengshiquan/Desktop/sql/test.txt", StandardCharsets.UTF_8.toString())) {
            writerUserData(userList, printWriter);
        }

        try (Scanner in = new Scanner(new FileInputStream("/Users/pengshiquan/Desktop/sql/test.txt"), "UTF-8")) {
            User[] users = readData(in);
            for (User user : users) {
                System.err.println(user.toString());
            }
        }
    }

    static void writerUserData(User[] userList, PrintWriter printWriter) {
        printWriter.println(userList.length);
        for (User user : userList)
            writerUser(user, printWriter);
    }

    static void writerUser(User user, PrintWriter out) {
        out.println(user.getName() + "|" + user.getMoney() + "|" + user.getAge());
    }

    static User[] readData(Scanner in) {
        int length = in.nextInt();
        User[] result = new User[length];
        in.nextLine();
        for (int i = 0; i < length; i++) {
            result[i] = readUser(in);
        }
        return result;
    }

    static User readUser(Scanner in) {
        String line = in.nextLine();
        String[] tmp = line.split("\\|");
        String name = tmp[0];
        Integer money = Integer.parseInt(tmp[1]);
        LocalDate date = LocalDate.parse(tmp[2]);
        User user = new User(name, money, date.getYear(), date.getMonthValue(), date.getDayOfMonth());
        return user;
    }

}

class User {
    String name;
    Integer money;
    Date age;


    public User(String name, Integer money, int year, int month, int day) {
        this.name = name;
        this.money = money;
        this.age = new Date(year, month, day);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getAge() {
        return age.getYear() + "-" + age.getMonth() + "-" + age.getDay();
    }

    public void setAge(Date age) {
        this.age = age;
    }
}
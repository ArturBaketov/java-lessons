package org.example.hw6;
import org.example.hw6.model.Notebook;
import org.example.hw6.model.UserFilter;
import java.util.Set;
import static org.example.hw6.model.DataBase.createBase;
/**
 * • Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
 * • Создать множество ноутбуков.
 * • Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации
 * и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
 * “Введите цифру, соответствующую необходимому критерию:
 * 1 - ОЗУ
 * 2 - Объем ЖД
 * 3 - Операционная система
 * 4 - Цвет …
 * • Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры
 * фильтрации можно также в Map.
 * • Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 */
public class Ex1 {
    public static void main(String[] args) {
        Set<Notebook> base = createBase(40);
        System.out.printf("We have %d notebooks!%n",base.size());
        UserFilter filter = new UserFilter(base);
        while (filter.isUserHere()) {
            filter.askFilter(base);
            filter.askFilter();
        }
    }

}

package org.example.hw6.model;
import lombok.Data;
import java.util.*;
@Data
public class UserFilter extends Notebook {
    private boolean userHere;
    private Set<Notebook> base;
    private LinkedHashMap<Integer, String> optionList;
//    private void fillNew(){
//        generateOptionList();
//        userHere = true;
//    }
//    public UserFilter(String model, Integer ramSize, Integer diskSize, String osName, String color) {
//        super(model, ramSize, diskSize, osName, color);
//        fillNew();
//    }
//    public UserFilter() {
//        super();
//        fillNew();
//    }
    public UserFilter(Set<Notebook> base) {
        super();
        generateOptionList();
        userHere = base.size() > 0;
        this.base = new LinkedHashSet<>(base);
    }
    private void generateOptionList() {
        optionList = new LinkedHashMap<>();
        optionList.put(1, "model");
        optionList.put(2, "RAM");
        optionList.put(3, "Disk");
        optionList.put(4, "OS");
        optionList.put(5, "color");
        optionList.put(0, "Exit");
    }
    private void printOptions() {
        HashMap<Integer, String> list = this.getOptionList();
        for (Object key : list.keySet()) {
            System.out.println(key + " - " + list.get(key) + ": " + getOptionValue(key));
        }
    }
    private String getOptionValueString(Object key) {
        Set resultSet = new TreeSet();
        for (Notebook item : base) {
            resultSet.add(item.getOptionValue(key));
        }
        String result = "";
        for (Object o : resultSet) {
            result += (result.isEmpty() ? "" : ", ") + o.toString();
        }
        return result;
    }
  
      public void askFilter() {
        printOptions();
        System.out.print("Option: ");
        Scanner sc = new Scanner(System.in);
        int userChoice = sc.nextInt();
        if (userChoice == 0) this.userHere = false;
        else if (userChoice > 5) System.out.println("Wrong option");
        else {
            askOption(userChoice);
            printFilter();
        }
    }
    private void printFilter() {
        for (Notebook item : base) {
            if (item.matchFilter(this)) {
                System.out.println(item);
            }
        }
    }
    private void askOption(int userChoice) {
        String optionName = getOptionList().get(userChoice);
        String optionList = getOptionValueString(userChoice);
        if (optionName.equals("model")) {
            optionList = "any string";
        }
        System.out.print(optionName + " (" + optionList + ") :");
        switch (userChoice) {
            case 1 -> this.setModel(askString());
            case 2 -> this.setRamSize(askInt());
            case 3 -> this.setDiskSize(askInt());
            case 4 -> this.setOsName(askString());
            case 5 -> this.setColor(askString());
            default -> throw new IllegalStateException("Unexpected value: " + userChoice);
        }
    }
    private Integer askInt() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    private String askString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Laptop {
    private int ram;
    private int storage;
    private String os;
    private String color;

    public Laptop(int ram, int storage, String os, String color) {
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "RAM: " + ram + "GB, Storage: " + storage + "GB, OS: " + os + ", Color: " + color;
    }
}

public class LaptopFilter {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();

        // Создаем и добавляем ноутбуки в множество
        laptops.add(new Laptop(16, 1000, "Windows 10", "Черный"));
        laptops.add(new Laptop(8, 500, "macOS", "Серебристый"));
        laptops.add(new Laptop(12, 2000, "Windows 10", "Красный"));
        laptops.add(new Laptop(32, 1000, "Ubuntu", "Черный"));

        // Запрашиваем критерий фильтрации
        System.out.println("Введите цифру, соответствующую критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем Жёсткого диска");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        Scanner scanner = new Scanner(System.in);
        int criterion = scanner.nextInt();

        // Запрашиваем минимальное значение для выбранного критерия
        System.out.println("Введите минимальное значение для выбранного критерия:");
        int minValue = scanner.nextInt();

        // Фильтруем ноутбуки по выбранному критерию и минимальному значению
        Set<Laptop> filteredLaptops = new HashSet<>();
        for (Laptop laptop : laptops) {
            switch (criterion) {
                case 1:
                    if (laptop.getRam() >= minValue) {
                        filteredLaptops.add(laptop);
                    }
                    break;
                case 2:
                    if (laptop.getStorage() >= minValue) {
                        filteredLaptops.add(laptop);
                    }
                    break;
                case 3:
                    if (laptop.getOs().equals(getOsChoice(minValue))) {
                        filteredLaptops.add(laptop);
                    }
                    break;
                case 4:
                    if (laptop.getColor().equals(getColorChoice(minValue))) {
                        filteredLaptops.add(laptop);
                    }
                    break;
            }
        }

        // Выводим отфильтрованные ноутбуки
        System.out.println("Результат фильтрации:");
        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop);
        }
    }

    private static String getOsChoice(int choice) {
        switch (choice) {
            case 1:
                return "Windows 10";
            case 2:
                return "macOS";
            case 3:
                return "Ubuntu";
            default:
                return "";
        }
    }

    private static String getColorChoice(int choice) {
        switch (choice) {
            case 1:
                return "Черный";
            case 2:
                return "Серебристый";
            case 3:
                return "Красный";
            default:
                return "";
        }
    }
}

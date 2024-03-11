import java.util.*;

public class Main {
    public static void main(String[] args) {

        HashMap<Integer, Notebook> notebookHashMap = new HashMap<>();

        // Создание ноутбуков
        Notebook notebook1 = new Notebook(8, 128, "Linux", "black", "AMD", "AMD");
        Notebook notebook2 = new Notebook(16, 256, "Linux", "white", "AMD", "AMD");
        Notebook notebook3 = new Notebook(32, 512, "Windows", "blue", "Nvidia", "Intel");
        Notebook notebook4 = new Notebook(64, 1024, "Windows", "gold", "Nvidia", "Intel");

        // Вносим в наш HashMap объекты ноутбуков класса Notebook, с индексом.
        notebookHashMap.put(1, notebook1);
        notebookHashMap.put(2, notebook2);
        notebookHashMap.put(3, notebook3);
        notebookHashMap.put(4, notebook4);

        filterNotebook(notebookHashMap);

    }

    public static void filterNotebook (HashMap<Integer, Notebook> notebookHashMap) {
        int stopChosenCategory = 0; // Переменная для цикла While, чтобы тот остановился, когда пользователь захочет.
        ArrayList<Integer> chosenCategory = new ArrayList<>(); // Коллекция, которая будет хранить в себе категории - тот ещё костыль, но с ним всё работает. Нужно для того чтобы брать значение как ключ.
        HashMap<Integer, String> chosenCategoryAndValue = new HashMap<Integer, String>(); // ХэшМап, который хранит в себе нужную категорию и минимальное значение ввведеное пользвателем.
        HashMap<Integer, Notebook> notebookFilter = new HashMap<Integer, Notebook>(); // Наш ХэшМап который выводится позже.

        notebookFilter = notebookHashMap;

        // Интерфейс.
        System.out.println("Введите цифру, соответствующую необходимому критерию: \n" +
                        "1 - ОЗУ \n" +
                        "2 - Объем ЖД \n" +
                        "3 - Операционная система \n" +
                        "4 - Цвет ноутбука \n" +
                        "5 - Видеокарта \n" +
                        "6 - Процессор \n" +
                        "7 - Закончить процесс выбора категорий \n");
        Scanner scanner = new Scanner(System.in);

        // Процесс выбора категорий, пока пользователь не завершит добавление всех флагов.
        while (stopChosenCategory == 0){
            int choose = scanner.nextInt();
            if(choose == 7){
                stopChosenCategory = 1;
            } else {
                chosenCategory.add(choose);
            }
        }

        Collections.sort(chosenCategory);

        // Тут всё ясно, красота, цветочки - интерфейс.
        System.out.println("Введите нужное вам значение, соответствующую необходимому критерию: \n" +
                "1 - ОЗУ (8 - 64) \n" +
                "2 - Объем ЖД (128 - 1024) \n" +
                "3 - Операционная система (Windows/Linux) \n" +
                "4 - Цвет ноутбука (black/white/blue/gold) \n" +
                "5 - Видеокарта (Nvidia/AMD) \n" +
                "6 - Процессор (AMD/Intel) \n");

        // Добавил этот сканнер - чтобы внутри цикла не пропускалось нулевое значение.
        String value = scanner.nextLine();

        // Непосредственно добавление в наш второй HashMap категории и минимального значения.
        for (Integer item : chosenCategory) {
            System.out.println("Введите минимальное значение фильтрации для выбранной категории " + item);
            String value1 = scanner.nextLine();
            chosenCategoryAndValue.put(item, value1);
        }

        // Костыль-коллекция, которая записывает ключи ноутбуков, а затем удаляет эти ключи из HashMap.
        ArrayList<Integer> list = new ArrayList<>();
        // Огромный кусок кода, потому что я замудрил - который берет и сравнивает значения двух HashMap на основе коллекции категорий, который мы вводили.
        try {
            for (Integer integer : chosenCategory) {
                switch (integer) {
                    case (1):
                        for(Integer id : notebookFilter.keySet()) {
                            if (Integer.parseInt(chosenCategoryAndValue.get(1)) > notebookFilter.get(id).getCapacityRAM()) {
                                list.add(id);
                            }
                        }
                        break;
                    case (2):
                        for(Integer id : notebookFilter.keySet()) {
                            if (Integer.parseInt(chosenCategoryAndValue.get(2)) > notebookFilter.get(id).getCapacityMemory()) {
                                list.add(id);
                            }
                        }
                        break;
                    case (3):
                        for(Integer id : notebookFilter.keySet()) {
                            if (!chosenCategoryAndValue.get(3).equals(notebookFilter.get(id).getOperatingSystem())) {
                                list.add(id);
                            }
                        }
                        break;
                    case (4):
                        for(Integer id : notebookFilter.keySet()) {
                            if (!chosenCategoryAndValue.get(4).equals(notebookFilter.get(id).getColore())) {
                                list.add(id);
                            }
                        }
                        break;
                    case (5):
                        for(Integer id : notebookFilter.keySet()) {
                            if (!chosenCategoryAndValue.get(5).equals(notebookFilter.get(id).getVideoCard())) {
                                list.add(id);
                            }
                        }
                        break;
                    case (6):
                        for(Integer id : notebookFilter.keySet()) {
                            if (!chosenCategoryAndValue.get(6).equals(notebookFilter.get(id).getProcessor())) {
                                list.add(id);
                            }
                        }
                        break;
                }
            }
        } catch (Exception ignored){}

        // Тоже своего рода костыль, если удалять прямо в самом цикле - происходит ошибка, ключи сбиваются, поэтому куда безопаснее записывать ключи фильтрации в отдельную коллекцию.
        for(Integer integer : list){
            notebookFilter.remove(integer);
        }
        System.out.println(notebookFilter);
    }
}


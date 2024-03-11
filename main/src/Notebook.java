public class Notebook {
    private int capacityRAM = 0;
    private int capacityMemory = 0;
    private String operatingSystem = "";
    private String color = "";
    private String videoCard = "";
    private String processor = "";

    // Конструктор нашего ноутбука.
    public Notebook(int capacityRAM, int capacityMemory, String operatingSystem, String color, String videoCard, String processor){
        this.capacityMemory = capacityMemory;
        this.capacityRAM = capacityRAM;
        this.operatingSystem = operatingSystem;
        this.color = color;
        this.videoCard = videoCard;
        this.processor = processor;
    }

    // Геттеры, сеттеры
    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(String videoCard) {
        this.videoCard = videoCard;
    }

    public String getColore() {
        return color;
    }

    public void setColore(String colore) {
        this.color = colore;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public int getCapacityMemory() {
        return capacityMemory;
    }

    public void setCapacityMemory(int capacityMemory) {
        this.capacityMemory = capacityMemory;
    }

    public int getCapacityRAM() {
        return capacityRAM;
    }

    public void setCapacityRAM(int capacityRAM) {
        this.capacityRAM = capacityRAM;
    }
}

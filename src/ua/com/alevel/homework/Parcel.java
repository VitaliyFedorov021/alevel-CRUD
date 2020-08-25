package ua.com.alevel.homework;

public class Parcel {
    private int id;
    private String nameOfReceiver;
    private double price;
    private String nameOfSender;
    private int currentState; // 1 - в отделении города отправителя, 2 - в пути, 3 - прибыл

    public int getCurrentState() {
        return currentState;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "id=" + id +
                ", nameOfReceiver='" + nameOfReceiver + '\'' +
                ", price=" + price +
                ", nameOfSender='" + nameOfSender + '\'' +
                ", currentState=" + currentState +
                '}';
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfReceiver() {
        return nameOfReceiver;
    }

    public void setNameOfReceiver(String nameOfReceiver) throws IncorrectDataException {
        char[] arr = nameOfReceiver.toCharArray();
        boolean flag = false;
        for (int i = 0; i < arr.length; ++i) {
            if (!Character.isLetter(arr[i])) {
                flag = true;
                break;
            }
        }
        if (flag == true || nameOfReceiver.isBlank()) {
            throw new IncorrectDataException("Name can't contains not letters");
        } else {
            this.nameOfReceiver = nameOfReceiver;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws IncorrectDataException {
        if (price <= 0) {
            throw new IncorrectDataException("Price can't be lower than zero");
        } else {
            this.price = price;
        }
    }

    public String getNameOfSender() {
        return nameOfSender;
    }

    public void setNameOfSender(String nameOfSender) throws IncorrectDataException {
        char[] arr = nameOfSender.toCharArray();
        boolean flag = false;
        for (int i = 0; i < arr.length; ++i) {
            if (!Character.isLetter(arr[i])) {
                flag = true;
                break;
            }
        }
        if (flag == true || nameOfSender.isBlank()) {
            throw new IncorrectDataException("Name can't contains not letters");
        } else {
            this.nameOfSender = nameOfSender;
        }

    }
}

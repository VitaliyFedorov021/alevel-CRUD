package ua.com.alevel.homework;


import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunProgram {
    private ParcelController parcelController = new ParcelController();

    private String input(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        String date = sc.nextLine();
        return date;
    }

    public void run() {
        while (true) {
            int a = Integer.parseInt(input("What do you want to do( 1 - add parcel, 2 - update parcel, " +
                    "3 - delete parcel, 4 - print all parcels, " +
                    "5 - find parcel by name of receiver, 6 - find parcel by name of sender, " +
                    "7 - find parcel by id, 8 - find parcel by current state, 0 - end execution of program)"));
            switch (a) {
                case 0: {
                    System.exit(1);
                }
                case 1: {
                    createParcel();
                    continue;
                }
                case 2: {
//                    int size = parcelController.findAll().size();
//                    if (size == 0) {
//                        System.out.println("Nothing to update");
//                        continue;
//                    } else {
                        updateParcel();
//                    }
                    continue;
                }
                case 3: {
//                    int size = parcelController.findAll().size();
//                    if (size == 0) {
//                        System.out.println("Nothing to delete");
//                        continue;
//                    } else {
                        deleteParcel();
//                    }
                    continue;
                }
                case 4: {
//                    int size = parcelController.findAll().size();
//                    if (size == 0) {
//                        System.out.println("Nothing to find");
//                        continue;
//                    } else {
                        all();
//                    }
                    continue;
                }
                case 5: {
//                    int size = parcelController.findAll().size();
//                    if (size == 0) {
//                        System.out.println("Nothing to find");
//                        continue;
//                    } else {
                        nameOfReceiver();
//                    }
                    continue;
                }
                case 6: {
//                    int size = parcelController.findAll().size();
//                    if (size == 0) {
//                        System.out.println("Nothing to find");
//                        continue;
//                    } else {
                        nameOfSender();
//                    }
                    continue;
                }
                case 7: {
//                    int size = parcelController.findAll().size();
//                    if (size == 0) {
//                        System.out.println("Nothing to find");
//                        continue;
//                    } else {
                        idParcel();
//                    }
                    continue;

                }
                case 8: {
//                    int size = parcelController.findAll().size();
//                    if (size == 0) {
//                        System.out.println("Nothing to find");
//                        continue;
//                    } else {
                        stateParcel();
//                    }
                    continue;
                }

            }
        }
    }

    private void createParcel() {
        Parcel parcel = new Parcel();
        double price = Double.parseDouble(input("Enter the price of parcel(in dollars)"));
        int state;
        do {
            String str = input("Enter the state of parcel(1 - 3)");
            state = Integer.parseInt(str);
            if (state < 1 || state > 3) {
                System.out.println("Incorrect state of parcel, try again");
            }
        } while (state < 1 || state > 3);
        String nameOfReceiver = input("Enter the name of receiver");
        String nameOfSender = input("Enter the name of sender");
        try {
            parcel.setPrice(price);
        } catch (IncorrectDataException e) {
            e.printStackTrace();
        }
        try {
            parcel.setNameOfSender(nameOfSender);
        } catch (IncorrectDataException e) {
            e.printStackTrace();
        }
        try {
            parcel.setNameOfReceiver(nameOfReceiver);
        } catch (IncorrectDataException e) {
            e.printStackTrace();
        }
        parcel.setCurrentState(state);
        parcelController.createParcel(parcel);
    }

    private void updateParcel() {
        Parcel parcel = new Parcel();
        int id = Integer.parseInt(input("Enter the id of parcel, which you want to update")), state;
        parcel.setId(id);
        double price;
        String nameOfReceiver, nameOfSender;
        price = Double.parseDouble(input("Enter the new price of parcel(in dollars)"));
        do {
            String str = input("Enter the new state of parcel(1 - 3)");
            state = Integer.parseInt(str);
            if (state < 1 || state > 3) {
                System.out.println("Incorrect state of parcel, try again");
            }
        } while (state < 1 || state > 3);
        nameOfReceiver = input("Enter the new name of receiver");
        nameOfSender = input("Enter the new name of sender");
        try {
            parcel.setPrice(price);
        } catch (IncorrectDataException e) {
            e.printStackTrace();
        }
        try {
            parcel.setNameOfSender(nameOfSender);
        } catch (IncorrectDataException e) {
            e.printStackTrace();
        }
        try {
            parcel.setNameOfReceiver(nameOfReceiver);
        } catch (IncorrectDataException e) {
            e.printStackTrace();
        }
        try {
            parcelController.updateParcel(parcel);
        } catch (IncorrectDataException e) {
            e.printStackTrace();
        }
    }

    private void deleteParcel() {
        int id = Integer.parseInt(input("Enter the id of parcel, which you want to delete"));
        parcelController.delete(id);
    }

    private void all() {
        List<Parcel> parcels = parcelController.findAll();
        for (Parcel currentParcel :
                parcels) {
            System.out.println(currentParcel.toString());
        }
    }

    private void nameOfReceiver() {
        String name = input("Enter the name of receiver");
        List<Parcel> parcels = parcelController.findByNameOfReceiver(name);
        for (Parcel currentParcel :
                parcels) {
            System.out.println(currentParcel.toString());
        }
    }

    private void nameOfSender() {
        String name = input("Enter the name of sender");
        List<Parcel> parcels = parcelController.findByNameOfSender(name);
        for (Parcel currentParcel :
                parcels) {
            System.out.println(currentParcel.toString());
        }
    }

    private void idParcel() {
        int id = Integer.parseInt(input("Enter the id to find"));
        Parcel parcel = parcelController.findById(id);
        System.out.println(parcel.toString());
    }

    private void stateParcel() {
        int state = Integer.parseInt(input("Enter the state to find"));
        List<Parcel> parcels = parcelController.findByState(state);
        for (Parcel currentParcel :
                parcels) {
            System.out.println(currentParcel.toString());
        }
    }

    public static void main(String[] args) {
        new RunProgram().run();
    }

}

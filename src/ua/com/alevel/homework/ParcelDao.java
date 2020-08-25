package ua.com.alevel.homework;

import java.util.List;

public interface ParcelDao {
    void createParcel(Parcel parcel);

    void updateParcel(Parcel parcel) throws IncorrectDataException;

    void delete(int id);

    List<Parcel> findAll();

    List<Parcel> findByNameOfReceiver(String nameOfReceiver);

    List<Parcel> findByNameOfSender(String nameOfSender);

    Parcel findById(int id);

    List<Parcel> findByState(int state);

}

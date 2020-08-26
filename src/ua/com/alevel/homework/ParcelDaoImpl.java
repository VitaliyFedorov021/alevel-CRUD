package ua.com.alevel.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParcelDaoImpl implements ParcelDao {
    private List<Parcel> parcels = new ArrayList<>();

    @Override
    public void createParcel(Parcel parcel) {
        parcels.add(parcel);
    }

    @Override
    public void updateParcel(Parcel parcel) throws IncorrectDataException {
        boolean check = false;
        for (Parcel currentParcel :
                parcels) {
            if (currentParcel.getId() == parcel.getId()) {
                currentParcel.setNameOfReceiver(parcel.getNameOfReceiver());
                currentParcel.setNameOfSender(parcel.getNameOfSender());
                currentParcel.setPrice(parcel.getPrice());
                check = true;
            }
        }
        if (!check) {
            throw new RuntimeException("User not found");
        }

    }

    @Override
    public void delete(int id) {
        boolean flag = false;
        for (Parcel currentParcel :
                parcels) {
            if (currentParcel.getId() == id) {
                parcels.remove(currentParcel);
                flag = true;
            }
        }
        if (!flag) {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public List<Parcel> findAll() {
        return parcels;
    }

    @Override
    public List<Parcel> findByNameOfReceiver(String nameOfReceiver) {
        List<Parcel> tempParcels = new ArrayList<>();
        for (Parcel currentParcel :
                parcels) {
            if (currentParcel.getNameOfReceiver().equals(nameOfReceiver)) {
                tempParcels.add(currentParcel);
            }

        }
        return tempParcels;
    }

    @Override
    public List<Parcel> findByNameOfSender(String nameOfSender) {
        List<Parcel> tempParcels = new ArrayList<>();
        for (Parcel currentParcel :
                parcels) {
            if (currentParcel.getNameOfSender().equals(nameOfSender)) {
                tempParcels.add(currentParcel);
            }

        }
        return tempParcels;
    }

    @Override
    public Parcel findById(int id) {
        for (Parcel currentParcel :
                parcels) {
            if (currentParcel.getId() == id) {
                return currentParcel;
            }
        }
        throw new RuntimeException("Parcel not found");
    }

    @Override
    public List<Parcel> findByState(int state) {
        List<Parcel> tempParcels = new ArrayList<>();
        for (Parcel currentParcel :
                parcels) {
            if (currentParcel.getCurrentState() == state) {
                tempParcels.add(currentParcel);
            }

        }
        return tempParcels;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParcelDaoImpl parcelDao = (ParcelDaoImpl) o;
        return Objects.equals(parcels, parcelDao.parcels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parcels);
    }
}

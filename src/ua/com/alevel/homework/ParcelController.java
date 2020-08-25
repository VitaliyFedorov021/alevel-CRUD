package ua.com.alevel.homework;

import java.util.List;

public class ParcelController {
    private ParcelService parcelService = new ParcelServiceImpl();


    public void createParcel(Parcel parcel) {
        parcelService.createParcel(parcel);
    }


    public void updateParcel(Parcel parcel) throws IncorrectDataException {
        parcelService.updateParcel(parcel);
    }


    public void delete(int id) {
        parcelService.delete(id);
    }


    public List<Parcel> findAll() {
        return parcelService.findAll();
    }


    public List<Parcel> findByNameOfReceiver(String nameOfReceiver) {
        return parcelService.findByNameOfReceiver(nameOfReceiver);
    }


    public List<Parcel> findByNameOfSender(String nameOfSender) {
        return parcelService.findByNameOfSender(nameOfSender);
    }


    public Parcel findById(int id) {
        return parcelService.findById(id);
    }


    public List<Parcel> findByState(int state) {
        return parcelService.findByState(state);
    }
}

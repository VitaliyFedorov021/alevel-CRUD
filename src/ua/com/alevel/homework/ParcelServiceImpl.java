package ua.com.alevel.homework;

import java.util.List;

public class ParcelServiceImpl implements ParcelService {
    ParcelDao parcelDao = new ParcelDaoImpl();

    @Override
    public void createParcel(Parcel parcel) {
        int size = parcelDao.findAll().size();
        parcel.setId(++size * 1000);
        parcelDao.createParcel(parcel);
    }

    @Override
    public void updateParcel(Parcel parcel) throws IncorrectDataException {
        parcelDao.updateParcel(parcel);
    }

    @Override
    public void delete(int id) {
        parcelDao.delete(id);
    }

    @Override
    public List<Parcel> findAll() {
        return parcelDao.findAll();
    }

    @Override
    public List<Parcel> findByNameOfReceiver(String nameOfReceiver) {
        return parcelDao.findByNameOfReceiver(nameOfReceiver);
    }

    @Override
    public List<Parcel> findByNameOfSender(String nameOfSender) {
        return parcelDao.findByNameOfSender(nameOfSender);
    }

    @Override
    public Parcel findById(int id) {
        return parcelDao.findById(id);
    }

    @Override
    public List<Parcel> findByState(int state) {
        return parcelDao.findByState(state);
    }
}

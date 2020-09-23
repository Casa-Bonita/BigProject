package ru.study.homework.spring_repository.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.study.homework.spring_repository.entity.Parcel;
import ru.study.homework.spring_repository.repository.ParcelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ParcelService {

    @Autowired
    private ParcelRepository parcelRepository;

    public void save (Parcel parcel){
        parcelRepository.save(parcel);
    }

    public List<Parcel> getAll(){
        return (List<Parcel>) parcelRepository.findAll();
    }

    public Optional <Parcel> getById(int id){
        //return (Parcel) parcelRepository.findById(id);
        return parcelRepository.findById(id);
    }

    public void delete (int id){
        parcelRepository.deleteById(id);
    }

    public List<Parcel> getParcelByName(String name){
        return parcelRepository.getParcelByParcelName(name);
    }

    public Parcel getParcelByNameAndReceip(String name, String receip){
        return parcelRepository.getParcelByParcelNameAndRecipientName(name, receip);
    }


}

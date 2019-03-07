package com.example.contactlistmvvmjava;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ContactViewModel extends AndroidViewModel {
    private ContactRepository mRepository;

    private LiveData<List<Contact>> mAllContacts;

    public ContactViewModel (Application application){
        super(application);
        mRepository = new ContactRepository(application);
        mAllContacts = mRepository.getAllContacts();
    }

    LiveData<List<Contact>> getAllWords() { return mAllContacts; }

    public void insert(Contact contact) { mRepository.insert(contact); }
    public void deleteContact(Contact contact) {mRepository.deleteContact(contact);}
}

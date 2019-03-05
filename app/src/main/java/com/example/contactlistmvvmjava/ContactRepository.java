package com.example.contactlistmvvmjava;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class ContactRepository {
    private ContactDao mContactDao;
    private LiveData<List<Contact>> mAllContacts;

        ContactRepository(Application application){
        ContactRoomDatabase db = ContactRoomDatabase.getDatabase(application);
        mContactDao = db.contactDao();
        mAllContacts = mContactDao.getAllContacts();
        }

        LiveData<List<Contact>> getAllContacts() { return mAllContacts;}
        public void insert (Contact contact) {new insertAsyncTask(mContactDao).execute(contact);}

        private static class insertAsyncTask extends AsyncTask<Contact, Void, Void> {
            private ContactDao mAsyncTaskDao;

            insertAsyncTask(ContactDao dao) {
                mAsyncTaskDao = dao;
            }

            @Override
            protected Void doInBackground(final Contact... params) {
                mAsyncTaskDao.insert(params[0]);
                return null;
            }
        }
}

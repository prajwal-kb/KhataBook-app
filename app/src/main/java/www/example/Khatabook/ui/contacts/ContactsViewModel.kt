package www.example.Khatabook.ui.contacts

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import www.example.Khatabook.data.Contact
import www.example.Khatabook.data.ContactRecordFull
import www.example.Khatabook.data.Repo

class ContactsViewModel(context: Context) : ViewModel() {
    private val repo : Repo
    val data : LiveData<List<ContactRecordFull>>?
    var isDescending = false
    init {
        repo = Repo(context)
        data = repo.searchContactRecords("%%", isDescending, 0, 10)
    }

    fun getAllContacts() : LiveData<List<ContactRecordFull>>?{
        return repo.getAllContacts()
    }

    fun deleteContact(contact: Contact){
        repo.deleteContact(contact)
    }

    fun searchRecords(param: String, descending: Boolean, offset: Int, pageSize: Int): LiveData<List<ContactRecordFull>>? {
        return repo.searchContactRecords(param, descending, offset, pageSize)
    }
}
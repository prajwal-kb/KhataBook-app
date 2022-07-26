package www.example.Khatabook

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import www.example.Khatabook.data.Contact
import www.example.Khatabook.data.DebtRecordDb
import www.example.Khatabook.data.Repo

class AddModifyDebtViewModel(context: Context) : ViewModel() {
    //this will hold the person records that will be shown when selecting a person
    //also, it will add or edit a person via the repository

    val contacts : LiveData<List<Contact>>?
    val repo: Repo
    init{
        repo = Repo(context)
        contacts = repo.getDbContacts()
    }

    fun getDbContacts() : LiveData<List<Contact>>?{
        return repo.getDbContacts()
    }

    fun insertRecord(debtRecordDb: DebtRecordDb){
        repo.insertDebtRecord(debtRecordDb)
    }

    fun updateRecord (debtRecordDb: DebtRecordDb){
        repo.updateDebtRecord(debtRecordDb)
    }
}
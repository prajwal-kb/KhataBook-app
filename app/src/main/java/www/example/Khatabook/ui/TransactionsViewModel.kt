package www.example.Khatabook.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import www.example.Khatabook.data.History
import www.example.Khatabook.data.Repo

class TransactionsViewModel(context: Context, val contactId: Int) : ViewModel() {
    private val repo : Repo
    val data : LiveData<List<History>>?
    var isDescending = false
    init {
        repo = Repo(context)
        data = repo.getHistoryById(contactId)
        //data = repo.getAllHistory()
    }

}
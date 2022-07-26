package www.example.Khatabook.ui.borrowers

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import www.example.Khatabook.data.*

class BorrowersViewModel(context: Context, creditor: Boolean) : ViewModel() {

    private val repo: Repo
    var data: LiveData<List<DebtRecordFull>>?
    var isDescending = false
    var isCreditor = creditor

    init {
        repo = Repo(context)
        data = repo.searchDebtRecords("%%", isDescending, 0, 10, isCreditor)
    }

    fun deleteRecord(debtRecordDb: DebtRecordDb) {
        repo.deleteDebtRecord(debtRecordDb)
    }

    fun searchRecords(
        param: String,
        descending: Boolean,
        offset: Int,
        pageSize: Int,
        isCreditor: Boolean
    ): LiveData<List<DebtRecordFull>>? {
        return repo.searchDebtRecords(param, descending, offset, pageSize, isCreditor)
    }

    fun addHistoryRecord(history: History){
        repo.insertHistoryRecord(history)
    }

}


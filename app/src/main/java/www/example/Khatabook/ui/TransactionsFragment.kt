package www.example.Khatabook.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import www.example.Khatabook.adapters.HistoryRecordAdapter
import www.example.Khatabook.data.History
import www.example.Khatabook.databinding.FragmentTransactionsBinding

class TransactionsFragment(val contactId: Int) : DialogFragment() {

    companion object {
        fun newInstance(contactId: Int) = TransactionsFragment(contactId)
    }

    lateinit var historyList : ArrayList<History>
    private lateinit var viewModel: TransactionsViewModel
    lateinit var adapter : HistoryRecordAdapter
    lateinit var binding: FragmentTransactionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTransactionsBinding.inflate(inflater, container, false)

        val vm = TransactionsViewModel(requireContext(), contactId)
        historyList = ArrayList()

        adapter = HistoryRecordAdapter(historyList)

        binding.transactionsRecyclerView.adapter = adapter
        binding.transactionsRecyclerView.layoutManager = LinearLayoutManager(context)

        vm.data?.observe(viewLifecycleOwner){
                contactList -> getStudents(contactList)
        }

        binding.transactionsCloseButton.setOnClickListener {
            dismiss()
        }

        return binding.root
    }

    fun getStudents(list: List<History>){
        historyList.clear()
        historyList.addAll(list)
        adapter.notifyDataSetChanged()
        if(adapter.itemCount == 0){
            binding.noItems.visibility = View.VISIBLE
        }
    }

}
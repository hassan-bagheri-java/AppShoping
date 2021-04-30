package  com.example.myapplication.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adpter.RecyclerShopAdapter
import com.example.myapplication.dataClass.DataProduct
import com.example.myapplication.dataClass.DataProductWebservice
import com.example.myapplication.dataClass.DataQuery
import com.example.myapplication.net.ApiService
import com.example.myapplication.presenter.PresenterShopFragment
import kotlinx.android.synthetic.main.fragment_shop.*
import org.jetbrains.anko.support.v4.toast
import org.koin.android.ext.android.inject
import retrofit2.*
import retrofit2.Response


class Shop_Fragment : Fragment() {

    private val presenter: PresenterShopFragment by inject()
    private lateinit var adapter: RecyclerShopAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progresbar: ProgressBar
    private val apiService: ApiService by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_shop, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        recyclerView = recyclerView_shop_fragment
        progresbar = progressBar_shop_fragment



        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        txt_clear_shop_list.setOnClickListener {
            val email = getEmail()
            val query  = "call delete_cartlist('${email}')"
            apiService.getAPi()
                .deleteAll_cart("insert", "${query}")
                .enqueue(object : Callback<DataQuery> {
                    override fun onFailure(call: Call<DataQuery>, t: Throwable) {
                        toast("خطا در دریافت طلاعات ازسرور")
                    }

                    override fun onResponse(call: Call<DataQuery>, response: Response<DataQuery>) {
                        val data = response.body()
                        if (data != null) {
                            Log.e("hassa222n", "${response}")
                            if (data.status == 200) {
                                adapter.refresh(listOf())
                                toast("لیست خالی شد.")
                                hideProgress()
                            } else
                                toast("خطا در دریافت طلاعات ازسرور")

                        }
                    }

                })
        }

        presenter.oncreate()







    }

    fun showToast(text: String) {
        toast(text)
    }

    fun setUpRecycler(data: List<DataProduct>) {

        adapter = RecyclerShopAdapter(data,context)
        recyclerView.adapter = adapter

    }

    fun showProgress() {

        progresbar.visibility = View.VISIBLE
        recyclerView.visibility = View.INVISIBLE
    }

    fun hideProgress() {

        progresbar.visibility = View.INVISIBLE
        recyclerView.visibility = View.VISIBLE
    }


    fun getEmail(): String? {
        val pref = context?.getSharedPreferences("pref", Context.MODE_PRIVATE)
        return pref?.getString("email", "default email")
    }

}
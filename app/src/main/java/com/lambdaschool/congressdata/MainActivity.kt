package com.lambdaschool.congressdata

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var layoutList: RecyclerView? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var listAdapter: OverviewListAdapter? = null

    private var context: Context? = null
    private lateinit var viewModel: CongresspersonListViewModel

    var themeId: Int = 0
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        themeUtils.onActivityCreateSetTheme(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this
        layoutList = findViewById(R.id.layout_list)
        layoutList!!.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        layoutList!!.layoutManager = layoutManager


        viewModel = ViewModelProviders.of(this).get(CongresspersonListViewModel::class.java!!)

        viewModel.overviewList?.observe(this, Observer { overviewList ->
            runOnUiThread {
                assert(overviewList != null)

                // using recycler view
                overviewList?.let {
                    listAdapter = OverviewListAdapter(overviewList)
                    layoutList!!.adapter = listAdapter
                }
            }
        })
    }

    override fun setTheme(themeId: Int) {
        super.setTheme(themeId)
        this.themeId = themeId
    }


    override fun onStart() {
        if (themeId != themeUtils.getcTheme(this)) {
            themeUtils.refreshActivity(this)
        }
        super.onStart()
    }

    override fun onResume() {
        if (themeId != themeUtils.getcTheme(this)) {
            themeUtils.refreshActivity(this)
        }
        super.onResume()
    }
}

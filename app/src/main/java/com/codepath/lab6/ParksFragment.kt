package com.codepath.lab6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "ParksFragment"
private const val API_KEY = BuildConfig.API_KEY
private const val PARKS_URL =
    "https://developer.nps.gov/api/v1/parks?api_key=\${API_KEY}"

class ParksFragment : Fragment() {
    private val parks = mutableListOf<Park>()
    private lateinit var parksRecyclerView: RecyclerView
    private lateinit var parksAdapter: ParksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_parks, container, false)

        // Add configurations for the RecyclerView and configure the adapter
        val layoutManager = LinearLayoutManager(context)
        parksRecyclerView = view.findViewById<RecyclerView>(R.id.parks)
        parksRecyclerView.layoutManager = layoutManager
        parksRecyclerView.setHasFixedSize(true)
        parksAdapter = ParksAdapter(view.context, parks)
        parksRecyclerView.adapter = parksAdapter

        return view
    }

    companion object {
        fun newInstance(): ParksFragment {
            return ParksFragment()
        }
    }
}
package com.example.jesusmartinez.uaxfragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by jesusmartinez on 27/12/15.
 */
public class WebListFragment extends ListFragment {

    ArrayAdapter <CharSequence> mAdapter;




    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View webFragment= getActivity().findViewById(R.id.web_fragment);
        mAdapter=ArrayAdapter.createFromResource(getActivity(),R.array.webs,android.R.layout.simple_list_item_1);
        setListAdapter(mAdapter);


    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }
}

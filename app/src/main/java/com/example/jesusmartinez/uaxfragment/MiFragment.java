package com.example.jesusmartinez.uaxfragment;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by jesusmartinez on 27/12/15.
 */
public class MiFragment extends Fragment {

    String [] webs= new String[] {"www.google.es","www.as.com"};
    ArrayAdapter<String> mAdapter;
    boolean singlecolumn;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,webs);
        ListView mlist=(ListView) getView().findViewById(R.id.milist);
        singlecolumn=getActivity().findViewById(R.id.web_fragment)==null;
        mlist.setAdapter(mAdapter);
        mlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getFragmentManager().findFragmentById(R.id.list_fragment).getActivity(), "Pulsado " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT);
                CharSequence url=parent.getAdapter().getItem(position).toString();
                Log.e("Pulsado",url.toString());

                if (singlecolumn) {
                   // Intent intent =new Intent(getActivity(),Otra.class);
                    //startActivity(intent);

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url.toString()));
                    startActivity(intent);
                }

                //me falta cargar el otro fragment
                      /*
                    switch (position) {
                    case (0): Intent intent =new Intent(getActivity(),Otra.class);
                        startActivity(intent);
                        break;

                    case (1):
                        Intent intent2 =new Intent(getActivity(),Otramas.class);
                        startActivity(intent2);
                }*/



            }
        });



    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mifragment,container,false);
    }



}

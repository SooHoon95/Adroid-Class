package com.example.bottonnavigationtest.ui.Address;

import android.content.Intent;
import android.media.tv.TvContentRating;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.bottonnavigationtest.Bean.AddressMember;
import com.example.bottonnavigationtest.NetworkTask.NetworkTask;
import com.example.bottonnavigationtest.R;
import com.example.bottonnavigationtest.databinding.FragmentAddressBinding;
import com.google.android.material.slider.Slider;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class AddressFragment extends Fragment {

//    private HomeViewModel homeViewModel;
//    private Context mContext;
    private ArrayList<AddressMember> members = null;
    private AddressAdapter adapter = null;

    private FragmentAddressBinding binding;
//    private LayoutInflater inflater;

    private ListView listView = null;
    private String urlAddr = null;
    private String macIP = "192.168.2.10";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_address,container,false);

//        adapter = new AddressAdapter(getActivity(),R.layout.address_list_custom_layout,members);

        listView = view.findViewById(R.id.list_Address);
        listView.setOnItemClickListener(mItemClickListener);
//        listView.setAdapter(adapter);

//        Intent intent = getActivity().getIntent();
//        macIP = intent.getStringExtra("macIP");
        urlAddr = "http://" + macIP + ":8080/project_address/select_name_list.jsp";
//        http://192.168.0.3:8080/project_address/select_name_list.jsp


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        connectGetData();
    }

    private void connectGetData() {

        try{
            NetworkTask networkTask = new NetworkTask(getActivity(), urlAddr, "select");
            Object obj = networkTask.execute().get();
            members = (ArrayList<AddressMember>) obj;
            adapter = new AddressAdapter(getActivity(), R.layout.address_list_custom_layout, members);
            Log.v("AA","Test");
            listView.setAdapter(adapter);

//            listView.setOnItemClickListener(onItemClickListener);
//            listView.setOnItemLongClickListener(onItemLongClickListener);


            Log.v("AA","3333");
        }catch (Exception e){
            e.printStackTrace();
            Log.v("AA","Error 1111");
        }
    }

    AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent;
            TextView textView = view.findViewById(R.id.address_list_name);
            TextView textView1 = view.findViewById(R.id.address_list_sNum);
            String name = textView.getText().toString();
            String sNum = textView1.getText().toString();

            intent = new Intent(getActivity(), AddressDetailActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("sNum",sNum );
            startActivity(intent);

            Toast.makeText(getActivity(), textView.getText().toString(), Toast.LENGTH_SHORT);

        }
    };
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
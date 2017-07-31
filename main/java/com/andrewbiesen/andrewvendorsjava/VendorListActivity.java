package com.andrewbiesen.andrewvendorsjava;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class VendorListActivity extends AppCompatActivity {

    private ListView vendorListView;
    private List<Vendor> allVendors;
    private VendorDataService vendorDataService;
    private VendorListAdapter vendorListAdapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vendor_list_view);

        GetViews();
        SetListeners();


        this.vendorDataService = new VendorDataService();

        Intent myIntent = getIntent();
        String myvalue = myIntent.getStringExtra("mygroup");

//        Toast.makeText(this, myvalue,
//                Toast.LENGTH_LONG).show();

        this.allVendors = this.vendorDataService.GetVendorsByGroup(myvalue);

        vendorListAdapt = new VendorListAdapter(this,this.allVendors);
        vendorListView.setAdapter(vendorListAdapt);
        vendorListView.setFastScrollEnabled(true);


    }

    public void GetViews(){
        this.vendorListView = (ListView)findViewById(R.id.VendorList);
    }

    public void SetListeners(){
        this.vendorListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //displayMessage(vendorListAdapt.getItem(position).email);
                CreatePopup(parent, view, position, id);
            }
        });
    }

    public void CreatePopup(AdapterView<?> parent, View view, int position, long id) {
        PopupMenu menu = new PopupMenu(VendorListActivity.this, view);
        menu.getMenu().clear();
        menu.getMenu().add(vendorListAdapt.getItem(position).contactNumber);
        menu.getMenu().add(vendorListAdapt.getItem(position).email);
        menu.getMenu().add(vendorListAdapt.getItem(position).website);

        menu.getMenuInflater().inflate(R.layout.vendor_menu, menu.getMenu());
        menu.show();


    }

    public void displayMessage(String msg){
        Toast.makeText(this, msg,
                Toast.LENGTH_LONG).show();
    }
}

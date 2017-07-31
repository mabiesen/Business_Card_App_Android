package com.andrewbiesen.andrewvendorsjava;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matthew on 7/14/17.
 */

public class VendorRepository {
    //First Create lists of vendors
    //next Add lists to Vendor groups

    Vendor hey = new Vendor("h","h","h","h","h","h");

    List<Vendor> allList = new ArrayList<Vendor>();

    VendorRepository(){
        CreateVendors();
    }

    public void CreateVendors(){
        //Not ideal data storage.  Order is: business, website, phone, grouptype, email, specialty
        // - Rental -

        this.allList.add(new Vendor("Magnanimous Media ", "https://magnanimousrentals.com", "312-465-2366", "EQUIPMENT RENTAL", "rentals@magnanimousrentals.com" ,"Low Budget Gear "));
        this.allList.add(new Vendor("Camera Ambassador ", "https://cameraambassador.com/", "773-791-6522", "EQUIPMENT RENTAL", "info@cameraambassador.com" ,"Boutique Indie Rental"));
        this.allList.add(new Vendor("Daufenbach Camera", "http://daufenbachcamera.com", "312-226-0042", "EQUIPMENT RENTAL", "rentals@daufenbachcamera.com" ,"Pro Camera Packages"));
        this.allList.add(new Vendor("Pro Gear ", "http://www.progearrental.com", "312-376-3770", "EQUIPMENT RENTAL", "info@progearrental.com" ,"Still Photography and lenses "));
        this.allList.add(new Vendor("Eleven04", "https://www.eleven04.net", "312-265-0616", "EQUIPMENT RENTAL", "rental@eleven04.net" ,"College Aimed Rental House "));
        this.allList.add(new Vendor("Product Productions ", "https://www.productproductions.com", "312-421-9030", "EQUIPMENT RENTAL", "info@productproductions.com" ,"Large Video and Live Event Rentals "));
        this.allList.add(new Vendor("Second City Sound ", "http://www.secondcitysound.com", "773-277-9320", "EQUIPMENT RENTAL", "info@secondcitysound.com" ,"Audio Rental and Expendables"));
        this.allList.add(new Vendor("Film Gear ", "http://www.filmgearchicago.com/index.html", "312-666-4300", "EQUIPMENT RENTAL", "Jacob@FilmgearChicago.com" ,"Grip Gear "));
        this.allList.add(new Vendor("Cinieverse ", "https://www.ver.com/ver_location/chicago/", "847-671-4966", "EQUIPMENT RENTAL", "mdupont@ver.com" ,"In conjunction with VER "));
        this.allList.add(new Vendor("Abelline Cine ", "http://www.abelcine.com/store/Rental-Equipment/", "877-880-4267", "EQUIPMENT RENTAL", "customerservice@abelcine.com" ,"Prossional Rental and Education "));
        this.allList.add(new Vendor("Drape Kings ", "http://drapekings.com/rental-quote-request/", "312-733-7660", "EQUIPMENT RENTAL", "info@drapekings.com" ,"Professional Drapping Rental "));


        // - Casting -



    }

    public List<Vendor> GetVendorsByType(String groupType){
        List<Vendor> returnList = new ArrayList<Vendor>();

        if(groupType.contains("ALL VENDORS")){
            return this.allList;
        } else{
            for(Vendor thisvendor : this.allList){
                if(thisvendor.group.contains(groupType)){
                    returnList.add(thisvendor);
                }
            }
            return returnList;
        }

    }



}

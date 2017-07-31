package com.andrewbiesen.andrewvendorsjava;

import java.util.List;

/**
 * Created by matthew on 7/14/17.
 */

public class VendorDataService {

    private static VendorRepository vendorRepository = new VendorRepository();

    public List<Vendor> GetVendorsByGroup(String groupName)
    {
        return vendorRepository.GetVendorsByType(groupName);
    }

}

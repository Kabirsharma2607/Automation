/*
 * Copyright (c) 2022. Anh Tester
 * Automation Framework Selenium
 */

package org.oyetest.dataprovider;

import org.oyetest.constants.FrameworkConstants;
import org.oyetest.helpers.ExcelHelpers;
import org.oyetest.helpers.SystemHelpers;
import org.oyetest.helpers.PropertiesHelpers;
import org.oyetest.projects.crm.models.ClientModel;
import org.oyetest.projects.crm.models.SignInModel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

public final class DataProviderManager {

    private DataProviderManager() {
        super();
        PropertiesHelpers.loadAllFiles();
    }

    @Test(dataProvider = "getSignInDataHashTable")
    public void testGetSignInData(Hashtable<String, String> data) {
        System.out.println("signInData.testCaseName = " + data.get(SignInModel.getTestCaseName()));
        System.out.println("signInData.username = " + data.get(SignInModel.getEmail()));
        System.out.println("signInData.password = " + data.get(SignInModel.getPassword()));
        System.out.println("signInData.expectedTitle = " + data.get(SignInModel.getExpectedTitle()));
        System.out.println("signInData.expectedError = " + data.get(SignInModel.getExpectedError()));

    }

    @Test(dataProvider = "getClientDataHashTable")
    public void testGetClientData(Hashtable<String, String> data) {
        System.out.println("clientData.TestCaseName = " + data.get(ClientModel.getTestCaseName()));
        System.out.println("clientData.CompanyName = " + data.get(ClientModel.getCompanyName()));
        System.out.println("clientData.OWNER = " + data.get(ClientModel.getOwner()));
        System.out.println("clientData.Address = " + data.get(ClientModel.getAddress()));
        System.out.println("clientData.CITY = " + data.get(ClientModel.getCity()));
        System.out.println("clientData.STATE = " + data.get(ClientModel.getState()));

    }

    @DataProvider(name = "getSignInDataHashTable", parallel = true)
    public static Object[][] getSignInData() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(SystemHelpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "SignIn", 1, 2);
        System.out.println("getSignInData: " + data);
        return data;
    }

    @DataProvider(name = "getClientDataHashTable", parallel = true)
    public static Object[][] getClientData() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(SystemHelpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "Client", 1, 2);
        System.out.println("getClientData: " + data);
        return data;
    }

}
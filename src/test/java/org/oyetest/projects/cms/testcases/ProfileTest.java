package org.oyetest.projects.cms.testcases;

import org.oyetest.common.BaseTest;
import org.oyetest.constants.FrameworkConstants;
import org.oyetest.helpers.ExcelHelpers;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest {

    @Test(priority = 1)
    public void TC_UpdateProfile() {
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "Login");
        getLoginPageCMS().loginSuccessWithCustomerAccount(excel.getCellData(4, "email"), excel.getCellData(4, "password"));
        getProfilePage().updateProfile();
    }

//    @Test(priority = 2)
//    public void updateEmail() {
//        excel = new ExcelHelpers();
//        excel.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "Login");
//        getLoginPageCMS().loginSuccessWithCustomerAccount(excel.getCellData(4, "email"), excel.getCellData(4, "password"));
//        getProfilePage().updateEmail();
//    }

    @Test(priority = 3)
    public void TC_AddNewAddress() {
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "Login");
        getLoginPageCMS().loginSuccessWithCustomerAccount(excel.getCellData(4, "email"), excel.getCellData(4, "password"));
        getProfilePage().addNewAddress();
    }
}

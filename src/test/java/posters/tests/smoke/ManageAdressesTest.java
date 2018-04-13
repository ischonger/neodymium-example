/**
 * 
 */
package posters.tests.smoke;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.xceptance.neodymium.util.DataUtils;

import posters.dataobjects.Address;
import posters.dataobjects.User;
import posters.flows.DeleteUserFlow;
import posters.flows.OpenHomePageFlow;
import posters.pageobjects.pages.browsing.HomePage;
import posters.pageobjects.pages.user.AccountBillingAddressPage;
import posters.pageobjects.pages.user.AccountOverviewPage;
import posters.pageobjects.pages.user.AccountShippingAddressPage;
import posters.pageobjects.pages.user.AddressesOverviewPage;
import posters.pageobjects.pages.user.LoginPage;
import posters.pageobjects.pages.user.RegisterPage;
import posters.tests.AbstractTest;

/**
 * @author schaefer
 */
public class ManageAdressesTest extends AbstractTest
{
    User user;

    Address address;

    @Before
    public void setup()
    {
        user = DataUtils.get(User.class);
        address = DataUtils.get(Address.class);
    }

    @Test
    public void testRegistering()
    {
        // Goto homepage
        HomePage homePage = OpenHomePageFlow.flow();
        homePage.validate();

        // Assure not logged in status
        homePage.userMenu.validateNotLoggedIn();

        // Goto login form
        LoginPage loginPage = homePage.userMenu.openLogin();
        loginPage.isExpectedPage();

        // Goto register form
        RegisterPage registerPage = loginPage.openRegister();
        registerPage.isExpectedPage();

        loginPage = registerPage.sendRegisterForm(user, user.getPassword());
        loginPage.validateSuccessfulRegistration();

        homePage = loginPage.sendLoginform(user);
        homePage.validateSuccessfulLogin(user);

        // Goto "My Account" > "My Addresses"
        AccountOverviewPage accountOverview = homePage.userMenu.openAccountOverview();
        accountOverview.isExpectedPage();
        AddressesOverviewPage addressOverview = accountOverview.openAddressesOverview();

        // Goto addShippingAddressToCustomer page
        AccountShippingAddressPage shippingAddressPage1 = addressOverview.openShippingAddress();
        shippingAddressPage1.isExpectedPage();
        shippingAddressPage1.newAddress(address);

        // Goto addBillingAddressToCustomer page
        AccountBillingAddressPage billingAddressPage1 = addressOverview.openBillingAddress();
        billingAddressPage1.isExpectedPage();
        billingAddressPage1.newAddress(address);

        // add more adresses
        AccountShippingAddressPage shippingAddressPage2 = addressOverview.openShippingAddress();
        shippingAddressPage2.isExpectedPage();
        shippingAddressPage2.fillAndSendAddressForm("James Doe", "James Doe Inc.",
                                                    "5-7 James Doe Shipping Street", "New York", "NY", "12345", "United States");

        AccountBillingAddressPage billingAddressPage2 = addressOverview.openBillingAddress();
        billingAddressPage2.isExpectedPage();
        billingAddressPage2.fillAndSendAddressForm("James Doe", "James Doe Inc.",
                                                   "5-7 James Doe Billing Street", "New York", "NY", "12345", "United States");

        AccountShippingAddressPage shippingAddressPage3 = addressOverview.openShippingAddress();
        shippingAddressPage3.isExpectedPage();
        shippingAddressPage3.fillAndSendAddressForm("Jack Doe", "Jack Doe Inc.",
                                                    "5-7 Jack Doe Shipping Street", "New York", "NY", "12345", "United States");

        AccountBillingAddressPage billingAddressPage3 = addressOverview.openBillingAddress();
        billingAddressPage3.isExpectedPage();
        billingAddressPage3.fillAndSendAddressForm("Jack Doe", "Jack Doe Inc.",
                                                   "5-7 Jack Doe Billing Street", "New York", "NY", "12345", "United States");

    }

    @After
    public void after()
    {
        DeleteUserFlow.flow(user);
    }
}

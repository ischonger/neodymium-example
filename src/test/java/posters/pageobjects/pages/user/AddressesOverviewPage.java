package posters.pageobjects.pages.user;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;
import posters.pageobjects.pages.browsing.AbstractBrowsingPage;

public class AddressesOverviewPage extends AbstractBrowsingPage
{
    private SelenideElement headline = $("#titleAddressOverview");

    private SelenideElement addNewShipAddrLink = $("#linkAddNewShipAddr");

    private SelenideElement AddNewBillAddrLink = $("#linkAddNewBillAddr");

    @Override
    @Step("ensure this is a address overview page")
    public void isExpectedPage()
    {
        headline.should(exist);
    }

    /**
     * @return
     */
    @Step("open new shipping address page")
    public AccountShippingAddressPage openShippingAddress()
    {
        // Open the addShippingAddressToCustomer page
        // Click on the link to Personal Data
        addNewShipAddrLink.scrollTo().click();
        return new AccountShippingAddressPage();
    }

    /**
     * @return
     */
    @Step("open new billing address page")
    public AccountBillingAddressPage openBillingAddress()
    {
        // Open the addBillingAddressToCustomer page
        // Click on the link to Personal Data
        AddNewBillAddrLink.scrollTo().click();
        return new AccountBillingAddressPage();
    }
}

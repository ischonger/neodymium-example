package posters.pageobjects.pages.user;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Context;

import io.qameta.allure.Step;

public class AccountShippingAddressPage extends AbstractAddressPage
{
    private SelenideElement newShippingAddressButton = $("#btnAddShippAddr");

    @Step("ensure this is a shipping address page")
    @Override
    public void isExpectedPage()
    {
        headline.should(exist);
        headline.should(exactText(Context.localizedText("AccountPages.AddANewShippingAddress")));
    }

    @Override
    public void validateStructure()
    {
        super.validateStructure();

        // 'Add new address'-button
        // Asserts that the Add new address button exists, is visible and has a descripting text
        newShippingAddressButton.should(visible);
        newShippingAddressButton.should(exactText(Context.localizedText("AccountPages.AddNewAddress")));
    }

    @Override
    void clickAddAddressButton()
    {
        newShippingAddressButton.scrollTo().click();
    }

}

package posters.pageobjects.pages.user;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import com.xceptance.neodymium.util.Context;

import io.qameta.allure.Step;
import posters.dataobjects.Address;
import posters.pageobjects.pages.browsing.AbstractBrowsingPage;

public abstract class AbstractAddressPage extends AbstractBrowsingPage
{
    static final protected SelenideElement headline = $(".h2");

    static final SelenideElement fullNameField = $("#fullName");

    static final SelenideElement companyField = $("#company");

    static final SelenideElement addressLineField = $("#addressLine");

    static final SelenideElement cityField = $("#city");

    static final SelenideElement stateField = $("#state");

    static final SelenideElement zipField = $("#zip");

    static final SelenideElement countryField = $("#country");

    @Step("enter Address object into page")
    public void fillAndSendAddressForm(String _fullName, String _company, String _addressLine, String _city, String _state, String _zip, String _country)
    {
        fullNameField.setValue(_fullName);
        companyField.setValue(_company);
        addressLineField.setValue(_addressLine);
        cityField.setValue(_city);
        stateField.setValue(_state);
        zipField.setValue(_zip);
        // is options field
        countryField.selectOption(_country);

        clickAddAddressButton();
    }

    @Step("enter Address object into page")
    public void newAddress(Address address)
    {
        fillAndSendAddressForm(address.getFullName(), address.getCompany(), address.getAddressLine(), address.getCity(), address.getState(), address.getZip(),
                               address.getCountry());
    }

    @Step("validate addShippingAddressToCustomer or addBillingAddressToCustomer page structure")
    @Override
    public void validateStructure()
    {
        super.validateStructure();

        // Address Page headline
        // Make sure the Headline is there and starts with a capital letter followed by at least 3 more symbols.
        headline.find("h2").should(matchText("[A-Z].{3,}"));
        // Full name field
        // Asserts the Full name field is visible and has a label displaying the value.
        fullNameField.find("label.control-label[for=fullName]").shouldHave(exactText(Context.localizedText("AccountPages.fullName")));
        fullNameField.shouldBe(visible);
        // Company field
        // Asserts the Company field is visible and has a label displaying the value.
        companyField.find("label.control-label[for=company]").shouldHave(exactText(Context.localizedText("AccountPages.company")));
        companyField.shouldBe(visible);
        // Address line field
        // Asserts the Address line field is visible and has a label displaying the value.
        addressLineField.find("label.control-label[for=addressLine]").shouldHave(exactText(Context.localizedText("AccountPages.addressLine")));
        addressLineField.shouldBe(visible);
        // City field
        // Asserts the City field is visible and has a label displaying the value.
        cityField.find("label.control-label[for=city]").shouldHave(exactText(Context.localizedText("AccountPages.city")));
        cityField.shouldBe(visible);
        // State field
        // Asserts the State field is visible and has a label displaying the value.
        stateField.find("label.control-label[for=state]").shouldHave(exactText(Context.localizedText("AccountPages.state")));
        stateField.shouldBe(visible);
        // Zip field
        // Asserts the State field is visible and has a label displaying the value.
        zipField.find("label.control-label[for=zip]").shouldHave(exactText(Context.localizedText("AccountPages.zip")));
        zipField.shouldBe(visible);
        // Country field
        // Asserts the State field is visible and has a label displaying the value.
        countryField.find("label.control-label[for=country]").shouldHave(exactText(Context.localizedText("AccountPages.country")));
        countryField.shouldBe(visible);
        // Country field
        // Asserts the State field is visible and has a label displaying the value.
        countryField.find("label.control-label[for=country]").shouldHave(exactText(Context.localizedText("AccountPages.country")));
        countryField.shouldBe(visible);
    }

    abstract void clickAddAddressButton();
}

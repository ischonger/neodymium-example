package com.xceptance.neodymium.scripting.template.selenide.component;

import static com.codeborne.selenide.Selenide.$;

public class Header extends AbstractComponent
{

    @Override
    protected boolean exists()
    {
        return $("body > header nav#globalNavigation").exists();
    }
}
/**
 * 
 */
package com.xceptance.neodymium.scripting.template.selenide.page;

/**
 * @author pfotenhauer
 */
public abstract class AbstractPageObject
{
    abstract public void validateStructure();

    protected boolean isExpectedPage()
    {
        return true;
    }
}
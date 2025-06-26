package StepDefinitions;

import Pages.DialogContent;
import Pages.TopNav;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _15_ProfileTheme {
    TopNav TN = new TopNav();
    DialogContent DC = new DialogContent();

    @And("The user selects all themes one by one and saves")
    public void selectAllThemesOneByOneAndSave() {
        TN.myClick(TN.themeDropdown);

        for (int i = 0; i < TN.themeOptions.size(); i++) {
            List<WebElement> currentOptions = TN.themeOptions;
            WebElement theme = currentOptions.get(i);

            TN.waitUntilVisible(theme);
            TN.myClick(theme);

            TN.waitUntilVisible(TN.saveButton);
            TN.scrollToElement(TN.saveButton);
            TN.clickWithJS(TN.saveButton);

            TN.myClick(TN.profileSettings);
            TN.myClick(TN.settings);
            TN.myClick(TN.themeDropdown);
        }
    }
}

package ru.sberbank.autotests.util;

import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.sberbank.autotests.steps.BaseSteps;
import ru.yandex.qatools.allure.annotations.Attachment;

public class AllureReporter extends  ru.yandex.qatools.allure.junit.AllureRunListener  {



        @Override
        public void testFailure(Failure failure) {
            takeScreeShot();
            super.testFailure(failure);
        }

        @Attachment(type = "image/png", value = "Скриншот ошибки")
        public byte[] takeScreeShot() {
            return ((TakesScreenshot) BaseSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
        }

    }

package com.application.functional.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ChromeDriverKiller {
    public static void killChromeDriverProcesses() {
        ProcessHandle.allProcesses()
                .filter(p -> p.info()
                        .command()
                        .map(c -> c.contains("chromedriver.exe"))
                        .orElse(false))
                .forEach(ProcessHandle::destroy);
    }
}

package com.application.functional.utils.browser.process;

import org.springframework.stereotype.Component;

@Component
public class EdgeDriverKiller {
    public void kill() {

        ProcessHandle.allProcesses()
                .filter(p -> p.info()
                        .command()
                        .map(c -> c.contains("msedgedriver.exe"))
                        .orElse(false))
                .forEach(ProcessHandle::destroy);
    }
}

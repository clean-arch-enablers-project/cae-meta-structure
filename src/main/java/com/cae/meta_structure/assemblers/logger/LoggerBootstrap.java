package com.cae.meta_structure.assemblers.logger;

import com.cae.loggers.Logger;
import com.cae.loggers.LoggerProvider;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoggerBootstrap {

    public static void startupSettings(Logger logger){
        LoggerProvider.SINGLETON
                .setProvidedInstance(logger)
                .setPortsLoggingIO(false)
                .setUseCasesLoggingIO(false)
                .structuredFormat(false)
                .async(false);
    }

}

/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.extension.siddhi.io.websocket.util;

import java.util.regex.Pattern;

/**
 * Logger event call back will be matching the pattern with each log event and
 * invoke receiver method for each matching event.
 */
public abstract class LoggerCallback {
    private String regexPattern;

    public LoggerCallback(String regexPattern) {
        this.regexPattern = regexPattern;
    }

    public abstract void receive(String logEventMessage);

    public void receiveLoggerEvent(String logEventMessage) {
        boolean isMatcherFound = Pattern.compile(regexPattern).matcher(logEventMessage).find();
        if (isMatcherFound) {
            receive(logEventMessage);
        }
    }
}

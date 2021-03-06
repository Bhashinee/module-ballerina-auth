/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.ballerinalang.stdlib.auth;

import io.ballerina.runtime.api.Environment;
import io.ballerina.runtime.api.creators.ValueCreator;
import io.ballerina.runtime.api.values.BMap;
import io.ballerina.runtime.api.values.BString;

/**
 * Extern function to get auth invocation context record.
 *
 */
public class GetInvocationContext {

    public static synchronized BMap<BString, Object> getInvocationContext(Environment env) {
        BMap<BString, Object> invocationContext =
                (BMap<BString, Object>) env.getStrandLocal(Constants.AUTH_INVOCATION_CONTEXT_PROPERTY);
        if (invocationContext == null) {
            invocationContext = ValueCreator.createRecordValue(Constants.AUTH_PACKAGE_ID,
                                                               Constants.RECORD_TYPE_INVOCATION_CONTEXT);
            env.setStrandLocal(Constants.AUTH_INVOCATION_CONTEXT_PROPERTY, invocationContext);
        }
        return invocationContext;
    }
}

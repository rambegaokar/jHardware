/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jutils.jhardware.info.memory;

import org.jutils.jhardware.info.processor.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Information related to CPU
 * 
 * @author Javier Garcia Alonso
 */
public final class UnixMemoryInfo extends AbstractMemoryInfo {

    protected Map<String, String> parseInfo(String rawData) {
        Map<String, String> processorDataMap = new HashMap<String, String>();
        String[] dataStringLines = rawData.split("\\r?\\n");

        for (final String dataLine : dataStringLines) {
            String[] dataStringInfo = dataLine.split(":");
            processorDataMap.put(dataStringInfo[0].trim(), (dataStringInfo.length == 2) ? dataStringInfo[1].trim() : "");
        }

        return processorDataMap;
    }    
}

/*
 * Copyright 2016 Javier Garcia Alonso.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jutils.jhardware.info.graphicscard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jutils.jhardware.info.HardwareInfo;
import org.jutils.jhardware.model.Display;
import org.jutils.jhardware.model.GraphicsCard;
import org.jutils.jhardware.model.GraphicsCardInfo;

/**
 * Information related to graphics card
 * 
 * @author Javier Garcia Alonso.
 */
public abstract class AbstractGraphicsCardInfo implements HardwareInfo {

    @Override
    public GraphicsCardInfo getInfo() {
        return buildFromDataMap(parseInfo());
    }
    
    protected abstract Map<String, String> parseInfo();
    
    protected GraphicsCardInfo buildFromDataMap(Map<String, String> dataMap) {
       GraphicsCardInfo info = new GraphicsCardInfo();
       
       List<GraphicsCard> graphicsCardList = new ArrayList<>();
        if (dataMap != null && !dataMap.isEmpty()) {
            int numOfGraphicsCard = Integer.parseInt(dataMap.get("numOfGraphicsCards"));
            for (int i = 0; i < numOfGraphicsCard; i++) {
                GraphicsCard graphicsCard = new GraphicsCard();
                
                graphicsCard.setName(dataMap.get("name_" + i));
                graphicsCard.setManufacturer(dataMap.get("manufacturer_" + i));
                graphicsCard.setChipType(dataMap.get("chip_type_" + i));
                graphicsCard.setDacType(dataMap.get("dac_type_" + i));
                graphicsCard.setDeviceType(dataMap.get("device_type_" + i));
                graphicsCard.setTemperature(dataMap.get("temperature_" + i));
                graphicsCard.setFanSpeed(dataMap.get("fan_speed_" + i));
                
                graphicsCardList.add(graphicsCard);
            }
        }
        info.setGraphicsCards(graphicsCardList);        
        
        return info;
    }
}

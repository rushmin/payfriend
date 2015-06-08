/*
 * Copyright 2011-2012 WSO2, Inc. (http://wso2.com)
 *
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

package demo.jaxrs.server;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement(name = "Animal")
public class Animal {
    private long id;
    private long worldPopulation;
    private String name;
    private String dateOfSpeciesIdentification;
    private ContinentNames continentNames;

    public ContinentNames getContinentNames() {
        return continentNames;
    }

    public void setContinentNames(ContinentNames continentNames) {
        this.continentNames = continentNames;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public String getDateOfSpeciesIdentification() {
        return dateOfSpeciesIdentification;
    }

    public void setDateOfSpeciesIdentification(String dateOfSpeciesIdentification) {
        this.dateOfSpeciesIdentification = dateOfSpeciesIdentification;
    }

    public long getWorldPopulation() {
        return worldPopulation;
    }

    public void setWorldPopulation(long worldPopulation) {
        this.worldPopulation = worldPopulation;
    }

    private String speciesName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
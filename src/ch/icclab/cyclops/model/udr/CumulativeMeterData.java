/*
 * Copyright (c) 2015. Zuercher Hochschule fuer Angewandte Wissenschaften
 *  All Rights Reserved.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License"); you may
 *     not use this file except in compliance with the License. You may obtain
 *     a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *     WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *     License for the specific language governing permissions and limitations
 *     under the License.
 */

package ch.icclab.cyclops.model.udr;

import java.util.Date;

/**
 * Author: Srikanta
 * Created on: 11-Dec-14
 * Description: A POJO class for CumulativeMeters from OpenStack's Ceilometer
 *
 * Change Log
 * Name        Date     Comments
 */
public class CumulativeMeterData {
    private String user_id, resource_id, meter, source, project_id, type, id, unit;
    private long volume;
    private long usage = 0;
    private Metadata metadata;
    private Date timestamp, recorded_at;

    public class Metadata{
        private String instance_id,mac, fref, name;
        private int instance_type;

        public String getInstance_id() {
            return instance_id;
        }

        public void setInstance_id(String instance_id) {
            this.instance_id = instance_id;
        }

        public String getMac() {
            return mac;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }

        public String getFref() {
            return fref;
        }

        public void setFref(String fref) {
            this.fref = fref;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getInstance_type() {
            return instance_type;
        }

        public void setInstance_type(int instance_type) {
            this.instance_type = instance_type;
        }
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getResource_id() {
        return resource_id;
    }

    public void setResource_id(String resource_id) {
        this.resource_id = resource_id;
    }

    public String getMeter() {
        return meter;
    }

    public void setMeter(String meter) {
        this.meter = meter;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public long getUsage() {
        return usage;
    }

    public void setUsage(long usage) {
        this.usage = usage;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getRecorded_at() {
        return recorded_at;
    }

    public void setRecorded_at(Date recorded_at) {
        this.recorded_at = recorded_at;
    }
}

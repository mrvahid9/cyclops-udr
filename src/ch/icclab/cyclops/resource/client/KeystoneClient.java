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


package ch.icclab.cyclops.resource.client;

import ch.icclab.cyclops.util.LoadConfiguration;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.Client;
import org.restlet.Request;
import org.restlet.data.Protocol;
import org.restlet.engine.header.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.resource.ClientResource;
import org.restlet.util.Series;

/**
 * Author: Srikanta
 * Created on: 08-Oct-14
 * Description: Requests the keystone service for a token to be used in transaction with Telemetry service of OpenStack
 *
 * Change Log
 * Name        Date     Comments
 */
public class KeystoneClient extends ClientResource {

    /**
     * Generates the token from Keystone service of OpenStack.
     *
     * Pseudo Code
     * 1. Load the auth details of keystone from the configuration object
     * 2. Create a RESTLET client and set the header info
     * 3. Send a POST request to the Keystone client
     * 4. Extract the token info from the response header
     *
     * @return
     */
    public String generateToken(){

        System.out.println("Generating the Token");

        Client client = new Client(Protocol.HTTP);
        LoadConfiguration load = new LoadConfiguration();
        String keystoneURL = load.configuration.get("KeystoneURL");
        String keystoneUsername = load.configuration.get("KeystoneUsername");
        String keystonePassword = load.configuration.get("KeystonePassword");
        String keystoneDomain = load.configuration.get("KeystoneDomainName");
        String keystoneProject = load.configuration.get("KeystoneProjectName");
        String reqBody = "{\"auth\": {\"identity\": {\"methods\": [\"password\"],\"password\": {\"user\": {\"domain\":{\"name\":\""+keystoneDomain+"\"},\"name\": \""+keystoneUsername+"\",\"password\": \""+keystonePassword+"\"}}},\"scope\": {\"project\": {\"domain\": {\"name\": \""+keystoneDomain+"\"},\"name\": \""+keystoneProject+"\"}}}}";
        ClientResource cr = new ClientResource(keystoneURL);
        JSONObject jsonObj = null;
        Series<Header> reqHeader = new Series<Header>(Header.class);
        Series<Header> responseHeader ;
        String token;

        try {
            jsonObj= new JSONObject(reqBody);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Request req = cr.getRequest();
        req.getAttributes().put(HeaderConstants.ATTRIBUTE_HEADERS, reqHeader);
        reqHeader.add("Accept", "application/json");
        reqHeader.add("Content-Type", "application/json");

        cr.post(jsonObj);

        responseHeader = (Series<Header>) cr.getResponse().getAttributes().get("org.restlet.http.headers");
        token = responseHeader.getFirst("X-Subject-Token").getValue();
        System.out.println("Auth Token " + responseHeader.getFirst("X-Subject-Token").getValue());

        return token;
    }
}

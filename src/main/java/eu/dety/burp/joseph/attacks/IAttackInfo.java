/**
 * JOSEPH - JavaScript Object Signing and Encryption Pentesting Helper
 * Copyright (C) 2016 Dennis Detering
 * <p>
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * <p>
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package eu.dety.burp.joseph.attacks;

import burp.IBurpExtenderCallbacks;
import burp.IHttpRequestResponse;
import burp.IRequestInfo;
import eu.dety.burp.joseph.utilities.JoseParameter;
import eu.dety.burp.joseph.utilities.JoseParameter.JoseType;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;

/**
 * Interface defining necessary methods for attack info classes
 * 
 * @author Dennis Detering
 * @version 1.0
 */
public interface IAttackInfo {

    /**
     * Prepare the attack by loading all necessary parameter
     * 
     * @param requestResponse
     *            {@link IHttpRequestResponse} requestResponse message
     * @param requestInfo
     *            {@link IRequestInfo} analyzed request
     * @param parameter
     *            {@link JoseParameter} JOSE parameter
     * @throws AttackPreparationFailedException
     *             if error occurs during preparation step
     * @return IAttack instance of attack
     */
    IAttack prepareAttack(IBurpExtenderCallbacks callbacks, IHttpRequestResponse requestResponse, IRequestInfo requestInfo, JoseParameter parameter)
            throws AttackPreparationFailedException;

    /**
     * Get unique attack ID
     * 
     * @return Unique identifier string
     */
    String getId();

    /**
     * Get attack name
     * 
     * @return Attack name string
     */
    String getName();

    /**
     * Get attack description
     * 
     * @return Attack description string
     */
    String getDescription();

    /**
     * Get the amount of requests to be performed
     * 
     * @return Amount of requests needed
     */
    int getAmountRequests();

    /**
     * Get additional UI components if further data is needed to perform the attack
     * 
     * @return True if attack provides extra UI elements
     */
    boolean getExtraUI(JPanel extraPanel, GridBagConstraints constraints);

    /**
     * Check whether attack is suitable based on algorithm and type values
     * 
     * @param type
     *            {@link JoseType} of the parameter
     * @param algorithm
     *            JOSE header algorithm value string
     * @return True if attack is suitable
     */
    boolean isSuitable(JoseType type, String algorithm);

    /**
     * Get IHttpRequestResponse object used for this attack
     * 
     * @return {@link burp.IHttpRequestResponse} object
     */
    IHttpRequestResponse getRequestResponse();

    /**
     * Get list of prepared {@link AttackRequest} objects
     * 
     * @return List with {@link AttackRequest} objects
     */
    List<? extends AttackRequest> getRequests();

    /**
     * Get list of available payloads
     * 
     * @return HashMap with PayloadType and explaining name
     */
    HashMap<String, ? extends Enum> getPayloadList();

    /**
     * Get HashMap with modified header, payload, signature values
     * 
     * @param payloadType
     *            The payload type identifier
     * @param header
     *            The header JSON string
     * @param payload
     *            The payload JSON string
     * @param signature
     *            The signature base64url string
     * @throws AttackPreparationFailedException
     *             if error occurs during preparation step
     * @return HashMap with modified header, payload, signature values
     */
    HashMap<String, String> updateValuesByPayload(Enum payloadType, String header, String payload, String signature) throws AttackPreparationFailedException;

}

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
package eu.dety.burp.joseph.attacks.__attack_template;

import eu.dety.burp.joseph.attacks.AttackRequest;

/**
 * Attack Template Attack Request
 * 
 * @author Dennis Detering
 * @version 1.0
 */
public class AttackTemplateAttackRequest extends AttackRequest {
    private String payload = null;

    public AttackTemplateAttackRequest(byte[] request, int payloadType, String payload) {
        super(request, payloadType);
        this.setPayload(payload);
    }

    /**
     * Get the payload
     * 
     * @return The payload as string
     */
    public String getPayload() {
        return payload;
    }

    /**
     * Set the payload
     * 
     * @param payload
     *            The payload as string
     */
    public void setPayload(String payload) {
        this.payload = payload;
    }

}

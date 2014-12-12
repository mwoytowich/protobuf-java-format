package com.googlecode.protobuf.format;
/*
   Redistribution and use in source and binary forms, with or without modification,
    are permitted provided that the following conditions are met:

        * Redistributions of source code must retain the above copyright notice,
          this list of conditions and the following disclaimer.
        * Redistributions in binary form must reproduce the above copyright notice,
          this list of conditions and the following disclaimer in the documentation
          and/or other materials provided with the distribution.
        * Neither the name of the NeuStar, Inc. nor the names of its contributors
          may be used to endorse or promote products derived from this software
          without specific prior written permission.

    THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
    "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
    LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
    A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
    OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
    SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
    LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
    DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
    THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
    (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
    OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

import org.codehaus.jackson.map.PropertyNamingStrategy;

public class CamelCaseStrategy extends PropertyNamingStrategy.PropertyNamingStrategyBase {

    @Override
    public String translate(String propertyName) {
        if(propertyName == null) {
            return null;
        } else if(propertyName.isEmpty()) {
            return propertyName;
        } else {
            StringBuilder str = new StringBuilder();
            str.append(Character.toLowerCase(propertyName.charAt(0)));
            int charIndex = 0;
            boolean makeUpper = false;
            while(++charIndex < propertyName.length()) {
                if(propertyName.charAt(charIndex) == '_') { // underscore signifies next word
                    makeUpper = true;
                } else {
                    str.append(makeUpper ? Character.toUpperCase(propertyName.charAt(charIndex)) :
                        propertyName.charAt(charIndex));
                    makeUpper = false;
                }
            }
            return str.toString();
        }
    }
}

/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.executeafm.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.gooddata.executeafm.afm.LocallyIdentifiable;
import com.gooddata.util.GoodDataToStringBuilder;

import static com.gooddata.util.Validate.notEmpty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName("measureHeaderItem")
public class MeasureHeaderItem implements LocallyIdentifiable {

    private final String name;
    private final String format;
    private final String localIdentifier;
    private String uri;
    private String identifier;

    public MeasureHeaderItem(final String name, final String format, final String localIdentifier) {
        this.name = name;
        this.format = format;
        this.localIdentifier = localIdentifier;
    }

    @JsonCreator
    public MeasureHeaderItem(@JsonProperty("name") final String name,
                             @JsonProperty("format") final String format,
                             @JsonProperty("localIdentifier") final String localIdentifier,
                             @JsonProperty("uri") final String uri,
                             @JsonProperty("identifier") final String identifier) {
        this.name = notEmpty(name, "name");
        this.format = notEmpty(format, "format");
        this.localIdentifier = notEmpty(localIdentifier, "localIdentifier");
        this.uri = uri;
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public String getLocalIdentifier() {
        return localIdentifier;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(final String uri) {
        this.uri = uri;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(final String identifier) {
        this.identifier = identifier;
    }

    public String toString() {
        return GoodDataToStringBuilder.defaultToString(this);
    }
}

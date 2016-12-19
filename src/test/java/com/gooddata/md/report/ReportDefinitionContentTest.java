/**
 * Copyright (C) 2004-2016, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.md.report;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.Collections;

import static com.gooddata.JsonMatchers.serializesToJson;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.MatchesPattern.matchesPattern;

public class ReportDefinitionContentTest {

    @Test
    public void testDeserialization() throws Exception {
        final InputStream is = getClass().getResourceAsStream("/md/report/gridReportDefinitionContent.json");
        final ReportDefinitionContent def = new ObjectMapper().readValue(is, ReportDefinitionContent.class);
        assertThat(def, is(notNullValue()));
        assertThat(def.getFormat(), is("grid"));
        assertThat(def.getGrid(), is(notNullValue()));
    }

    @Test
    public void testSerialization() throws Exception {
        final ReportDefinitionContent def = new GridReportDefinitionContent(
                new Grid(Collections.emptyList(), Collections.emptyList(),
                        Collections.emptyList()));
        assertThat(def, serializesToJson("/md/report/gridReportDefinitionContent-input.json"));
    }

    @Test
    public void testToStringFormat() {
        final ReportDefinitionContent def = new GridReportDefinitionContent(
                new Grid(Collections.emptyList(), Collections.emptyList(),
                        Collections.emptyList()));

        assertThat(def.toString(), matchesPattern(GridReportDefinitionContent.class.getSimpleName() + "\\[.*\\]"));
    }

}
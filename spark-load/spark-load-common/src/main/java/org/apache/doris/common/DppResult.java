// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.apache.doris.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Copied from Apache Doris org.apache.doris.sparkdpp.DppResult
 */
public class DppResult implements Serializable {

    public boolean isSuccess;

    public String failedReason;

    public long scannedRows;

    public long fileNumber;

    public long fileSize;

    public long normalRows;

    public long abnormalRows;

    public long unselectRows;

    // only part of abnormal rows will be returned
    public String partialAbnormalRows;

    public long scannedBytes;

    public DppResult() {
        isSuccess = true;
        failedReason = "";
        scannedRows = 0;
        fileNumber = 0;
        fileSize = 0;
        normalRows = 0;
        abnormalRows = 0;
        unselectRows = 0;
        partialAbnormalRows = "";
        scannedBytes = 0;
    }

    @JsonCreator
    public DppResult(@JsonProperty(value = "is_success", required = true) boolean isSuccess,
                              @JsonProperty(value = "failed_reason", required = true) String failedReason,
                              @JsonProperty(value = "scanned_rows", required = true) long scannedRows,
                              @JsonProperty(value = "file_number", required = true) long fileNumber,
                              @JsonProperty(value = "file_size", required = true) long fileSize,
                              @JsonProperty(value = "normal_rows", required = true) long normalRows,
                              @JsonProperty(value = "abnormal_rows", required = true) long abnormalRows,
                              @JsonProperty(value = "unselect_rows", required = true) long unselectRows,
                              @JsonProperty("partial_abnormal_rows") String partialAbnormalRows,
                              @JsonProperty("scanned_bytes") long scannedBytes) {
        this.isSuccess = isSuccess;
        this.failedReason = failedReason;
        this.scannedRows = scannedRows;
        this.fileNumber = fileNumber;
        this.fileSize = fileSize;
        this.normalRows = normalRows;
        this.abnormalRows = abnormalRows;
        this.unselectRows = unselectRows;
        this.partialAbnormalRows = partialAbnormalRows;
        this.scannedBytes = scannedBytes;
    }

}

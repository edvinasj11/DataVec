/*-
 *  * Copyright 2016 Skymind, Inc.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 */

package org.datavec.api.transform.analysis.columns;

import org.datavec.api.transform.ColumnType;
import org.nd4j.shade.jackson.annotation.JsonInclude;
import org.nd4j.shade.jackson.annotation.JsonSubTypes;
import org.nd4j.shade.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

/**
 * Interface for column analysis
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes(value = {@JsonSubTypes.Type(value = BytesAnalysis.class, name = "BytesAnalysis"),
                @JsonSubTypes.Type(value = CategoricalAnalysis.class, name = "CategoricalAnalysis"),
                @JsonSubTypes.Type(value = DoubleAnalysis.class, name = "DoubleAnalysis"),
                @JsonSubTypes.Type(value = IntegerAnalysis.class, name = "IntegerAnalysis"),
                @JsonSubTypes.Type(value = LongAnalysis.class, name = "LongAnalysis"),
                @JsonSubTypes.Type(value = StringAnalysis.class, name = "StringAnalysis"),
                @JsonSubTypes.Type(value = TimeAnalysis.class, name = "TimeAnalysis")})
public interface ColumnAnalysis extends Serializable {

    long getCountTotal();

    ColumnType getColumnType();

}

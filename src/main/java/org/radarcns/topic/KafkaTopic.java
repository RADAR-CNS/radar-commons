/*
 * Copyright 2017 The Hyve and King's College London
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

package org.radarcns.topic;

/**
 * Set of Avro Topics
 * It defines:<ul>
 * <li>a source topic containing collected data(e.g. input topic)</li>
 * <li>a topic where temporary results are stored before the end of the time window
 *     (e.g. in_progress)</li>
 * <li>an output topic that persists the aggregated results (e.g. input topic)</li>
 * </ul>
 */
public class KafkaTopic {
    private final String name;

    /**
     * @param name topic name inside the Kafka cluster
     */
    public KafkaTopic(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Kafka topic name may not be null");
        }
        this.name = name;
    }

    /**
     * @return topic name
     */
    public String getName() {
        return this.name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        KafkaTopic topic = (KafkaTopic) o;

        return name.equals(topic.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String toString() {
        return getName();
    }
}

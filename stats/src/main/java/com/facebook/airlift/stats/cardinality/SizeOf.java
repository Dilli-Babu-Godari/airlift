/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.airlift.stats.cardinality;

import org.openjdk.jol.info.ClassLayout;

/**
 * MRJAR base tier — compiled at --release 17, placed in the root of the JAR.
 *
 * <p>Provides a JVM-version-agnostic wrapper around jol-core's {@code ClassLayout.instanceSize()}.
 * This class is overridden for JDK 25+ runtimes by the versioned copy in
 * {@code META-INF/versions/25/}, which is compiled at --release 25.
 *
 * <p>Both tiers use jol-core 0.16 where {@code instanceSize()} returns {@code long}.
 * The explicit {@code (long)} cast here is a no-op but kept for readability to signal
 * that older jol-core (0.2) returned {@code int} and required a widening cast.
 */
final class SizeOf
{
    private SizeOf() {}

    /**
     * Returns the shallow instance size of the given class in bytes.
     * Compiled at Java 17 bytecode level (base MRJAR tier).
     *
     * @param clazz the class to measure
     * @return shallow instance size in bytes
     */
    static long instanceSize(Class<?> clazz)
    {
        // jol-core 0.16: instanceSize() returns long directly.
        // The explicit cast is a no-op and documents intent for reviewers
        // comparing against pre-0.16 code where the return was int.
        return (long) ClassLayout.parseClass(clazz).instanceSize();
    }
}

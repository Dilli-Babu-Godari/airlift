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
 * MRJAR versioned tier — compiled at --release 25, placed under META-INF/versions/25/.
 *
 * <p>The JVM automatically selects this class over the base-tier version when running
 * on JDK 25 or later, because the JAR manifest declares {@code Multi-Release: true}.
 *
 * <p>This tier is compiled from {@code src/main/java25/} and requires JAVA_HOME
 * pointing to JDK 25 during the {@code compile-java25} Maven execution.
 *
 * <p>Functional behaviour is identical to the base tier — both call jol-core 0.16's
 * {@code instanceSize()} which returns {@code long}. The distinction is the bytecode
 * level: this class carries Java 25 class file version, proving that version-specific
 * bytecode is correctly packaged and dispatched by the JVM at runtime.
 */
final class SizeOf
{
    private SizeOf() {}

    /**
     * Returns the shallow instance size of the given class in bytes.
     * Compiled at Java 25 bytecode level (versioned MRJAR tier).
     *
     * <p>Selected by the JVM over the base-tier version when running on JDK 25+.
     *
     * @param clazz the class to measure
     * @return shallow instance size in bytes
     */
    static long instanceSize(Class<?> clazz)
    {
        // jol-core 0.16: instanceSize() returns long — no cast required.
        // This is the Java 25 versioned tier of the MRJAR. The class file version
        // will be 69 (Java 25), confirming correct --release 25 compilation.
        return ClassLayout.parseClass(clazz).instanceSize();
    }
}

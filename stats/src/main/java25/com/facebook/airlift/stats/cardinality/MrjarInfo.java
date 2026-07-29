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

import java.util.SequencedCollection;

/**
 * MRJAR versioned tier — compiled at {@code --release 25}, placed under
 * {@code META-INF/versions/25/} in the JAR.
 *
 * <p>Uses {@link SequencedCollection} (introduced in Java 21, JEP 431).
 * This class <strong>cannot compile at {@code --release 17}</strong>:
 * <pre>
 *   error: cannot find symbol — class SequencedCollection
 * </pre>
 * That makes the MRJAR honest: the java25 tier contains genuinely new-JDK code.
 * Class file version produced: <strong>69</strong> (Java 25).
 */
final class MrjarInfo
{
    private MrjarInfo() {}

    /** Returns the JVM feature version (e.g. 25 on JDK 25). Available since Java 9. */
    static int runtimeFeatureVersion()
    {
        return Runtime.version().feature();
    }

    /**
     * Returns the first element using {@link SequencedCollection#getFirst()} — Java 21+ API.
     * Will not compile at {@code --release 17}.
     */
    static <T> T firstElement(SequencedCollection<T> collection)
    {
        return collection.getFirst();
    }

    /**
     * Returns the last element using {@link SequencedCollection#getLast()} — Java 21+ API.
     */
    static <T> T lastElement(SequencedCollection<T> collection)
    {
        return collection.getLast();
    }

    /**
     * Returns a reversed view using {@link SequencedCollection#reversed()} — Java 21+ API.
     */
    static <T> SequencedCollection<T> reversed(SequencedCollection<T> collection)
    {
        return collection.reversed();
    }
}

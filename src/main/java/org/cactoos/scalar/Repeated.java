/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017-2020 Yegor Bugayenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.cactoos.scalar;

import org.cactoos.Scalar;
import org.cactoos.func.FuncOf;

/**
 * Scalar that runs repeatedly for a number of times.
 *
 * @param <X> Type of output
 * @since 0.49.2
 */
public final class Repeated<X> implements Scalar<X> {

    /**
     * Scalar.
     */
    private final Scalar<? extends X> scalar;

    /**
     * Times to repeat.
     */
    private final int times;

    /**
     * Ctor.
     *
     * <p>If {@code max} is equal or less than zero {@link #value()} will return
     * an exception.</p>
     *
     * @param scalar Scalar to repeat.
     * @param times How many times.
     */
    public Repeated(final Scalar<? extends X> scalar, final int times) {
        this.scalar = scalar;
        this.times = times;
    }

    @Override
    public X value() throws Exception {
        return new org.cactoos.func.Repeated<>(
            new FuncOf<>(this.scalar),
            this.times
        ).apply(true);
    }
}

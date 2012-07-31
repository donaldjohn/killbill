/*
 * Copyright 2010-2012 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.ning.billing.usage.timeline.chunks;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ning.billing.usage.UsageTestSuite;

public class TestTimeBytesAndSampleBytes extends UsageTestSuite {

    @Test(groups = "fast")
    public void testGetters() throws Exception {
        final byte[] timeBytes = new byte[]{0x1, 0x2, 0x3};
        final byte[] sampleBytes = new byte[]{0xA, 0xB, 0xC};
        final TimeBytesAndSampleBytes timeBytesAndSampleBytes = new TimeBytesAndSampleBytes(timeBytes, sampleBytes);

        Assert.assertEquals(timeBytesAndSampleBytes.getTimeBytes(), timeBytes);
        Assert.assertEquals(timeBytesAndSampleBytes.getSampleBytes(), sampleBytes);
    }

    @Test(groups = "fast")
    public void testEquals() throws Exception {
        final byte[] timeBytes = new byte[]{0x1, 0x2, 0x3};
        final byte[] sampleBytes = new byte[]{0xA, 0xB, 0xC};

        final TimeBytesAndSampleBytes timeBytesAndSampleBytes = new TimeBytesAndSampleBytes(timeBytes, sampleBytes);
        Assert.assertEquals(timeBytesAndSampleBytes, timeBytesAndSampleBytes);

        final TimeBytesAndSampleBytes sameTimeBytesAndSampleBytes = new TimeBytesAndSampleBytes(timeBytes, sampleBytes);
        Assert.assertEquals(sameTimeBytesAndSampleBytes, timeBytesAndSampleBytes);

        final TimeBytesAndSampleBytes otherTimeBytesAndSampleBytes = new TimeBytesAndSampleBytes(sampleBytes, timeBytes);
        Assert.assertNotEquals(otherTimeBytesAndSampleBytes, timeBytesAndSampleBytes);
    }
}

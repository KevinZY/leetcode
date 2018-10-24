package com.zhangyang.leetcode.queue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zhangyang on 2018/10/24.
 */
public class LoopQueueTest {
    private ArrayLoopQueue loopQueue = new ArrayLoopQueue();

    @Test
    public void testLoopQueue() {
        Assert.assertTrue(loopQueue.offer(1));
        Assert.assertTrue(loopQueue.offer(2));
        Assert.assertTrue(loopQueue.offer(3));
        Assert.assertTrue(loopQueue.offer(4));
        Assert.assertFalse(loopQueue.offer(5));

        Assert.assertEquals(Integer.valueOf(1), loopQueue.peek());
        Assert.assertEquals(Integer.valueOf(1), loopQueue.poll());
        Assert.assertEquals(Integer.valueOf(2), loopQueue.peek());
        Assert.assertEquals(Integer.valueOf(2), loopQueue.poll());
        Assert.assertEquals(Integer.valueOf(3), loopQueue.peek());
        Assert.assertEquals(Integer.valueOf(3), loopQueue.poll());
        Assert.assertEquals(Integer.valueOf(4), loopQueue.peek());
        Assert.assertEquals(Integer.valueOf(4), loopQueue.poll());
        Assert.assertNull(loopQueue.peek());
        Assert.assertNull(loopQueue.poll());


    }
}
package com.waya.rocketmq.send;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * RocketMQ 同步发送消息
 *
 * @author BoJan
 * @version v 1.0
 * @date 2020/10/13 9:50
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception {
        //Instantiate with a producer group name
        DefaultMQProducer producer = new DefaultMQProducer("group-name");
        // specify name server addresses
        producer.setNamesrvAddr("localhost:9876");
        // launch the instance
        producer.start();

        for (int i = 0; i < 100; i++) {
            // create a message instance, specifying topic, tag  and message body
            Message message = new Message("TopicTest", // topic
                    "TagA",
                    ("hello" + i).getBytes(RemotingHelper.DEFAULT_CHARSET)
            );
            // Call send message to deliver message to one of broker
            SendResult result = producer.send(message);
            System.out.printf("%s%n", result);
        }
        //shut down producer if not use longer
        producer.shutdown();

    }
}

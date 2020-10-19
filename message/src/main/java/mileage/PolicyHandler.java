package mileage;

import mileage.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PolicyHandler {
    @Autowired
    MessageRepository messageRepository;


    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString) {

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverMemberJoined_SendMsg(@Payload MemberJoined memberJoined) {
        if (memberJoined.isMe() && Objects.equals(memberJoined.getMemberStatus(), "READY")) {
            Message message = new Message();


            System.out.println("##### listener SendMsg : " + memberJoined.toJson());

            message.setMemberId(memberJoined.getMemberId());
            message.setPhoneNo(memberJoined.getPhoneNo());
            message.setMessageContents("CONTENTS");
            message.setMessageStatus("READY");

            messageRepository.save(message);
        }
    }

}
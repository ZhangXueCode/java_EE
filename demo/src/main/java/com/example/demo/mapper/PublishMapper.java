package com.example.demo.mapper;

import com.example.demo.model.MessageInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface PublishMapper {

    @Insert("insert into message_info (`from`,`to`,`message`) values (#{from},#{to},#{message})")
    Integer publish(MessageInfo messageInfo);
}

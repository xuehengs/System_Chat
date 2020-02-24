package com.mon;

import java.io.StringWriter;

import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.pojo.Message;

/**
 * Encoder which encodes the object data into messages
 * which can be transported over the websocket connection.
 */
/**
 * 编码器
 * @author Administrator
 * 编码器的任务是将特定于应用程序的数据转换为可以传输到客户端端点的格式
 *
 */
public class EchoServerEncoder implements Encoder.Text<Message> {

  /**
   * Encode the instance of MyMessage into a JSON string.
   */
  @Override
  public String encode(Message myMsg) throws EncodeException {
    System.out.println("我是编码器");
    StringWriter writer = new StringWriter();
    //Makes use of the JSON Streaming API to build the JSON string.
    Json.createGenerator(writer)
            .writeStartObject()
            .write("username", myMsg.getUsername())
            .write("friend", myMsg.getFriend())
            .write("message", myMsg.getMessage())
            .write("send_user", myMsg.getSend_user())
            .writeEnd()
            .flush();
    System.out.println(writer.toString());
    return writer.toString();
  }

  @Override
  public void init(EndpointConfig config) {
  }

  @Override
  public void destroy() {
  }
}

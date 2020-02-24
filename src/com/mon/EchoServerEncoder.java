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
 * ������
 * @author Administrator
 * �������������ǽ��ض���Ӧ�ó��������ת��Ϊ���Դ��䵽�ͻ��˶˵�ĸ�ʽ
 *
 */
public class EchoServerEncoder implements Encoder.Text<Message> {

  /**
   * Encode the instance of MyMessage into a JSON string.
   */
  @Override
  public String encode(Message myMsg) throws EncodeException {
    System.out.println("���Ǳ�����");
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

package com.websocket;

import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.websocket.decoder.addDecoder;
import com.websocket.decoder.msg.actionMessage;
import com.websocket.encoders.addencoders;

/**
 * Websocket
 * @author Administrator
 *
 */
@ServerEndpoint(
		value="/action",
		decoders={ addDecoder.class },
		encoders={ addencoders.class}
		)
public class addEndpoint {

	/**
	 * 消息处理类
	 * @param message 消息实体类
	 * @param session 客户端session
	 */
	@OnMessage
	public void onMessage(actionMessage message,Session session){
		//根据不同的type指令进行不同的处理
		switch(message.getType()){
		case actionMessage.Instruct_add:
				//加法运算
				int[] nums=message.getNums();
				int sum=0;
				for(int num : nums){
					sum+=num;
				}
				actionMessage resutl=new actionMessage();
				resutl.setType(actionMessage.Instruct_sum);
				resutl.setSum(sum+"");
				//发送回客户端
				session.getAsyncRemote().sendObject(resutl);
			break;
		}
	}
}

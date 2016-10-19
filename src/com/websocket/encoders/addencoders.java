package com.websocket.encoders;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import com.websocket.decoder.msg.actionMessage;

/**
 * 组码类
 * 对发送出去的消息进行加密
 * 简单的加密下
 * @author Administrator
 *
 */
public class addencoders implements Encoder.Text<actionMessage> {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 加密方法
	 */
	@Override
	public String encode(actionMessage arg0) throws EncodeException {
		//格式化
		String resutl=null;
		switch (arg0.getType()) {
		case actionMessage.Instruct_sum:
			resutl="sum:"+arg0.getSum();
			break;
		default:
			break;
		}
		System.out.println("最后的结果"+resutl);
		return resutl;
	}

}

package com.websocket.decoder;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import com.websocket.decoder.msg.actionMessage;

/**
 * 解码类
 * 对发送到客户端的消息进行解码
 * @author Administrator
 *
 */
public class addDecoder implements Decoder.Text<actionMessage> {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 对消息进行解码
	 * willDecode值为真就执行
	 * 传递消息实体类会socket的消息处理类
	 */
	@Override
	public actionMessage decode(String str) throws DecodeException {
		//格式化消息
		String[] strs=str.split(":");
		String[] strNums=strs[1].split(",");
		System.out.println(strs.toString());
		int leng=strNums.length;
		int[] nums=new int[leng];
		for(int i=0;i<leng;i++){
			System.out.println(strNums[i]);
			nums[i]=Integer.parseInt(strNums[i]);
		}
		actionMessage msg=new actionMessage(strs[0], nums);
		return msg;
	}

	/**
	 * 消息的指令确定
	 * 对头个单词进行比较
	 */
	@Override
	public boolean willDecode(String str) {
		return str.startsWith(actionMessage.Instruct_add);
	}

}

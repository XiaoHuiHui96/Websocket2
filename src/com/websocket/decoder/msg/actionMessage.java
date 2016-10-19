package com.websocket.decoder.msg;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 消息的实体类
 * @author Administrator
 *
 */
public class actionMessage {
	
	/** 加法运算 */
	public static final String Instruct_add = "add";
	
	/** 结果 */
	public static final String Instruct_sum = "sum";
	
	
	/** 指令类型 */
	private String type;
	/** 数字集合 */
	private int[] nums;
	/** 结果 */
	private String sum;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public int[] getNums() {
		return nums;
	}
	public void setNums(int[] nums) {
		this.nums = nums;
	}
	
	public actionMessage(String type, int[] nums) {
		super();
		this.type = type;
		this.nums = nums;
	}
	public actionMessage() {
		super();
	}
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
}

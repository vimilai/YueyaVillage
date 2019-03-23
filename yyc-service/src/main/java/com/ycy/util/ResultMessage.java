package com.ycy.util;

public class ResultMessage {
		public final static String SUCCESS="success";
		public final static String FAIL="fail";
	
		private  String reslut;
		private  Object  content; 
		private  String  error;
		
		
		
		public String getReslut() {
			return reslut;
		}
		public void setReslut(String reslut) {
			this.reslut = reslut;
		}
		public Object getContent() {
			return content;
		}
		public void setContent(Object content) {
			this.content = content;
		}
		
		public String getError() {
			return error;
		}
		public void setError(String error) {
			this.error = error;
		}
		public ResultMessage(String reslut, String error) {
			super();
			this.reslut = reslut;
			this.error = error;
		}
		public ResultMessage(String reslut, Object content, String error) {
			super();
			this.reslut = reslut;
			this.content = content;
			this.error = error;
		}
		
		public static ResultMessage createSuccessMessage(Object content, String error) {
			return new ResultMessage(SUCCESS,content,error);
			
		}
		public static ResultMessage createErrorsMessage(Object content, String error) {
			return new ResultMessage(FAIL,content,error);
			
		}
}

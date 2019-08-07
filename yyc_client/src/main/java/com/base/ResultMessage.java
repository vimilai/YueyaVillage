package com.base;

public class ResultMessage {
		public final static Integer SUCCESS=1000;//返回成功
		public final static Integer FAIL=1001;//返回错误
		public final static Integer PARAMMISS=1002;//参数缺失
		public final static Integer NODATA=1003;//没有数据
		public static final Integer PARAMERROR = 1004;//参数错误
	
		private  Integer resultCode;
		private  Object  content; 
		private  String  error;
		
		
		
		
		
		
		public Integer getResultCode() {
			return resultCode;
		}
		public void setResultCode(Integer resultCode) {
			this.resultCode = resultCode;
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
		
		public ResultMessage(){}
		public ResultMessage(Integer reslut, String error) {
			super();
			this.resultCode = reslut;
			this.error = error;
		}
		public ResultMessage(Integer reslut, Object content, String error) {
			super();
			this.resultCode = reslut;
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

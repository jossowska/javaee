package com.jossowska.servletjspdemo.domain;


public class Survey {
	
		private String user;
		private String from;
		private String to;
		private String frequency;
		private String comments;
		
		public Survey() {
			super();
		}
		
		
		public Survey(String user,String from, String to, String frequency, String comments) {
			
			this.user = user;
			this.from = from;
			this.to = to;
			this.frequency = frequency;
			this.comments = comments;
		}
		
		public String getUser() {
			return user;
		}
		
		public void setUser(String user) {
			this.user = user;
		}
		
		public String getFrom() {
			return from;
		}
		
		public void setFrom(String from) {
			this.from = from;
		}
		
		public String getTo() {
			return to;
		}
		
		public void setTo(String to) {
			this.to = to;
		}
		
		public String getFrequency() {
			return frequency;
		}
		
		public void setFrequency(String frequency) {
			this.frequency = frequency;
		}
		
		public String getComments() {
			return comments;
		}
		
		public void setComments(String comments) {
			this.comments = comments;
		}
}

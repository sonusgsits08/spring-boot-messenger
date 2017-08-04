//package com.siyaram.message;
//import java.io.IOException;
//
//import org.springframework.stereotype.Component;
//
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.ConnectionFactory;
//
//
//public abstract class RabbitEndPoint {
//	protected Channel channel;
//    protected Connection connection;
//    protected String endPointName;    
//    public void setEndPoint(String endPointName) throws IOException{
//    	ConnectionFactory factory = new ConnectionFactory();
//		factory.setHost("localhost");
//		factory.setPort(15672);
//		connection = factory.newConnection();
//		channel = connection.createChannel();
//		channel.queueDeclare(endPointName,false,false,false,null);
//    }
//    public void close() throws IOException{
//    	this.channel.close();
//    	this.connection.close();
//    }
//}

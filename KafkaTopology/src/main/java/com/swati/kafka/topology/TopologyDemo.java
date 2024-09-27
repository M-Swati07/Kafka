package com.swati.kafka.topology;

import java.awt.Point;
import java.util.Properties;

import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;

public class TopologyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties kafkaProperties = new Properties();
		kafkaProperties.put(StreamsConfig.APPLICATION_ID_CONFIG, "oracle-word-count-stream");
		kafkaProperties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		
		StreamsBuilder builder = new StreamsBuilder();
		KStream<Object, Object> source = builder.stream("oracle-word-input");
		source.to("oracle-bengaluru");
		builder.stream("oracle-word-input").to("oracle-chennai");
		builder.stream("oracle-word-input").to("oracle-pune");
		
		Topology topology = builder.build();
		System.out.println(topology.describe());

	}

}
